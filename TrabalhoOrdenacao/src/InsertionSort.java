public class InsertionSort implements Ordenador {

    @Override
    public String obterNome() {
        return "Insertion Sort";
    }

    /**
     * Método Insertion Sort
     * Ordena o vetor inserindo o valor na parte que já ta ordenada
     */
    @Override
    public ResultadoOrdenacao ordenar(int[] aVetor) {
        ResultadoOrdenacao oResultado = new ResultadoOrdenacao(obterNome());

        for (int iIndice = 1; iIndice < aVetor.length; iIndice++) {
            int iValorAtual = aVetor[iIndice];
            int iAnterior = iIndice - 1;
            // Desloca os valores maiores para abrir espaco para o valor atual.
            while (iAnterior >= 0) {
                oResultado.somarComparacao();
                if (aVetor[iAnterior] <= iValorAtual) {
                    break;
                }
                aVetor[iAnterior + 1] = aVetor[iAnterior];
                oResultado.somarMovimentacao();
                iAnterior--;
            }
            aVetor[iAnterior + 1] = iValorAtual;
            oResultado.somarMovimentacao();
        }
        return oResultado;
    }
}
