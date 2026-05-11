import java.util.Random;

public class Aeroporto {

    private Fila PistaAterrisagem1;
    private Fila PistaAterrisagem2;

    private Fila PistaDecolagem1;
    private Fila PistaDecolagem2;

    private int nextIdAterrisagem;
    private int nextIdDecolagem;

    private Random Random;

    private int totalPousos;
    private int totalDecolagens;

    private int somaTempoAterrissagem;
    private int somaTempoDecolagem;

    private int totalEmergencias;

    public Aeroporto() {
        PistaAterrisagem1 = new Fila();
        PistaAterrisagem2 = new Fila();
        PistaDecolagem1 = new Fila();
        PistaDecolagem2 = new Fila();
        nextIdAterrisagem = 1;
        nextIdDecolagem = 2;
        Random = new Random();
        totalPousos = 0;
        totalDecolagens = 0;
        somaTempoAterrissagem = 0;
        somaTempoDecolagem = 0;
        totalEmergencias = 0;
    }

    /**
     * Simula as operações das pistas
     *
     * A ordem da simulação segue:
     * 1. Chegada de novos avioes
     * 2. Decremento do combustivel
     * 3. Operacoes das pistas
     * 4. Exibicao das estatisticas
     *
     * @param int iTempoAtual
     */
    public void simularUnidadeTempo(int iTempoAtual) {
        System.out.println("\n============================");
        System.out.println("UNIDADE DE TEMPO: " + iTempoAtual);
        System.out.println("============================");
        System.out.println("\n[CHEGADAS]");
        gerarChegadasAterrissagem(iTempoAtual);
        gerarChegadasDecolagem(iTempoAtual);
        decrementarCombustivel();

        System.out.println("\n[FILAS ATUAIS]");

        System.out.print("Aterrissagem Pista 1: ");
        PistaAterrisagem1.mostrarFila();

        System.out.print("Aterrissagem Pista 2: ");
        PistaAterrisagem2.mostrarFila();

        System.out.print("Decolagem Pista 1:    ");
        PistaDecolagem1.mostrarFila();

        System.out.print("Decolagem Pista 2:    ");
        PistaDecolagem2.mostrarFila();

        System.out.println("\n[OPERAÇÕES NAS PISTAS]");

        operarPistas(iTempoAtual);
        mostrarEstatisticas();
    }

    /**
     * Gera aleatoriamente avioes chegando para aterrisagem
     * Cada aviao recebe um id sequencial e uma quantidade de reserva de combustível entre 1 e 20
     * O aviao é inserido na menor fila de aterrissagem
     *
     * @param int iTempoAtual
     */
    private void gerarChegadasAterrissagem(int iTempoAtual) {
        int iQuantidade = Random.nextInt(3);
        for (int i = 0; i < iQuantidade; i++) {
            int iCombustivel = Random.nextInt(20) + 1;
            Aviao oAviao = new Aviao(nextIdAterrisagem, iCombustivel, iTempoAtual);
            if (PistaAterrisagem1.tamanho() <= PistaAterrisagem2.tamanho()) {
                PistaAterrisagem1.enfileirar(oAviao);
                System.out.println(
                        "Aterrissagem: Avião #" + oAviao.getId() + " (combustível: " + iCombustivel + ") -> Fila Pista 1");
            } else {
                PistaAterrisagem2.enfileirar(oAviao);
                System.out.println(
                        "Aterrissagem: Avião #" + oAviao.getId() + " (combustível: " + iCombustivel + ") -> Fila Pista 2");
            }
            nextIdAterrisagem += 2;
        }
    }

    /**
     * Gera aleatoriamente avioes chegando para decolagem
     * Cada aviao recebe um id par sequencial
     * O aviao e inserido na menor fila de decolagem
     *
     * @param int iTempoAtual
     */
    private void gerarChegadasDecolagem(int iTempoAtual) {
        int iQuantidade = Random.nextInt(3);
        for (int i = 0; i < iQuantidade; i++) {
            Aviao oAviao = new Aviao(nextIdDecolagem, -1, iTempoAtual);
            // Escolhe a menor fila
            if (PistaDecolagem1.tamanho() <= PistaDecolagem2.tamanho()) {
                PistaDecolagem1.enfileirar(oAviao);
                System.out.println(
                        "Decolagem: Avião #" + oAviao.getId() + " -> Fila Pista 1");
            } else {
                PistaDecolagem2.enfileirar(oAviao);
                System.out.println("Decolagem: Avião #" + oAviao.getId() + " -> Fila Pista 2");
            }
            nextIdDecolagem += 2;
        }
    }

    /**
     * Decrementa em 1 a reserva de combustivel de todos os avioes presentes nas filas de aterrissagem
     * Quando a reserva chega a zero, o aviao entra em estado de emergencia.
     */
    private void decrementarCombustivel() {
        PistaAterrisagem1.decrementarCombustivel();
        PistaAterrisagem2.decrementarCombustivel();
    }

