package listas_lineares.TabelasHash;

public class Main {

    public static void main(String[] args) {
        HashTable oTabelaHash = new HashTable(5);
        oTabelaHash.inserir("UVA", "R$8,00");
        oTabelaHash.inserir("MACA", "R$5,00");
        oTabelaHash.mostrarTabela();
        oTabelaHash.recuperar("UVA");
    }
}
