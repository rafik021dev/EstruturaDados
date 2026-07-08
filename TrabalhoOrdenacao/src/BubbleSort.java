public class BubbleSort implements Ordenador {

    @Override
    public String obterNome() {
        return "Bubble Sort";
    }

    /**
     * Método Bubble Sort
     * Ordena o vetor comparando elementos vizinhos.
     * Se uma passada nao fizer troca, o vetor ja esta ordenado.
     */
    @Override
    public ResultadoOrdenacao ordenar(int[] aVetor) {
        ResultadoOrdenacao oResultado = new ResultadoOrdenacao(obterNome());

        for (int iFim = aVetor.length - 1; iFim > 0; iFim--) {
            boolean bTrocou = false;
            for (int iIndice = 0; iIndice < iFim; iIndice++) {
                oResultado.somarComparacao();
                if (aVetor[iIndice] > aVetor[iIndice + 1]) {
                    trocar(aVetor, iIndice, iIndice + 1, oResultado);
                    bTrocou = true;
                }
            }
            if (!bTrocou) {
                break;
            }
        }
        return oResultado;
    }

    /**
     * Troca dois valores de posicao dentro do vetor.
     */
    private void trocar(int[] aVetor, int iPrimeiro, int iSegundo, ResultadoOrdenacao oResultado) {
        int iTemporario = aVetor[iPrimeiro];
        aVetor[iPrimeiro] = aVetor[iSegundo];
        aVetor[iSegundo] = iTemporario;
        oResultado.somarMovimentacoes(3);
    }
}
