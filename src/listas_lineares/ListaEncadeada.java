package listas_lineares;

public class ListaEncadeada {

    private Nodo inicio;

    //Constructor
    public ListaEncadeada() {
        inicio = null;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public boolean vazia() {
        return inicio == null;
    }


    public void inserirInicio(int dado) {
        Nodo novoNodo = new Nodo(dado);
        novoNodo.setProx(inicio);
        inicio = novoNodo;
    }

    public void inserirFinal(int dado) {
        if (vazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        Nodo oNovoNodo = new Nodo(dado);
        Nodo oNodoAux = inicio;
        while (oNodoAux.getProx() != null) {
            oNodoAux = oNodoAux.getProx();
        }
        oNodoAux.setProx(oNovoNodo);
    }

    public void mostrarLista() {
        if (vazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        Nodo oNodoAux = inicio;
        while (oNodoAux != null) {
            System.out.println(oNodoAux.getDado());
            oNodoAux = oNodoAux.getProx();
        }
    }

    public void removerValor(int iValor) {
        if (vazia()) return;
        if(inicio.getDado() == iValor) {
            inicio = inicio.getProx();
            return;
        }
        Nodo oNodoAux = inicio;
        while(oNodoAux.getProx() != null) {
            if(oNodoAux.getProx().getDado() == iValor) {
                oNodoAux.setProx(oNodoAux.getProx().getProx());
                return;
            }
            oNodoAux = oNodoAux.getProx();
        }
    }

    public void imprimirMeio() {
        if (vazia()) {
            System.out.println("Lista Vazia");
            return;
        }

        Nodo oNodoUm = inicio;
        Nodo oNodoDois = inicio;

        while (oNodoDois != null && oNodoDois.getProx() != null) {
            oNodoUm = oNodoUm.getProx();
            oNodoDois = oNodoDois.getProx().getProx();
        }

        System.out.println("Nodo do meio: " + oNodoUm.getDado());
    }

    public void transformarEmCircular() {
        if (vazia()) {
            System.out.println("Lista Vazia");
            return;
        }

        Nodo oNodoAux = inicio;

        while (oNodoAux.getProx() != null) {
            oNodoAux = oNodoAux.getProx();
        }
        oNodoAux.setProx(inicio);
    }
}
