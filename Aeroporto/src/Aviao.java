public class Aviao {

    private int id;
    private int reservaCombustivel;
    private int tempoChegada;
    private boolean emergencia;

    public Aviao(int id, int reservaCombustivel, int tempoChegada) {
        this.id = id;
        this.reservaCombustivel = reservaCombustivel;
        this.tempoChegada = tempoChegada;
        this.emergencia = false;
    }

    public int getId() {
        return id;
    }

    public int getReservaCombustivel() {
        return reservaCombustivel;
    }

    public void setReservaCombustivel(int reservaCombustivel) {
        this.reservaCombustivel = reservaCombustivel;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public boolean isEmergencia() {
        return emergencia;
    }

    public void setEmergencia(boolean emergencia) {
        this.emergencia = emergencia;
    }

    @Override
    public String toString() {
        if (reservaCombustivel == -1) {
            return "#" + id;
        }
        return "#" + id + "(f:" + reservaCombustivel + ")";
    }
}