import java.util.Random;


public class Concursante {
    private final int id;
    private double puntuacionTotal;
    private final Random random = new Random();

    public Concursante(int id) {
        this.id = id;
        this.puntuacionTotal = 0;
    }

    public Receta prepararReceta(int ronda) {
        int tiempoPreparacion = 1 + random.nextInt(5); // 1-5 segundos
        System.out.printf("Concursante %d preparando receta para la ronda %d (Tiempo: %d segundos)%n",
                id, ronda, tiempoPreparacion);

        try {
            Thread.sleep(tiempoPreparacion * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return new Receta(id, ronda);
    }

    public void agregarPuntuacion(double puntuacion) {
        this.puntuacionTotal += puntuacion;
    }

    public int getId() {
        return id;
    }

    public double getPuntuacionTotal() {
        return puntuacionTotal;
    }
}