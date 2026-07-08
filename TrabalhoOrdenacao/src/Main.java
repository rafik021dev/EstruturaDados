public class Main {

    private static final int[] TAMANHOS = {100_000, 1_000_000};
    private static final int REPETICOES = 3;
    private static final int MAIOR_VALOR_ALEATORIO = 1_000_000;

    private static final Ordenador[] ALGORITMOS = {
            new BubbleSort(),
            new InsertionSort(),
            new SelectionSort(),
            new MergeSort(),
            new QuickSort(),
            new ShellSort(),
            new CountingSort()
    };

    public static void main(String[] args) {
        System.out.println("Algoritmos de Ordenacao");
        System.out.println("Repeticoes por teste: " + REPETICOES);

        for (int iQuantidade : TAMANHOS) {
            executarOrdenacao("Ordenado", GeradorVetores.gerarOrdenado(iQuantidade), REPETICOES);
            executarOrdenacao("Invertido", GeradorVetores.gerarInvertido(iQuantidade), REPETICOES);
            executarOrdenacao("Aleatorio", GeradorVetores.gerarAleatorio(iQuantidade, MAIOR_VALOR_ALEATORIO), REPETICOES);
        }
    }

    /**
     * Executa todos os algoritmos para um tipo de vetor
     *
     * @param sTipoVetor tipo do vetor testado
     * @param aVetorOriginal vetor usado em cada algoritmo
     * @param iRepeticoes quantidade de execucoes
     */
    private static void executarOrdenacao(String sTipoVetor, int[] aVetorOriginal, int iRepeticoes) {
        System.out.println();
        System.out.println("Tamanho: " + aVetorOriginal.length + " | Vetor: " + sTipoVetor);
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-16s %15s %15s %15s%n",
                "Algoritmo", "Comparacoes", "Movimentos", "Tempo medio");
        System.out.println("--------------------------------------------------------------------------");

        for (Ordenador oAlgoritmo : ALGORITMOS) {
            ResultadoOrdenacao oResultado = testarAlgoritmo(oAlgoritmo, aVetorOriginal, iRepeticoes);
            System.out.printf("%-16s %15d %15d %12.3f ms%n",
                    oResultado.getNomeAlgoritmo(),
                    oResultado.getComparacoes(),
                    oResultado.getMovimentacoes(),
                    oResultado.getTempoMedioMilissegundos());
        }
    }

    /**
     * Testa o algoritmo
     *
     * @param oAlgoritmo algoritmo que sera testado
     * @param aVetorOriginal vetor usado como base
     * @param iRepeticoes quantidade de repeticoes
     * @return resultado do algoritmo
     */
    private static ResultadoOrdenacao testarAlgoritmo(Ordenador oAlgoritmo, int[] aVetorOriginal, int iRepeticoes) {
        long lTotalComparacoes = 0;
        long lTotalMovimentacoes = 0;
        long lTotalTempo = 0;

        for (int i = 0; i < iRepeticoes; i++) {
            int[] aCopia = GeradorVetores.copiarVetor(aVetorOriginal);
            long lInicio = System.nanoTime();
            ResultadoOrdenacao oResultado = oAlgoritmo.ordenar(aCopia);
            long lFim = System.nanoTime();

            if (!GeradorVetores.estaOrdenado(aCopia)) {
                System.out.println("Erro: " + oAlgoritmo.obterNome() + " nao ordenou o vetor.");
            }

            lTotalTempo += lFim - lInicio;
            lTotalComparacoes += oResultado.getComparacoes();
            lTotalMovimentacoes += oResultado.getMovimentacoes();
        }

        ResultadoOrdenacao oMedia = new ResultadoOrdenacao(oAlgoritmo.obterNome());
        oMedia.setComparacoes(lTotalComparacoes / iRepeticoes);
        oMedia.setMovimentacoes(lTotalMovimentacoes / iRepeticoes);
        oMedia.setTempoMedioMilissegundos((lTotalTempo / (double) iRepeticoes) / 1_000_000.0);

        return oMedia;
    }
}
