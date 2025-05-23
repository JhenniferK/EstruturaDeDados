/*Implementação de lista encadeada circular

• Crie o objeto do Lista.Nodo (valor e prox)
• Crie o Objeto da ListaEncadeadaCircular
• Precisa ter o Primeiro e Tamanho (variáveis)
• O size retorna o tamanho da lista
• O get (index) – retorna o nodo na posição (ou null se não tem aquela posição)
• O add (index, elemento) adiciona na posição pedida (lembrar de checar <Primeiro>)
• O remove (index) remove o elemento daquele index da lista*/

package Lista;

public class ListaCircular {
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
            primeiro.prox = primeiro;
            primeiro.ant = primeiro;
        } else {
            ultimo.prox = novo;
            novo.ant = ultimo;
            novo.prox = primeiro;
            primeiro.ant = novo;
            ultimo = novo;
        }

        tamanho++;
    }

    public void addComeco(int elemento) {
        Nodo novo = new Nodo(elemento);

        if (tamanho == 0) {
            primeiro = ultimo = novo;
            primeiro.prox = primeiro;
            primeiro.ant = primeiro;
        } else {
            novo.prox = primeiro;
            primeiro.ant = novo;
            novo.ant = ultimo;
            ultimo.prox = novo;
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
            if (tamanho == 1) {
                primeiro = ultimo = null;
            } else {
                primeiro = primeiro.prox;
                primeiro.ant = ultimo;
                ultimo.prox = primeiro;
            }
        } else if (index == tamanho - 1) {
            removido = ultimo;
            if (tamanho == 1) {
                primeiro = ultimo = null;
            } else {
                ultimo = ultimo.ant;
                ultimo.prox = primeiro;
                primeiro.ant = ultimo;
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
        if (tamanho == 0) {
            System.out.println("Lista vazia");
            return;
        }

        Nodo atual = primeiro;
        for (int i = 0; i < tamanho; i++) {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

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

        lista.remove(0);
        lista.printLista();

        System.out.println("Tamanho da lista: " + lista.size());
    }
}
