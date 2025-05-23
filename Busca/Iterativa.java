/*Criar um método que receba uma lista e um número e retorne se esse número está ou não na lista (boolean)
Versão iterativa*/

package Busca;

import java.util.List;

public class Iterativa {
    public static boolean formaIterativa(List<Integer> lista, int num) {
        for (int i = 0; i < lista.size(); i++) {
            if (num == lista.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> lista = List.of(5, 2, 27, 6, 13, 9);
        int num = 1;
        System.out.println(formaIterativa(lista, num));
    }
}
