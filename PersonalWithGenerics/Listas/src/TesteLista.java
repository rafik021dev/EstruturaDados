public class TesteLista {
    
    public static void main(String[] args) {

        ListaEncadeada<Integer> oListaEncadeada = new ListaEncadeada<>();

        oListaEncadeada.inserirInicio(3);
        oListaEncadeada.inserirInicio(2);
        oListaEncadeada.inserirInicio(5);
        oListaEncadeada.inserirInicio(9);
        oListaEncadeada.inserirInicio(7);

        oListaEncadeada.getMeioLista();
        oListaEncadeada.removerValor(2);
        oListaEncadeada.mostrarLista();
        oListaEncadeada.getMeioLista();

        oListaEncadeada.getTamanhoLista();
    }
}
