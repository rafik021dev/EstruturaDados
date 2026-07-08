public class ResultadoOrdenacao {

    private String nomeAlgoritmo;
    private long comparacoes;
    private long movimentacoes;
    private double tempoMedioMilissegundos;

    public ResultadoOrdenacao(String nomeAlgoritmo) {
        this.nomeAlgoritmo = nomeAlgoritmo;
    }

    public String getNomeAlgoritmo() {
        return nomeAlgoritmo;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

    public double getTempoMedioMilissegundos() {
        return tempoMedioMilissegundos;
    }

    public void setComparacoes(long comparacoes) {
        this.comparacoes = comparacoes;
    }

    public void setMovimentacoes(long movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public void setTempoMedioMilissegundos(double tempoMedioMilissegundos) {
        this.tempoMedioMilissegundos = tempoMedioMilissegundos;
    }

    /**
     * Soma a qtd de comparações feita pelo algoritmo.
     */
    public void somarComparacao() {
        comparacoes++;
    }

    /**
     * Soma a qtd de movimentações feita pelo algoritmo.
     */
    public void somarMovimentacao() {
        movimentacoes++;
    }

    /**
     * Soma varias movimentacoes de uma vez.
     */
    public void somarMovimentacoes(long quantidade) {
        movimentacoes += quantidade;
    }
}
