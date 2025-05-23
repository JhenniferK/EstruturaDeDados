package Árvore;//Implementação de árvore binária com inserção, remoção e busca

class NodoArvore {
    int valor;
    NodoArvore esq;
    NodoArvore dir;

    public NodoArvore (int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }
}

class Arvore {
    private NodoArvore raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        NodoArvore novoNodo = new NodoArvore(valor);
        if (raiz == null) {
            raiz = novoNodo;
            return;
        }

        NodoArvore atual = raiz;
        NodoArvore anterior = null;
        while (atual != null) {
            anterior = atual;
            if (valor < atual.valor) {
                atual = atual.esq;
            } else if (valor > atual.valor) {
                atual = atual.dir;
            } else {
                return;
            }
        }

        if (valor < anterior.valor) {
            anterior.esq = novoNodo;
        } else {
            anterior.dir = novoNodo;
        }
    }

    public void remover(int valor) {
        NodoArvore atual = raiz, anterior = null;

        while (atual != null && atual.valor != valor) {
            anterior = atual;
            if (valor < atual.valor) {
                atual = atual.esq;
            } else {
                atual = atual.dir;
            }
        }

        if (atual == null) return;

        if (atual.esq == null || atual.dir == null) {
            NodoArvore novoFilho = (atual.esq != null) ? atual.esq : atual.dir;

            if (anterior == null) {
                raiz = novoFilho;
            } else if (anterior.esq == atual) {
                anterior.esq = novoFilho;
            } else {
                anterior.dir = novoFilho;
            }
        } else {
            NodoArvore sucessor = atual.dir;
            NodoArvore paiSucessor = atual;
            while (sucessor.esq != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.esq;
            }

            atual.valor = sucessor.valor;
            if (paiSucessor.esq == sucessor) {
                paiSucessor.esq = sucessor.dir;
            } else {
                paiSucessor.dir = sucessor.dir;
            }
        }
    }

    public boolean buscar(int valor) {
        NodoArvore atual = raiz;
        while (atual != null) {
            if (valor == atual.valor) {
                return true;
            }

            atual = (valor < atual.valor) ? atual.esq : atual.dir;
        }

        return false;
    }

    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        arvore.inserir(16);
        arvore.inserir(32);
        arvore.inserir(42);
        arvore.remover(16);

        System.out.println(arvore.buscar(16));
    }
}