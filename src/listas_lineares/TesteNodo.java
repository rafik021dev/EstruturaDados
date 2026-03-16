package listas_lineares;

public class TesteNodo {

    public static void main(String[] args) {
        Nodo nodo1 = new Nodo(5);
        Nodo nodo2 = new Nodo(6);
        Nodo nodo3 = new Nodo(8);

        nodo1.setProx(nodo2);
        nodo2.setProx(nodo3);

        int valorNodo2 = nodo1.getProx().getDado();
        int valorNodo3 = nodo1.getProx().getProx().getDado();

        System.out.println(valorNodo2);
        System.out.println(valorNodo3);
    }
}
