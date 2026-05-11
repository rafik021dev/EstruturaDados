package listas_lineares.fila;

public class Main {
    public static void main(String[] args) {

        System.out.println("Testando Fila Dinâmica");
        FilaDinamica oFilaDinamica = new FilaDinamica();
        oFilaDinamica.enqueue(55);
        oFilaDinamica.enqueue(66);
        oFilaDinamica.enqueue(77);
        oFilaDinamica.enqueue(88);
        oFilaDinamica.mostrarFila();
        oFilaDinamica.inverterFila(oFilaDinamica);
        oFilaDinamica.mostrarFila();
        System.out.println("Desenfileirando: " + oFilaDinamica.dequeue());
        oFilaDinamica.mostrarFila();

//        System.out.println("Testando Fila Estática");
//        IFila oFilaEstatica = new FilaEstatica(3);
//        oFilaEstatica.enqueue(10);
//        oFilaEstatica.enqueue(20);
//        oFilaEstatica.enqueue(30);
//        oFilaEstatica.mostrarFila();
//        System.out.println("Desenfileirando: " + oFilaEstatica.dequeue());

    }
}
