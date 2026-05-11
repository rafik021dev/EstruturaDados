public class Main {

    public static void main(String[] args) {

        Aeroporto oAeroporto = new Aeroporto();
        int iTempoTotal = 20;
        for (int iTempo = 1; iTempo <= iTempoTotal; iTempo++) {
            oAeroporto.simularUnidadeTempo(iTempo);
        }
        oAeroporto.mostrarResumoFinal();
    }
}