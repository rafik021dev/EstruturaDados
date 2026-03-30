package listas_lineares;

public class TesteListaEncadeada {

    public static void main(String[] args) {
        ListaDuplamenteEncadeada oLista1 = new ListaDuplamenteEncadeada();

        oLista1.inserirInicio(8);
        oLista1.inserirInicio(2);
        oLista1.inserirInicio(3);

        oLista1.inserirFinal(5);
        oLista1.inserirFinal(7);

        //corrigir isso aqui depois
        //oLista1.removerValor(8);

        oLista1.mostrarLista();

    }
}
