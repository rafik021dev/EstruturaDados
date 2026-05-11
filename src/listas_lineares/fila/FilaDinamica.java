package listas_lineares.fila;

import listas_lineares.Nodo;
import listas_lineares.pilha.IPilha;
import listas_lineares.pilha.PilhaDinamica;

public class FilaDinamica implements IFila{

    private Nodo inicio;
    private Nodo fim;

    FilaDinamica(){
        inicio = null;
        fim = null;
    }

    @Override
    public void enqueue(int iDado) {
        Nodo oNovoNodo = new Nodo(iDado);
        if(vazia()){
            inicio = oNovoNodo;
            fim = oNovoNodo;
            return;
        }

        fim.setProx(oNovoNodo);
        fim = oNovoNodo;
    }

    @Override
    public int dequeue() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return -1;
        }
        int iValorRemovido = inicio.getDado();
        inicio = inicio.getProx();

        if(inicio == null){
            fim = null;
        }
        return iValorRemovido;
    }

    @Override
    public int peek() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return -1;
        }
        return inicio.getDado();
    }

    @Override
    public boolean vazia() {
        return inicio == null;
    }

    @Override
    public void mostrarFila() {
        if(vazia()) {
            System.out.println("Fila vazia");
            return;
        }

        Nodo oNodoAux = inicio;
        while(oNodoAux != null){
            System.out.print(oNodoAux.getDado() + " ");
            oNodoAux = oNodoAux.getProx();
        }
        System.out.println("<-Final");
    }

    public void inverterFila(FilaDinamica oFila) {
        if(vazia()){
            System.out.println("Fila vazia");
            return;
        }
        IPilha oPilhaAux = new PilhaDinamica();
        //Esvazia a fila na Pilha
        while(!oPilhaAux.vazia()){
            oPilhaAux.push(oFila.dequeue());
        }
        //Esvazia a pilha de volta na fila com a ordem já invertida
        while(!oPilhaAux.vazia()){
            oFila.enqueue(oPilhaAux.pop());
        }
        oFila.mostrarFila();
    }
}
