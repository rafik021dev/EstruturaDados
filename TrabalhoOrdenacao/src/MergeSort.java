public class MergeSort implements Ordenador {

    @Override
    public String obterNome() {
        return "Merge Sort";
    }

    /**
     * Método Merge Sort
     * Ordena o vetor dividindo em partes menores e depois intercalando
     */
    @Override
    public ResultadoOrdenacao ordenar(int[] aVetor) {
        ResultadoOrdenacao oResultado = new ResultadoOrdenacao(obterNome());

        int[] aAuxiliar = new int[aVetor.length];
        ordenarRecursivo(aVetor, aAuxiliar, 0, aVetor.length - 1, oResultado);

        return oResultado;
    }

    /**
     * Divide o vetor em duas partes ate chegar em 1
     */
    private void ordenarRecursivo(int[] aVetor, int[] aAuxiliar, int iInicio, int iFim, ResultadoOrdenacao oResultado) {
        if (iInicio >= iFim) {
            return;
        }
        int iMeio = iInicio + (iFim - iInicio) / 2;
        ordenarRecursivo(aVetor, aAuxiliar, iInicio, iMeio, oResultado);
        ordenarRecursivo(aVetor, aAuxiliar, iMeio + 1, iFim, oResultado);
        intercalar(aVetor, aAuxiliar, iInicio, iMeio, iFim, oResultado);
    }

    /**
     * Junta duas partes ja ordenadas em uma parte maior ordenada.
     */
    private void intercalar(int[] aVetor, int[] aAuxiliar, int iInicio, int iMeio, int iFim, ResultadoOrdenacao oResultado) {
        for (int iIndice = iInicio; iIndice <= iFim; iIndice++) {
            aAuxiliar[iIndice] = aVetor[iIndice];
            oResultado.somarMovimentacao();
        }
        int iEsquerda = iInicio;
        int iDireita = iMeio + 1;
        int iPosicao = iInicio;
        while (iEsquerda <= iMeio && iDireita <= iFim) {
            oResultado.somarComparacao();
            if (aAuxiliar[iEsquerda] <= aAuxiliar[iDireita]) {
                aVetor[iPosicao] = aAuxiliar[iEsquerda];
                iEsquerda++;
            } else {
                aVetor[iPosicao] = aAuxiliar[iDireita];
                iDireita++;
            }
            oResultado.somarMovimentacao();
            iPosicao++;
        }
        while (iEsquerda <= iMeio) {
            aVetor[iPosicao] = aAuxiliar[iEsquerda];
            oResultado.somarMovimentacao();
            iEsquerda++;
            iPosicao++;
        }
    }
}
