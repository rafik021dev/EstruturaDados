package listas_lineares;

public class Nodo {

    private int dado;
    private Nodo prox;

    public Nodo(int dado) {
        super();
        this.dado = dado;
        this.prox = null;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    /**
     * Retorna o Próximo Nodo
     * @return Nodo
     */
    public Nodo getProx() {
        return prox;
    }

    public void setProx(Nodo prox) {
        this.prox = prox;
    }


}
