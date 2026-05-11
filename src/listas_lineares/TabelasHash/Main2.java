package listas_lineares.TabelasHash;

public class Main2 {
    public static void main(String[] args) {
        HashTable2 oAgenda = new HashTable2(4);
        oAgenda.inserir("ANA", "(47)99999-1111");
        oAgenda.inserir("ALICE", "(47)99999-2222");

        oAgenda.mostrarTabela();
        //CELIA e ALICE tem as mesmas letras = Colisão
        oAgenda.inserir("CELIA", "(47)99999-3333");
        oAgenda.mostrarTabela();

        //Corrigir pois está dando erro no redimensionamento
        oAgenda.inserir("BRUNO", "(47)99999-4444");
        oAgenda.mostrarTabela();
    }
}
