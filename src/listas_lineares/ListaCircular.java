package listas_lineares;

public class ListaCircular {

    private Nodo inicio;
    private Nodo fim;

    public Nodo getFim() {
        return fim;
    }

    public void setFim(Nodo fim) {
        this.fim = fim;
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

    public void inserirInicio(int valor) {
        Nodo oNovoNodo = new Nodo(valor);
        if(vazia()) {
            inicio = oNovoNodo;
            fim = oNovoNodo;
            fim.setProx(inicio);
        } else {
            oNovoNodo.setProx(inicio);
            inicio = oNovoNodo; //Atualiza o início
            fim.setProx(inicio); //Fim aponta para o novo início
        }
    }

    public void inserirFinal(int valor) {
        if(vazia()) {
            inserirInicio(valor);
        } else {
            Nodo oNovoNodo = new Nodo(valor);
            fim.setProx(oNovoNodo);
            fim = oNovoNodo;
            fim.setProx(inicio);
        }
    }

    public void mostrarLista() {
        if (vazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        Nodo oNodoAux = inicio;
        do {
            System.out.println(oNodoAux.getDado());
            oNodoAux = oNodoAux.getProx();
        } while (oNodoAux != inicio);
    }
}

