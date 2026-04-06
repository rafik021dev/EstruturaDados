package listas_lineares;

public class ListaDuplamenteEncadeada {

    private NodoDuplo inicio;
    private NodoDuplo fim;

    public NodoDuplo getFim() { return fim;}

    public void setFim(NodoDuplo fim) {this.fim = fim;}

    public NodoDuplo getInicio() {
        return inicio;
    }

    public void setInicio(NodoDuplo inicio) {
        this.inicio = inicio;
    }

    public boolean vazia() {
        return inicio == null;
    }

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirInicio(int iDado) {
        NodoDuplo oNovoNodo = new NodoDuplo(iDado);
        if(vazia()) {
            inicio = oNovoNodo;
            fim    = oNovoNodo;
            return;
        }
        oNovoNodo.setProx(inicio);
        inicio.setAnt(oNovoNodo);
        inicio = oNovoNodo;
    }

    public void inserirFinal(int iDado) {
        if (vazia()) {
            inserirInicio(iDado);
            return;
        }
        NodoDuplo oNovoNodo = new NodoDuplo(iDado);
        fim.setProx(oNovoNodo);
        //fim.setAnt(oNovoNodo);
        oNovoNodo.setAnt(fim);
        fim = oNovoNodo;
    }

    public void mostrarLista() {
        if(vazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        NodoDuplo oNodoAux = inicio;
        while (oNodoAux != null) {
            System.out.println(oNodoAux.getDado());
            oNodoAux = oNodoAux.getProx();
        }
    }

    public void removerValor(int iValor) {
        if (vazia()) return;

        //Caso 1: O valor está no início
        if(inicio.getDado() == iValor) {
            //Se for o único elemento
            if (inicio == fim) {
                inicio = null;
                fim = null;
                return;
            }
            //Caso for o primeiro
            inicio = inicio.getProx();
            inicio.setAnt(null);
            return;
        }

        //Caso 2: O valor está no final
        if (fim.getDado() == iValor) {
            fim = fim.getAnt();
            fim.setProx(null);
            return;
        }

        //Caso 3: O valor está no meio da lista
        NodoDuplo oNodoAux = inicio.getProx();
        while (oNodoAux != null) {
            if(oNodoAux.getDado() == iValor) {
                oNodoAux.getAnt().setProx(oNodoAux.getProx());
                oNodoAux.getProx().setAnt(oNodoAux.getAnt());
                return;
            }
            oNodoAux = oNodoAux.getProx();
        }
    }

    public void mostrarListaInversa() {
        if (vazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        NodoDuplo oNodoAux = fim;
        while (oNodoAux != null) {
            System.out.println(oNodoAux.getDado());
            oNodoAux = oNodoAux.getAnt();
        }
    }

    public void mostrarMaiorMenor() {
        if (vazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        NodoDuplo oNodoAux = inicio;
        int iMaior = inicio.getDado();
        int iMenor = inicio.getDado();
        while (oNodoAux != null) {
            if (oNodoAux.getDado() > iMaior) {
                iMaior = oNodoAux.getDado();
            }
            if (oNodoAux.getDado() < iMenor) {
                iMenor = oNodoAux.getDado();
            }
            oNodoAux = oNodoAux.getProx();
        }
        System.out.println("Maior: " + iMaior);
        System.out.println("Menor: " + iMenor);
    }

    public void isPalindromo() {
        if (vazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        NodoDuplo oNodoAuxNormal  = inicio;
        NodoDuplo oNodoAuxInverso = fim;
        boolean bPalindromo = true;
        while (oNodoAuxNormal != oNodoAuxInverso && oNodoAuxInverso.getProx() != oNodoAuxNormal) {
            if (oNodoAuxNormal.getDado() != oNodoAuxInverso.getDado()) {
                bPalindromo = false;
                break;
            }
            oNodoAuxNormal  = oNodoAuxNormal.getProx();
            oNodoAuxInverso = oNodoAuxInverso.getAnt();
        }
        if (bPalindromo) {
            System.out.println("É um palíndromo");
        } else {
            System.out.println("Não é um palíndromo");
        }
    }

}
