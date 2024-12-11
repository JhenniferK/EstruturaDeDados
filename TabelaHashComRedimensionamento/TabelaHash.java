public class TabelaHashComRedimensionamento {
    private Discente[] tabela;
    private final Discente removido = new Discente(0, "removido");
    private int tamanho;
    private int quantidade;

    public TabelaHashComRedimensionamento(int tamanhoInicial) {
        this.tamanho = tamanhoInicial;
        this.tabela = new Discente[tamanho];
        this.quantidade = 0;
    }

    private int hash(int matricula) {
        return matricula%tamanho;
    }

    private void redimensionar() {
        int novoTamanho = tamanho*2;
        Discente[] novaTabela = new Discente[novoTamanho];
        Discente[] tabelaAntiga = tabela;

        tabela = novaTabela;
        tamanho = novoTamanho;
        quantidade = 0;

        for (Discente discente : tabelaAntiga) {
            if (discente != null && discente != removido) {
                inserirValor(discente.getMatricula(), discente.getNome());
            }
        }
    }

    private void inserirValor(int matricula, String nome) {
        if (quantidade >= tamanho/2) {
            redimensionar();
        }

        int posicao = hash(matricula);
        while (tabela[posicao] != null && tabela[posicao] != removido) {
            if (tabela[posicao].getMatricula() == matricula) {
                tabela[posicao] = new Discente(matricula, nome);
                return;
            }

            posicao = (posicao + 1)%tamanho;
        }

        tabela[posicao] = new Discente(matricula, nome);
        quantidade++;
    }

    public String pegarValor(int matricula) {
        int posicao = hash(matricula);
        while (tabela[posicao] != null) {
            if (tabela[posicao] != removido && tabela[posicao].getMatricula() == matricula) {
                return tabela[posicao].getNome();
            }
            posicao = (posicao + 1) % tamanho;
        }
        return null;
    }

    public void removerValor(int matricula) {
        int posicao = hash(matricula);
        while (tabela[posicao] != null) {
            if (tabela[posicao] != removido && tabela[posicao].getMatricula() == matricula) {
                tabela[posicao] = removido;
                quantidade--;
                return;
            }
            posicao = (posicao + 1)%tamanho;
        }
    }

    public void exibirTabela() {
        for (int i = 0; i < tamanho; i++) {
            if (tabela[i] == null) {
                System.out.println("Posição " + i + ": Vazia");
            } else if (tabela[i] == removido) {
                System.out.println("Posição " + i + ": REMOVIDO");
            } else {
                System.out.println("Posição " + i + ": Matrícula - " + tabela[i].getMatricula() + ", Nome - " + tabela[i].getNome());
            }
        }
    }

    public static void main(String[] args) {
        TabelaHashComRedimensionamento tabela = new TabelaHashComRedimensionamento(5);

        tabela.inserirValor(20241, "Jhennifer");
        tabela.inserirValor(20240, "Joyce");
        tabela.inserirValor(20247, "Jônatas");

        tabela.exibirTabela();

        System.out.println("Nome da matrícula 20241: " + tabela.pegarValor(20241));
        System.out.println("Nome da matrícula 20230: " + tabela.pegarValor(20230));

        tabela.removerValor(20241);
    }
}
