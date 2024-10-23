//Implementar algoritmo de Ordenação: Insertion Sort

import java.util.Arrays;

public class Aula3 {
    public static void main(String[] args) {
        int[] lista = {5, 2, 9, 1, 4};

        for (int i = 1; i < lista.length; i++) {
            int chave = lista[i];
            int j = i-1;

            while (j >= 0 && lista[j] > chave) {
                lista[j+1] = lista[j];
                j = j-1;
            }
            lista[j+1] = chave;
        }

        System.out.println(Arrays.toString(lista));
    }
}
