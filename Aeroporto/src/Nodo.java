public class Nodo {

    private Aviao dado;
    private Nodo prox;

    public Nodo(Aviao dado) {
        this.dado = dado;
        this.prox = null;
    }

    public Aviao getDado() {
        return dado;
    }

    public void setDado(Aviao dado) {
        this.dado = dado;
    }

    public Nodo getProx() {
        return prox;
    }

    public void setProx(Nodo prox) {
        this.prox = prox;
    }
}