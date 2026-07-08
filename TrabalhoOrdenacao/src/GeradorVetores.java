import java.util.Random;

public class GeradorVetores {
    
    /**
     * Gera um vetor ja ordenado de forma crescente.
     */
    public static int[] gerarOrdenado(int iQuantidade) {
        int[] aVetor = new int[iQuantidade];
        for (int iIndice = 0; iIndice < iQuantidade; iIndice++) {
            aVetor[iIndice] = iIndice;
        }
        return aVetor;
    }

    /**
     * Gera um vetor ordenado de forma decrescente.
     */
    public static int[] gerarInvertido(int iQuantidade) {
        int[] aVetor = new int[iQuantidade];
        for (int iIndice = 0; iIndice < iQuantidade; iIndice++) {
            aVetor[iIndice] = iQuantidade - 1 - iIndice;
        }
        return aVetor;
    }

    /**
     * Gera um vetor com valores aleatorios.
     */
    public static int[] gerarAleatorio(int iQuantidade, int iMaiorValor) {
        int[] aVetor = new int[iQuantidade];
        Random oGerador = new Random(20260624L + iQuantidade + iMaiorValor);
        for (int iIndice = 0; iIndice < iQuantidade; iIndice++) {
            aVetor[iIndice] = oGerador.nextInt(iMaiorValor + 1);
        }
        return aVetor;
    }

    /**
     * Copia o vetor para que cada algoritmo receba a mesma entrada.
     */
    public static int[] copiarVetor(int[] aOriginal) {
        int[] aCopia = new int[aOriginal.length];
        System.arraycopy(aOriginal, 0, aCopia, 0, aOriginal.length);
        return aCopia;
    }

    /**
     * Verifica se o vetor ficou ordenado corretamente.
     */
    public static boolean estaOrdenado(int[] aVetor) {
        for (int iIndice = 1; iIndice < aVetor.length; iIndice++) {
            if (aVetor[iIndice - 1] > aVetor[iIndice]) {
                return false;
            }
        }
        return true;
    }
}
