public class Resultado {
    private final int concursanteId;
    private final int juezId;
    private final int ronda;
    private final double puntuacion;
    private final String comentario;

    public Resultado(int concursanteId, int juezId, int ronda, double puntuacion, String comentario) {
        this.concursanteId = concursanteId;
        this.juezId = juezId;
        this.ronda = ronda;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public int getConcursanteId() {
        return concursanteId;
    }

    public int getJuezId() {
        return juezId;
    }

    public int getRonda() {
        return ronda;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public String getComentario() {
        return comentario;
    }
}