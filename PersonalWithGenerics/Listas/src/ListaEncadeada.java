public class ListaEncadeada<T> {
    
    private Nodo<T> inicio;
    private int tamanho;

    /**
     * Insere no Início da Lista
     * 
     * Complexidade : O(1) 
     * @param dado
     */
    public void inserirInicio(T oDado) {
        Nodo<T> oNodo = new Nodo<>(oDado);
        oNodo.setProximo(inicio);
        this.inicio = oNodo; 
        this.tamanho++;
    }

    /**
     * Insere no Final da Lista
     * 
     * Complexidade : O(n)
     * 
     * @param oDado
     */
    public void inserirFinal(T oDado) {
        Nodo<T> oNodo = new Nodo<>(oDado);
        Nodo<T> oNodoAux = inicio;
        while (oNodoAux.getProximo() != null) {
            oNodoAux = oNodoAux.getProximo();
        }
        oNodoAux.setProximo(oNodo);
    }

    /**
     * Percorre toda a lista e exibe ela no final
     * 
     * Complexidade : O(n)
     */
    public void mostrarLista() {
        Nodo<T> oNodoAux = inicio;
        while(oNodoAux != null) {
            System.out.println(oNodoAux.getDado());
            oNodoAux = oNodoAux.getProximo();
        } 
    }

    /**
     * Remove um Elemento da Lista
     * 
     * Complexidade : O(n)
     * 
     * @param oValor
     */
    public void removerValor(T oValor) {
        Nodo<T> oNodoAux = inicio;
        while(oNodoAux != null) {
            if (oNodoAux.getProximo().getDado() == oValor) {
                oNodoAux.setProximo(oNodoAux.getProximo().getProximo());
                return;
            }
            oNodoAux = oNodoAux.getProximo();
        }
    }

    /**
     * Retorna o tamanho da lista
     * 
     * @return int
     */
    public int getTamanho() {
        return this.tamanho;
    }

    /**
     * Retorna o tamanho da lista, percorrendo todos os valores.
     * 
     * Complexidade : O(n)
     */
    public void getTamanhoLista() {
        int iTamanho = 0;
        Nodo<T> oNodoAux = inicio;
        while(oNodoAux != null) {
            iTamanho++;
            oNodoAux = oNodoAux.getProximo();
        }
        System.out.println("O tamanho da Lista é: " + iTamanho);
    }

    /**
     * Exibe o valor do meio da lista.
     * 
     * Complexidade : O(n)
     */
    public void getMeioLista() {
        Nodo<T> oNodoAux = inicio;
        Nodo<T> oNodoAux2 = inicio;
        while (oNodoAux != null && oNodoAux2.getProximo() != null) {
            oNodoAux = oNodoAux.getProximo();
            oNodoAux2 = oNodoAux2.getProximo().getProximo();
        }
        System.out.println("Meio da Lista: " + oNodoAux.getDado());
    }

    /**
     * Transforma a Lista Encadeada em uma Lista Encadeada Circular.
     */
    public void transformarEmCircular() {
        Nodo<T> oNodoAux = inicio;
        while (oNodoAux.getProximo() != null) {
            oNodoAux = oNodoAux.getProximo();
        }
        oNodoAux.setProximo(inicio);
    }

    /**
     * Verifica se a Lista está vazia
     * 
     * @return boolean
     */
    public boolean isVazia() {
        return inicio == null;
    }

    @Override
    public String toString() {
        StringBuilder oStringBuilder = new StringBuilder();
        oStringBuilder.append("ListaEncadeada{");
        oStringBuilder.append("Início=").append(inicio);
        oStringBuilder.append('}');
        return oStringBuilder.toString();
    }

}
