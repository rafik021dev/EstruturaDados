package listas_lineares.TabelasHash;

public class HashTable2 {

    private class Entrada {
        String chave;
        String valor;

        public Entrada(String chave, String valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }
    private final double FATOR_DE_CARGA = 0.7;

    private Entrada[] array;
    private int tamanhoAtual;

    public HashTable2(int capacidadeInicial) {
        this.array = new Entrada[capacidadeInicial];
        this.tamanhoAtual = 0;
    }

    private int hash(String chave) {
        int hashCode = 0;
        for (byte b : chave.getBytes()) {
            hashCode += b;
        }
        return hashCode % array.length;
    }

    public void inserir(String chave, String valor) {
        if ((double) tamanhoAtual / array.length >= FATOR_DE_CARGA) {
            System.out.println("Fator de carga excedido. Redimensionar...");
            redimensionar();
        }
        int indiceBase =  hash(chave);
        int indice = indiceBase;
        int colisoes = 0;
        // O while é pra achar a próxima posição liberada para esse índice
        while (array[indice] != null && !array[indice].chave.equals(chave)) {
            colisoes++;
            System.out.println("Colisão. Tratamento de Colisões Ativado");
            System.out.println("Tentativa: " + colisoes);
            indice = (indiceBase + colisoes) % array.length;
        }
        if(array[indice] == null) {
            tamanhoAtual++;
        }
        array[indice] = new Entrada(chave, valor);
    }

    public String recuperar(String chave) {
        int indiceBase = hash(chave);
        int indice = indiceBase;
        int colisoes = 0;

        while(array[indice] != null) {
            if(array[indice].chave.equals(chave)) {
                return array[indice].valor;
            }
            colisoes++;
            indice = (indiceBase + colisoes) % array.length;
        }
        return "Chave não encontrada";
    }

    private void redimensionar() {
        Entrada[] aArrayAntigo = array;
        array = new Entrada[aArrayAntigo.length * 2];
        tamanhoAtual = 0;
        System.out.println("Nova capacidade do array: " + array.length);
        for (Entrada entrada : aArrayAntigo) {
            inserir(entrada.chave, entrada.valor);
        }
    }

    public void mostrarTabela() {
        for(int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                System.out.println("Índice ["+i+"] -> [VAZIO]");
            } else {
                System.out.println("Índice ["+i+"] -> {Chave: " + array[i].chave + " | Valor: " + array[i].valor + "}");
            }
        }
        System.out.println("--------------------------------");
    }
}
