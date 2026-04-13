package listas_lineares.fila;

public class FilaEstatica implements IFila {

    private int[] dados;
    private int tamanho;
    private int inicio;
    private int fim;
    private int capacidade;

    public FilaEstatica(int capacidade){
        this.capacidade = capacidade;
        dados = new int[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public boolean cheia() {
        return tamanho == capacidade;
    }

    @Override
    public void enqueue(int iDado) {
        if (cheia()) {
            System.out.println("Erro(Overflow): Fila cheia");
            return;
        }
        //Se o fim for 4 e a capacidade for 5: A conta será (4 + 1) % 5. = 0
        //O fim volta para o começo
        fim = (fim + 1) % capacidade;
        dados[fim] = iDado;
        tamanho++;
    }

    @Override
    public int dequeue() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return -1;
        }
        int iValorRemovido = dados[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return iValorRemovido;
    }

    @Override
    public int peek() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return -1;
        }
        return dados[inicio];
    }

    @Override
    public void mostrarFila() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return;
        }
        int iCont = inicio;
        while (iCont < tamanho) {
            System.out.print(dados[iCont] + " ");
            iCont = (iCont + 1) % capacidade; //Caminha de forma circular
            iCont++;
        }
        System.out.println("<- Final");
    }

}

