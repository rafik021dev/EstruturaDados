public class Fila {

    private Nodo inicio;

    public Fila() {
        inicio = null;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    /**
     * Verifica se a fila está vazia
     *
     * @return boolean
     */
    public boolean vazia() {
        return inicio == null;
    }

    /**
     * Adiciona o avião no final da fila
     *
     * @param Aviao oAviao
     */
    public void enfileirar(Aviao oAviao) {
        Nodo oNovoNodo = new Nodo(oAviao);
        if (vazia()) {
            inicio = oNovoNodo;
            return;
        }
        Nodo oNodoAux = inicio;
        while (oNodoAux.getProx() != null) {
            oNodoAux = oNodoAux.getProx();
        }
        oNodoAux.setProx(oNovoNodo);
    }

    /**
     * Remove o avião do início e retorna ele
     *
     * @return Aviao | null
     */
    public Aviao desenfileirar() {
        if (vazia()) {
            return null;
        }
        Aviao oAviaoRemovido = inicio.getDado();
        inicio = inicio.getProx();
        return oAviaoRemovido;
    }

    /**
     * Retorna o primeiro avião da fila
     *
     * @return Aviao | null
     */
    public Aviao espiar() {
        if (vazia()) {
            return null;
        }
        return inicio.getDado();
    }

    /**
     * Conta quantos aviões tem na fila
     *
     * @return int
     */
    public int tamanho() {
        if (vazia()) {
            return 0;
        }
        int iContador = 0;
        Nodo oNodoAux = inicio;
        while (oNodoAux != null) {
            iContador++;
            oNodoAux = oNodoAux.getProx();
        }
        return iContador;
    }

    /**
     * Diminui o combustível dos aviões
     * Apenas em aviões de aterrisagem
     * Se não tiver reserva, define o avião como emergencia
     */
    public void decrementarCombustivel() {
        Nodo oNodoAux = inicio;
        while (oNodoAux != null) {
            Aviao oAviao = oNodoAux.getDado();
            if (oAviao.getReservaCombustivel() > 0) {
                oAviao.setReservaCombustivel(oAviao.getReservaCombustivel() - 1);
                if (oAviao.getReservaCombustivel() == 0) {
                    oAviao.setEmergencia(true);
                }
            }
            oNodoAux = oNodoAux.getProx();
        }
    }

    /**
     * Mostra a fila atual
     */
    public void mostrarFila() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return;
        }
        Nodo oNodoAux = inicio;
        System.out.print("[");
        while (oNodoAux != null) {
            System.out.print(oNodoAux.getDado());
            if (oNodoAux.getProx() != null) {
                System.out.print(", ");
            }
            oNodoAux = oNodoAux.getProx();
        }

        System.out.println("]");
    }
}