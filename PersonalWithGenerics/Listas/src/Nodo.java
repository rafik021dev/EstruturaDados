public class Nodo<T> {
    
    private T dado;
    private Nodo<T> proximo;

    public Nodo(T dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public T getDado() {
        return dado;
    }
    public void setDado(T dado) {
        this.dado = dado;
    }
    public Nodo<T> getProximo() {
        return proximo;
    }
    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        StringBuilder oStringBuilder = new StringBuilder();
        oStringBuilder.append("Nodo{");
        oStringBuilder.append("Dado=").append(dado);
        oStringBuilder.append(", Próximo=").append(proximo);
        oStringBuilder.append('}');
        return oStringBuilder.toString();
    }

    
}
