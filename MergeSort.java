//Implementação do MergeSort

public class MergeSort {
    public static void main(String[] args) {
        int[] lista = {5, 2, 9, 1, 4, 8};
        int p = 0, r = lista.length - 1;
        merge(lista, p, r);

        for (int num : lista) {
            System.out.print(num + " ");
        }
    }

    public static void merge(int[] lista, int p, int r) {
        if (p < r) {
            int q = (p + r)/2;
            merge(lista, p, q);
            merge(lista, q + 1, r);
            merge(lista, p, q, r);
        }
    }

    public static void merge(int[] lista, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = lista[p + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = lista[q + 1 + j];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;

        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                lista[k] = L[i];
                i++;
            } else {
                lista[k] = R[j];
                j++;
            }
        }
    }
}
