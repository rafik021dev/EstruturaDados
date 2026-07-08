public class CountingSort implements Ordenador {

    @Override
    public String obterNome() {
        return "Counting Sort";
    }

    /**
     * Método Counting Sort
     * Ordena contando quantas vezes cada valor aparece no vetor.
     */
    @Override
    public ResultadoOrdenacao ordenar(int[] aVetor) {
        ResultadoOrdenacao oResultado = new ResultadoOrdenacao(obterNome());

        if (aVetor.length == 0) {
            return oResultado;
        }
        int iMenor = aVetor[0];
        int iMaior = aVetor[0];
        //Encontra o menor e o maior valor do vetor
        for (int iIndice = 1; iIndice < aVetor.length; iIndice++) {
            oResultado.somarComparacao();
            if (aVetor[iIndice] < iMenor) {
                iMenor = aVetor[iIndice];
            }
            oResultado.somarComparacao();
            if (aVetor[iIndice] > iMaior) {
                iMaior = aVetor[iIndice];
            }
        }
        int iIntervalo = iMaior - iMenor + 1;
        int[] aContagem = new int[iIntervalo];
        //Conta a quantidade de vezes que cada valor aparece
        for (int iIndice = 0; iIndice < aVetor.length; iIndice++) {
            aContagem[aVetor[iIndice] - iMenor]++;
            oResultado.somarMovimentacao();
        }
        //Reconstrói o vetor com a quantidades contada
        int iPosicao = 0;
        for (int iIndice = 0; iIndice < aContagem.length; iIndice++) {
            while (aContagem[iIndice] > 0) {
                aVetor[iPosicao] = iIndice + iMenor;
                aContagem[iIndice]--;
                oResultado.somarMovimentacoes(2);
                iPosicao++;
            }
        }
        return oResultado;
    }
}
