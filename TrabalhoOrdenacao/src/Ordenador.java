public interface Ordenador {
    /**
     * Nome do algoritmo
     */
    String obterNome();

    /**
     * Ordena o vetor recebido
     */
    ResultadoOrdenacao ordenar(int[] aVetor);
}
