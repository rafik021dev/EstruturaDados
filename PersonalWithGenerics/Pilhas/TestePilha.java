public class TestePilha {
    public static void main(String[] args) {
        
        PilhaEstatica<String> oPilhaEstatica = new PilhaEstatica<>(5);

        oPilhaEstatica.push("2");
        oPilhaEstatica.push("4");
        oPilhaEstatica.push("6");

        oPilhaEstatica.mostrarPilha();
        oPilhaEstatica.inverterTexto("testeee");
    }
}
