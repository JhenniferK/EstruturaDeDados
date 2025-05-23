package Ordenação;

import java.util.ArrayList;
import java.util.List;

public class Ordenacao {
    public static void main(String[] args) {
        List<Integer> valores = new ArrayList<>();
        valores.add(25);
        valores.add(13);
        valores.add(3);
        valores.add(17);

        List<Integer> ordenada = new ArrayList<>();

        while (!valores.isEmpty()) {
            int menor = valores.get(0);
            for (int i = 1; i < valores.size(); i++) {
                if (valores.get(i) < menor) {
                    menor = valores.get(i);
                }
            }

            ordenada.add(menor);
            valores.remove(Integer.valueOf(menor));
        }

        System.out.println(ordenada);
    }
}
