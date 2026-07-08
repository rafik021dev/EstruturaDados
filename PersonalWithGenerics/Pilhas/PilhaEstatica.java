public class PilhaEstatica<T> {

    private T[] elementos;
    private int topo;
    private int capacidade;

    public PilhaEstatica(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.topo = -1; // -1 indica vazia
        this.capacidade = capacidade;
    }

    /**
     * Empilha um novo Elemento na Pilha.
     * 
     * @param oElemento
     */
    public void push(T oElemento) {
        topo++;
        elementos[topo] = oElemento;
    }

    /**
     * Remove e retorna o primeiro elemento da Pilha.
     * 
     * @return T
     */
    public T pop() {
        topo--;
        return elementos[topo];
    }

    /**
     * Espia o primeiro elemento da Pilha.
     */
    public T peek() {
        return elementos[topo];
    }

    /**
     * Verifica se a Pilha está vazia
     * 
     * @return boolean
     */
    public boolean vazia() {
        return topo == -1 ? true : false;
    }

    /**
     * Verifica se a Pilha está cheia
     * 
     * @return boolean
     */
    public boolean cheia() {
        return topo == capacidade - 1 ? true : false;
    }

    /**
     * Mostra os Elementos da Pilha.
     */
    public void mostrarPilha() {
        System.out.println("---Topo---");
        for (int i = topo; i >= 0; i--) {
            System.out.println(elementos[i]);
        }
        System.out.println("---Base---");
    }

    /**
     * Inverte uma String, empilhando os chars e desempilhando na ordem contrária.
     * @param sString
     */
    public void inverterTexto(String sString) {
        for (int i = 0; i < sString.length(); i++) {
            topo++;
            elementos[topo] = (T) Character.valueOf(sString.charAt(i));
        }
        for (int i = topo; i >= 0; i--) {
            System.out.print((char) elementos[i]);
        }
    }

}