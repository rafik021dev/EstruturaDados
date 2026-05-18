package listas_lineares.TabelasHash.HashEncadeamento;

public class MainTarefa {
    public static void main(String[] args) {

        HashTable3 oHashTable = new HashTable3(10000);

        long tempoInicio = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            oHashTable.inserir("Chave" + i, String.valueOf(i));
        }

        long tempoFinal = System.currentTimeMillis();

        System.out.println(tempoFinal - tempoInicio);
    }

}
