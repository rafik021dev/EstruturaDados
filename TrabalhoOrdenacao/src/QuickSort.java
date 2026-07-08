public class QuickSort implements Ordenador {

    @Override
    public String obterNome() {
        return "Quick Sort";
    }

    /**
     * Método Quick Sort
     * Ordena o vetor separando os valores menores e maiores que o pivô.
     */
    @Override
    public ResultadoOrdenacao ordenar(int[] aVetor) {
        ResultadoOrdenacao oResultado = new ResultadoOrdenacao(obterNome());
        ordenarRecursivo(aVetor, 0, aVetor.length - 1, oResultado);
        return oResultado;
    }

    /**
     * Faz uma partição do vetor e chama o metodo novamente para cada lado, de forma recursiva
     */
    private void ordenarRecursivo(int[] aVetor, int iInicio, int iFim, ResultadoOrdenacao oResultado) {
        if (iInicio >= iFim) {
            return;
        }
        int iEsquerda = iInicio;
        int iDireita = iFim;
        int iPivo = aVetor[iInicio + (iFim - iInicio) / 2];
        // Move os índices ate encontrar valores que precisam trocar de lado
        while (iEsquerda <= iDireita) {
            while (iEsquerda <= iFim) {
                oResultado.somarComparacao();
                if (aVetor[iEsquerda] >= iPivo) {
                    break;
                }
                iEsquerda++;
            }
            while (iDireita >= iInicio) {
                oResultado.somarComparacao();
                if (aVetor[iDireita] <= iPivo) {
                    break;
                }
                iDireita--;
            }
            if (iEsquerda <= iDireita) {
                if (iEsquerda != iDireita) {
                    trocar(aVetor, iEsquerda, iDireita, oResultado);
                }
                iEsquerda++;
                iDireita--;
            }
        }
        if (iInicio < iDireita) {
            ordenarRecursivo(aVetor, iInicio, iDireita, oResultado);
        }
        if (iEsquerda < iFim) {
            ordenarRecursivo(aVetor, iEsquerda, iFim, oResultado);
        }
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
