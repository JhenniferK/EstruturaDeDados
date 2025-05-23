/*Criar um método que receba uma lista e um número e retorne se esse número está ou não na lista (boolean)
Versão recursiva*/

package Busca;

import java.util.List;

public class Recursiva {
    public static boolean formaRecursiva(List<Integer> lista, int numero, int indice) {
        if (indice >= lista.size()) {
            return false;
        }

        if (lista.get(indice) == numero) {
            return true;
        }

        return formaRecursiva(lista, numero, indice + 1);
    }

    public static void main(String[] args) {
        List<Integer> lista = List.of(5, 2, 27, 6, 13, 9);
        int entrada = 27;
        System.out.println(formaRecursiva(lista, entrada, 0));
    }
}
