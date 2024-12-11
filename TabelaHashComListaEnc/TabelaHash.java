/*Implementação de Tabela Hash com Lista Encadeada

•Criar classe Aluno com matrícula e nome
•Criar classe TabelaHash
•O que essa classe tem que ter:

•Tabela de alunos: ListaEncadeada[] tabela
•Função que calcula o hash: use o cálculo com o mod
•Função pegarValor (recebe matrícula, retorna nome) : percorrer a lista interna da posição
•Função inserirValor (recebe matricula e valor): inserir no final na lista interna da posição
•Função removerValor (recebematricula): remover da lista interna da posição*/

import java.util.LinkedList;

public class TabelaHash {
    private LinkedList<Aluno>[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new LinkedList[tamanho];

        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    public int hash(int matricula) {
        return matricula % tamanho;
    }

    public int size() {
        return tamanho;
    }

    public void inserirValor(String nome, int matricula) {
        int psc = hash(matricula);
        tabela[psc].add(new Aluno(nome, matricula));
    }

    public String pegarValor(int matricula) {
        int psc = hash(matricula);
        for (Aluno aluno : tabela[psc]) {
            if (aluno.getMatricula() == matricula) {
                return aluno.getNome();
            }
        }
        return null;
    }

    public boolean removerValor(int matricula) {
        int psc = hash(matricula);
        for (Aluno aluno : tabela[psc]) {
            if (aluno.getMatricula() == matricula) {
                tabela[psc].remove(aluno);
                return true;
            }
        }

        return false;
    }

    public void exibirTabela() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Posição " + i + ": ");
            for (Aluno aluno : tabela[i]) {
                System.out.println("Matrícula: " + aluno.getMatricula() + " - Nome: " + aluno.getNome());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(5);

        tabela.inserirValor("Jhennifer", 20231);
        tabela.inserirValor("Joyce", 20230);

        tabela.exibirTabela();

        System.out.println("Nome da matrícula 20231: " + tabela.pegarValor(20231) + "\n");
        System.out.println("Nome da matrícula 20230: " + tabela.pegarValor(20230) + "\n");

        System.out.println("Removendo matrícula 20230: " + (tabela.removerValor(20230) ? "Removido com sucesso" : "Falha na remoção") + "\n");
        tabela.exibirTabela();
    }
}
