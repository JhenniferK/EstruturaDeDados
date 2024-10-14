//Recursividade para encontrar quantos números 2 tem numa lista

public class Aula2 {
    public static void main(String[] args) {
        int[] lista = {2, 1, 5, 2, 6, 2};
        System.out.println(contar(lista, lista.length - 1));
    }

    public static int contar(int[] lista, int index) {
        if (index < 0) {
            return 0;
        } else if (lista[index] == 2) {
            return 1 + contar(lista, index - 1);
        } else {
            return contar(lista, index - 1);
        }
    }
}
