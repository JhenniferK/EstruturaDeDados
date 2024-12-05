/*Implementação de Lista duplamente encadeada

• Crie o objeto do Nodo (valor, prox, ant)
• Crie o Objeto da ListaSEncadeada
• Precisa ter o Primeiro, Último e Tamanho (variáveis)
• O size retorna o tamanho da lista
• O addFinal (elemento) adiciona no final da lista
• O addComeco (elemento) adiciona no começo da lista
• O add (index, elemento) adiciona na posição pedida
• O remove (index) remove o elemento daquele index da lista*/

public class ListaDEncadeada {
    private class Nodo {
        int valor;
        Nodo prox;
        Nodo ant;

        public Nodo(int valor) {
            this.valor = valor;
        }
    }

    private Nodo primeiro;
    private Nodo ultimo;
    private int tamanho;

    public int size() {
        return tamanho;
    }

    public void addFinal(int elemento) {
        Nodo novo = new Nodo(elemento);

        if (tamanho == 0) {
            primeiro = ultimo = novo;
        } else {
            ultimo.prox = novo;
            novo.ant = ultimo;
            ultimo = novo;
        }

        tamanho++;
    }

    public void addComeco(int elemento) {
        Nodo novo = new Nodo(elemento);

        if (tamanho == 0) {
            primeiro = ultimo = novo;
        } else {
            novo.prox = primeiro;
            primeiro.ant = novo;
            primeiro = novo;
        }

        tamanho++;
    }

    public void add(int index, int elemento) {
        if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        if (index == 0) {
            addComeco(elemento);
        } else if (index == tamanho) {
            addFinal(elemento);
        } else {
            Nodo novo = new Nodo(elemento);
            Nodo atual = getNodo(index);
            Nodo anterior = atual.ant;

            anterior.prox = novo;
            novo.ant = anterior;
            novo.prox = atual;
            atual.ant = novo;

            tamanho++;
        }
    }

    public int remove(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        Nodo removido;

        if (index == 0) {
            removido = primeiro;
            primeiro = primeiro.prox;
            if (primeiro != null) {
                primeiro.ant = null;
            } else {
                ultimo = null;
            }
        } else if (index == tamanho - 1) {
            removido = ultimo;
            ultimo = ultimo.ant;
            if (ultimo != null) {
                ultimo.prox = null;
            }
        } else {
            removido = getNodo(index);
            Nodo anterior = removido.ant;
            Nodo proximo = removido.prox;

            anterior.prox = proximo;
            proximo.ant = anterior;
        }

        tamanho--;
        return removido.valor;
    }

    private Nodo getNodo(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        Nodo atual;

        if (index < tamanho/2) {
            atual = primeiro;
            for (int i = 0; i < index; i++) {
                atual = atual.prox;
            }
        } else {
            atual = ultimo;
            for (int i = tamanho - 1; i > index; i--) {
                atual = atual.ant;
            }
        }

        return atual;
    }

    public void printLista() {
        Nodo atual = primeiro;

        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListaDEncadeada lista = new ListaDEncadeada();

        lista.addFinal(10);
        lista.addFinal(20);
        lista.addFinal(30);
        lista.printLista();

        lista.addComeco(5);
        lista.printLista();

        lista.add(2, 15);
        lista.printLista();

        lista.remove(3);
        lista.printLista();

        System.out.println("Tamanho da lista: " + lista.size());
    }
}
