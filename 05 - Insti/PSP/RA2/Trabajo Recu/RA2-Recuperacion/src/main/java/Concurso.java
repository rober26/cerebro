import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurso {
    private final int numConcursantes;
    private final int numJueces;
    private final int numRondas;
    private final List<Concursante> concursantes;
    private final List<Juez> jueces;
    private final List<Resultado> resultados;
    private final Random random = new Random();

    public Concurso(int numConcursantes, int numJueces, int numRondas) {
        this.numConcursantes = numConcursantes;
        this.numJueces = numJueces;
        this.numRondas = numRondas;
        this.concursantes = new ArrayList<>();
        this.jueces = new ArrayList<>();
        this.resultados = new ArrayList<>();

        inicializarParticipantes();
    }

    private void inicializarParticipantes() {
        for (int i = 1; i <= numConcursantes; i++) {
            concursantes.add(new Concursante(i));
        }

        for (int i = 1; i <= numJueces; i++) {
            jueces.add(new Juez(i));
        }
    }

    public void iniciarConcurso() {
        ExecutorService executor = Executors.newFixedThreadPool(numConcursantes + numJueces);

        for (int ronda = 1; ronda <= numRondas; ronda++) {
            System.out.println("Iniando Ronda " + ronda);

            // Fase de preparación
            CountDownLatch preparacionLatch = new CountDownLatch(numConcursantes);
            List<Receta> recetas = Collections.synchronizedList(new ArrayList<>());

            for (Concursante concursante : concursantes) {
                int finalRonda = ronda;
                executor.execute(() -> {
                    Receta receta = concursante.prepararReceta(finalRonda);
                    recetas.add(receta);
                    preparacionLatch.countDown();
                });
            }

            try {
                preparacionLatch.await();
                System.out.println("\nTodos los concursantes han terminado de preparar sus recetas para la ronda " + ronda);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Fase de evaluación
            CountDownLatch evaluacionLatch = new CountDownLatch(numJueces * numConcursantes);

            for (Juez juez : jueces) {
                for (Receta receta : recetas) {
                    executor.execute(() -> {
                        Resultado resultado = juez.evaluarReceta(receta);
                        synchronized (resultados) {
                            resultados.add(resultado);
                        }
                        evaluacionLatch.countDown();
                    });
                }
            }

            try {
                evaluacionLatch.await();
                System.out.println("Los jueces han terminado de evaluar las recetas de la ronda " + ronda);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            mostrarResultadosRonda(ronda);
        }

        executor.shutdown();
    }

    private void mostrarResultadosRonda(int ronda) {
        System.out.println("Resultados de ronda " + ronda + ":");
        System.out.println("----------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-20s%n", "Concursante", "Juez", "puntuacion", "comentario");

        resultados.stream()
                .filter(r -> r.getRonda() == ronda)
                .forEach(r -> System.out.printf("%-15d %-15d %-15.1f %-20s%n",
                        r.getConcursanteId(), r.getJuezId(), r.getPuntuacion(), r.getComentario()));
    }

    public void mostrarResultadosFinales() {
        System.out.println("Resultados finales:");
        System.out.println("----------------------------------------");
        System.out.printf("%-15s %-15s%n", "concursante", "puntuacion Total");

        concursantes.stream()
                .sorted((c1, c2) -> Double.compare(c2.getPuntuacionTotal(), c1.getPuntuacionTotal()))
                .forEach(c -> System.out.printf("%-15d %-15.1f%n", c.getId(), c.getPuntuacionTotal()));

        Concursante ganador = concursantes.stream()
                .max((c1, c2) -> Double.compare(c1.getPuntuacionTotal(), c2.getPuntuacionTotal()))
                .orElse(null);

        System.out.println("A ganado el concursante " + ganador.getId() + " con " + ganador.getPuntuacionTotal() + "puntos");
    }
}
