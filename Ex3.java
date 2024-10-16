// Recursividade para imprimir números pares até N

package org.example;

public class Main {
    public static void imprimirPares(int n) {
        if (n < 0) {
            return;
        }

        imprimirPares(n - 1);

        if (n%2 == 0) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        int n = 50;
        imprimirPares(n);
    }
}
