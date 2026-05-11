package listas_lineares.fila;

public interface IFila {

    void enqueue(int iDado);
    int dequeue();
    int peek();
    boolean vazia();
    void mostrarFila();

}
