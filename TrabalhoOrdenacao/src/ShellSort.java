public class ShellSort implements Ordenador {

    @Override
    public String obterNome() {
        return "Shell Sort";
    }

    /**
     * Método Shell Sort
     * Ordena o vetor usando a ideia do Insertion Sort com gaps(saltos)
     */
    @Override
    public ResultadoOrdenacao ordenar(int[] aVetor) {
        ResultadoOrdenacao oResultado = new ResultadoOrdenacao(obterNome());
        // O gap diminui ate chegar em 1
        for (int iGap = aVetor.length / 2; iGap > 0; iGap = iGap / 2) {
            for (int iIndice = iGap; iIndice < aVetor.length; iIndice++) {
                int iValorAtual = aVetor[iIndice];
                int iPosicao = iIndice;
                // Desloca os valores maiores dentro do grupo formado pelo gap
                while (iPosicao >= iGap) {
                    oResultado.somarComparacao();
                    if (aVetor[iPosicao - iGap] <= iValorAtual) {
                        break;
                    }
                    aVetor[iPosicao] = aVetor[iPosicao - iGap];
                    oResultado.somarMovimentacao();
                    iPosicao -= iGap;
                }
                aVetor[iPosicao] = iValorAtual;
                oResultado.somarMovimentacao();
            }
        }
        return oResultado;
    }
}
