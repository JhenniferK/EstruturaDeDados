class NodoAVL {
    int valor;
    NodoAVL esq, dir;

    public NodoAVL(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }
}

class ArvoreAVL {
    private NodoAVL raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private NodoAVL inserirRec(NodoAVL nodo, int valor) {
        if (nodo == null) {
            return new NodoAVL(valor);
        }
        if (valor < nodo.valor) {
            nodo.esq = inserirRec(nodo.esq, valor);
        } else if (valor > nodo.valor) {
            nodo.dir = inserirRec(nodo.dir, valor);
        } else {
            return nodo;
        }
        return balancear(nodo);
    }

    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    private NodoAVL removerRec(NodoAVL nodo, int valor) {
        if (nodo == null) return null;

        if (valor < nodo.valor) {
            nodo.esq = removerRec(nodo.esq, valor);
        } else if (valor > nodo.valor) {
            nodo.dir = removerRec(nodo.dir, valor);
        } else {
            if (nodo.esq == null || nodo.dir == null) {
                nodo = (nodo.esq != null) ? nodo.esq : nodo.dir;
            } else {
                NodoAVL sucessor = getSucessor(nodo.dir);
                nodo.valor = sucessor.valor;
                nodo.dir = removerRec(nodo.dir, sucessor.valor);
            }
        }
        if (nodo == null) return null;
        return balancear(nodo);
    }

    private NodoAVL getSucessor(NodoAVL nodo) {
        while (nodo.esq != null) {
            nodo = nodo.esq;
        }
        return nodo;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(NodoAVL nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.valor) return true;
        return valor < nodo.valor ? buscarRec(nodo.esq, valor) : buscarRec(nodo.dir, valor);
    }

    private int altura(NodoAVL nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(altura(nodo.esq), altura(nodo.dir));
    }

    private int fatorBalanceamento(NodoAVL nodo) {
        return (nodo == null) ? 0 : altura(nodo.esq) - altura(nodo.dir);
    }

    private NodoAVL rotacaoEsquerda(NodoAVL nodo) {
        NodoAVL novaRaiz = nodo.dir;
        nodo.dir = novaRaiz.esq;
        novaRaiz.esq = nodo;
        return novaRaiz;
    }

    private NodoAVL rotacaoDireita(NodoAVL nodo) {
        NodoAVL novaRaiz = nodo.esq;
        nodo.esq = novaRaiz.dir;
        novaRaiz.dir = nodo;
        return novaRaiz;
    }

    private NodoAVL balancear(NodoAVL nodo) {
        int fb = fatorBalanceamento(nodo);

        if (fb > 1) {
            if (fatorBalanceamento(nodo.esq) < 0) {
                nodo.esq = rotacaoEsquerda(nodo.esq);
            }
            return rotacaoDireita(nodo);
        }

        if (fb < -1) {
            if (fatorBalanceamento(nodo.dir) > 0) {
                nodo.dir = rotacaoDireita(nodo.dir);
            }
            return rotacaoEsquerda(nodo);
        }

        return nodo;
    }

    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        arvore.inserir(16);
        arvore.inserir(32);
        arvore.inserir(42);
        arvore.inserir(25);
        arvore.remover(16);

        System.out.println(arvore.buscar(16));
    }
}