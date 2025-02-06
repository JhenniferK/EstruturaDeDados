//Implementação de árvore binária com inserção, remoção e busca

class Nodo {
    int valor;
    Nodo esq;
    Nodo dir;

    public Nodo (int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }
}

class Arvore {
    private Nodo raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (raiz == null) {
            raiz = novoNodo;
            return;
        }

        Nodo atual = raiz;
        Nodo anterior = null;
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
        Nodo atual = raiz, anterior = null;

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
            Nodo novoFilho = (atual.esq != null) ? atual.esq : atual.dir;

            if (anterior == null) {
                raiz = novoFilho;
            } else if (anterior.esq == atual) {
                anterior.esq = novoFilho;
            } else {
                anterior.dir = novoFilho;
            }
        } else {
            Nodo sucessor = atual.dir;
            Nodo paiSucessor = atual;
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
        Nodo atual = raiz;
        while (atual != null) {
            if (valor == atual.valor) {
                return true;
            }

            atual = (valor < atual.valor) ? atual.esq : atual.dir;
        }

        return false;
    }

    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.inserir(16);
        arvore.inserir(32);
        arvore.inserir(42);
        arvore.remover(16);

        System.out.println(arvore.buscar(16));
    }
}
