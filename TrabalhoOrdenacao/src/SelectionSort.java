public class SelectionSort implements Ordenador {

    @Override
    public String obterNome() {
        return "Selection Sort";
    }

    /**
     * Método Selection Sort
     * Ordena o vetor procurando o menor valor da parte nao ordenada
     */
    @Override
    public ResultadoOrdenacao ordenar(int[] aVetor) {
        ResultadoOrdenacao oResultado = new ResultadoOrdenacao(obterNome());

        for (int iInicio = 0; iInicio < aVetor.length - 1; iInicio++) {
            int iIndiceMenor = iInicio;
            // Procura o menor elemento a partir da posicao atual
            for (int iIndice = iInicio + 1; iIndice < aVetor.length; iIndice++) {
                oResultado.somarComparacao();
                if (aVetor[iIndice] < aVetor[iIndiceMenor]) {
                    iIndiceMenor = iIndice;
                }
            }
            if (iIndiceMenor != iInicio) {
                trocar(aVetor, iInicio, iIndiceMenor, oResultado);
            }
        }
        return oResultado;
    }

    /**
     * Troca dois valores de posicao dentro do vetor
     */
    private void trocar(int[] aVetor, int iPrimeiro, int iSegundo, ResultadoOrdenacao oResultado) {
        int iTemporario = aVetor[iPrimeiro];
        aVetor[iPrimeiro] = aVetor[iSegundo];
        aVetor[iSegundo] = iTemporario;
        oResultado.somarMovimentacoes(3);
    }
}
