import java.util.Random;


public class Juez {
    private final int id;
    private final Random random = new Random();
    private final String[] comentarios = {
            "Buen sabor", "Buena presentacion", "Falta sazon",
            "Creativo", "Bien cocinado", "Esta salado",
            "Buen sabor", "Textura mejorable", "Buena convinacion",
            "Buen uso de especias", "Poco innovador", "Temperatura perfecta"
    };

    public Juez(int id) {
        this.id = id;
    }

    public Resultado evaluarReceta(Receta receta) {
        int tiempoEvaluacion = 2 + random.nextInt(2); // 2-3 segundos
        System.out.printf("Juez %d evaluando receta del concursante %d (Ronda %d)%n",
                id, receta.getConcursanteId(), receta.getRonda());

        try {
            Thread.sleep(tiempoEvaluacion * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        double puntuacion = 1 + random.nextDouble() * 9; // 1.0 - 10.0
        String comentario = comentarios[random.nextInt(comentarios.length)];

        return new Resultado(
                receta.getConcursanteId(),
                id,
                receta.getRonda(),
                puntuacion,
                comentario
        );
    }
}