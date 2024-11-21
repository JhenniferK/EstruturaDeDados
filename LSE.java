/*Crie o objeto do Nodo (valor e prox);
Crie o Objeto da ListaSEncadeada;
Precisa ter o Primeiro e Tamanho (variáveis);
O size retorna o tamanho da lista;
O add (elemento) adiciona no final da lista;
O get (index) – retorna o nodo na posição (ou null se não tem aquela posição);
O add (index, elemento) adiciona na posição pedida (lembrar de checar <Primeiro>);
O remove (index) remove o elemento daquele index da lista;*/

class Nodo {
    int valor;
    Nodo proximo;

    public Nodo(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class ListaSEncadeada {
    private Nodo primeiro;
    private int tamanho;

    public ListaSEncadeada() {
        this.primeiro = null;
        this.tamanho = 0;
    }

    public int size() {
        return tamanho;
    }

    public void add(int valor) {
        Nodo novoNodo = new Nodo(valor);

        if (primeiro == null) {
            primeiro = novoNodo;
        } else {
            Nodo atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = novoNodo;
        }

        tamanho++;
    }

    public Nodo get(int index) {
        if (index < 0 || index >= tamanho) {
            return null;
        }

        Nodo atual = primeiro;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }

        return atual;
    }

    public static void main(String[] args) {
        ListaSEncadeada lista = new ListaSEncadeada();

        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);

        System.out.println("Tamanho da lista: " + lista.size());

        Nodo nodo = lista.get(2);
        if (nodo != null) {
            System.out.println("Elemento na posição 2: " + nodo.valor);
        } else {
            System.out.println("Índice inválido!");
        }

        nodo = lista.get(5);
        if (nodo != null) {
            System.out.println("Elemento na posição 5: " + nodo.valor);
        } else {
            System.out.println("Índice inválido!");
        }
    }
}
