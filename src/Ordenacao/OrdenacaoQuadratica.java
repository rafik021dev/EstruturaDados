package Ordenacao;

import java.util.Arrays;

public class OrdenacaoQuadratica {

    public static void selectionSort(int [] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n; i++) {
            int indiceMenor = i;

            //Busca menor elemento na parte não ordenada
            for (int j = i; j < n; i++) {
                if(vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
            }
        }
    }

    public static void insertionSort(int[] vetor) {
        int n = vetor.length;

        for (int i = 1; i < n; i++) {
            int chave = vetor[i];
            int j = i -1;
            while(j>=0 && vetor[j] > chave) {
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
    }


    public static void main(String[] args) {
        //Vetor original desordenado
        int[] dadosOriginais = {64, 34, 25, 12, 37, 5, 14};

        int[] vetorSelection = dadosOriginais;
        //selectionSort(vetorSelection);
        //System.out.println("Selection Sort" + Arrays.toString(vetorSelection));

        int[] vetorInsertion = dadosOriginais.clone();
        //insertionSort(vetorInsertion);
        //System.out.println("Insertion Sort: " + Arrays.toString(vetorInsertion));
    }
}
