
public class Receta {
    private final int concursanteId;
    private final int ronda;

    public Receta(int concursanteId, int ronda) {
        this.concursanteId = concursanteId;
        this.ronda = ronda;
    }

    public int getConcursanteId() {
        return concursanteId;
    }

    public int getRonda() {
        return ronda;
    }
}