    /**
     * Executa as operacoes das duas pistas do aeroporto
     * Cada pista pode fzr um pouso ou uma decolagem
     * A decisão da é feita pelo metodo operarPista()
     *
     * @param int iTempoAtual
     */
    private void operarPistas(int iTempoAtual) {
        operarPista(1, PistaAterrisagem1, PistaDecolagem1, iTempoAtual);
        operarPista(2, PistaAterrisagem2, PistaDecolagem2, iTempoAtual);
    }

    /**
     * Executa a operacao de uma pista específica
     *
     * Prioridades da pista:
     * 1. Avioes em emergencia
     * 2. Maior fila entre aterrissagem e decolagem
     *
     * Caso uma fila esteja vazia, a pista executa a operacao disponível.
     *
     * @param int iNumeroPista
     * @param Fila oFilaAterrisagem
     * @param Fila oFilaDecolagem
     * @param int iTempoAtual
     */
    private void operarPista(int iNumeroPista, Fila oFilaAterrisagem, Fila oFilaDecolagem, int iTempoAtual) {
        Aviao oAviaoPrioridade = oFilaAterrisagem.espiar();
        // Verifica se o primeiro aviao esta em emergência
        if (oAviaoPrioridade != null && oAviaoPrioridade.isEmergencia()) {
            Aviao oAviao = oFilaAterrisagem.desenfileirar();
            int iTempoEspera = iTempoAtual - oAviao.getTempoChegada();
            somaTempoAterrissagem += iTempoEspera;
            totalPousos++;
            totalEmergencias++;
            System.out.println(
                    "Pista " + iNumeroPista + ": Pouso do Avião #" + oAviao.getId() + " (aguardou " + iTempoEspera + " unidades) [EMERGÊNCIA]");
            return;
        }
        // Prioriza a fila com maior tamanho
        if (oFilaAterrisagem.tamanho() >= oFilaDecolagem.tamanho()) {
            // Tenta pousar
            if (!oFilaAterrisagem.vazia()) {
                Aviao oAviao = oFilaAterrisagem.desenfileirar();
                int iTempoEspera = iTempoAtual - oAviao.getTempoChegada();
                somaTempoAterrissagem += iTempoEspera;
                totalPousos++;
                System.out.println(
                        "Pista " + iNumeroPista + ": Pouso do Avião #" + oAviao.getId() + " (aguardou " + iTempoEspera + " unidades)");
            }
            // Se a pista de aterrissagem estiveer vazia, tenta decolar
            else if (!oFilaDecolagem.vazia()) {
                Aviao oAviao = oFilaDecolagem.desenfileirar();
                int iTempoEspera = iTempoAtual - oAviao.getTempoChegada();
                somaTempoDecolagem += iTempoEspera;
                totalDecolagens++;
                System.out.println(
                        "Pista " + iNumeroPista + ": Decolagem do Avião #" + oAviao.getId() + " (aguardou " + iTempoEspera + " unidades)");
            }
            else {
                System.out.println("Pista " + iNumeroPista + ": OCIOSA");
            }
        }
        // Prioriza a decolagem
        else {
            if (!oFilaDecolagem.vazia()) {
                Aviao oAviao = oFilaDecolagem.desenfileirar();
                int iTempoEspera = iTempoAtual - oAviao.getTempoChegada();
                somaTempoDecolagem += iTempoEspera;
                totalDecolagens++;
                System.out.println(
                        "Pista " + iNumeroPista + ": Decolagem do Avião #" + oAviao.getId() + " (aguardou " + iTempoEspera + " unidades)");
            }
            else if (!oFilaAterrisagem.vazia()) {
                Aviao oAviao = oFilaAterrisagem.desenfileirar();
                int iTempoEspera = iTempoAtual - oAviao.getTempoChegada();
                somaTempoAterrissagem += iTempoEspera;
                totalPousos++;
                System.out.println("Pista " + iNumeroPista + ": Pouso do Avião #" + oAviao.getId() + " (aguardou " + iTempoEspera + " unidades)");
            }
            else {
                System.out.println("Pista " + iNumeroPista + ": Ociosa");
            }
        }
    }

    /**
     * Exibe as estatisticas da simulacao
     *
     * É exibido:
     * tempo medio de espera para aterrissagem
     * tempo medio de espera para decolagem
     * total de emergencias
     */
    private void mostrarEstatisticas() {
        double dMediaAterrissagem = 0;
        double dMediaDecolagem = 0;
        if (totalPousos > 0) {
            dMediaAterrissagem = (double) somaTempoAterrissagem / totalPousos;
        }
        if (totalDecolagens > 0) {
            dMediaDecolagem = (double) somaTempoDecolagem / totalDecolagens;
        }
        System.out.println("\n[ESTATÍSTICAS]");
        System.out.printf("Tempo médio espera aterrissagem: %.2f\n", dMediaAterrissagem);
        System.out.printf("Tempo médio espera decolagem: %.2f\n", dMediaDecolagem);
        System.out.println("Total de emergências: " + totalEmergencias);
    }

    /**
     * Exibe o resumo final da simulacao
     */
    public void mostrarResumoFinal() {
        System.out.println("\n============================");
        System.out.println("RESUMO FINAL");
        System.out.println("============================");
        mostrarEstatisticas();
        System.out.println("Total de pousos: " + totalPousos);
        System.out.println("Total de decolagens: " + totalDecolagens);
    }
}