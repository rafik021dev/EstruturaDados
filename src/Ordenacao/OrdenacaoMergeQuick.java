package Ordenacao;

import java.util.Arrays;

public class OrdenacaoMergeQuick {

    public static void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSortRecursivo(array, 0, array.length -1);
    }

    private static void quickSortRecursivo(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            //Posiciona elementos em relação ao pivô e obtém o índice de corte.
            int pontoDeCorte = particao(array, inicio, fim);

            quickSortRecursivo(array, inicio, pontoDeCorte);
            quickSortRecursivo(array, pontoDeCorte + 1, fim);
        }
    }

    private static int particao(int[] array, int inicio, int fim) {
        //1. Definição do Pivô
        int meio = (inicio + fim) / 2;
        int pivo = array[meio];

        //2. Inicialização dos ponteiros nas extremidades do escopo atual
        int i = inicio;
        int j = fim;

        while (true) {
            //Avalia o ponteiro "i" até encontrar um elemento menor ou igual os pivô
            while (array[i] < pivo) {
                i++;
            }
            //Recua o ponteiro "j" até encontrar um elemento menor ou igual ao pivô
            while (array[j] < pivo) {
                j--;
            }
            if (i >= j) {
                return j;
            }

            //3. Operação de troca para reaequar os elementos mal posicionados.
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            //Incremento para evitar laço infinito após troca de elementos iguais ao pivô
        }
    }

    public static void main(String[] args) {
        int[] dadosOriginais = {64, 34, 25, 12, 37, 5, 14};

        System.out.println("==========================");
        System.out.println("Quick Sort");

        // Exibindo os dados ANTES da ordenação
        System.out.println("Array original: " + Arrays.toString(dadosOriginais));

        long inicioQuick = System.nanoTime();

        OrdenacaoMergeQuick.quickSort(dadosOriginais);

        long fimQuick = System.nanoTime();

        // Exibindo os dados DEPOIS da ordenação
        System.out.println("Array ordenado: " + Arrays.toString(dadosOriginais));
        System.out.println("Tempo de Execução (ns): " + (fimQuick - inicioQuick));
        System.out.println("==========================");
    }
}
