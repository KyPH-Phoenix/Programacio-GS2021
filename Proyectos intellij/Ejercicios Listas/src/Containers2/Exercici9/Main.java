package Containers2.Exercici9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();

        List<Integer> l1 = new ArrayList<>();
        fill(l1);

        long t1 = System.currentTimeMillis() - t0;
        System.out.printf("Tiempo desde que comenzó el programa: %dms\nTiempo para rellenar l1: %dms\n\n", System.currentTimeMillis() - t0, t1);

        List<Integer> l2 = new LinkedList<>();
        fill(l2);

        long t2 = System.currentTimeMillis() - t0 - t1;
        System.out.printf("Tiempo desde que comenzó el programa: %dms\nTiempo para rellenar l2: %dms\n\n", System.currentTimeMillis() - t0, t2);

        for (int i = 0; i < 5000; i++) {
            l1.add(random.nextInt(l1.size()), random.nextInt());
        }

        long t3 = System.currentTimeMillis() - t0 - t1 - t2;
        System.out.printf("Tiempo desde que comenzó el programa: %dms\nTiempo para añadir 5000 valores a l1: %dms\n\n", System.currentTimeMillis() - t0, t3);

        for (int i = 0; i < 5000; i++) {
            l1.add(random.nextInt(l2.size()), random.nextInt());
        }

        long t4 = System.currentTimeMillis() - t0 - t1 - t2 - t3;
        System.out.printf("Tiempo desde que comenzó el programa: %dms\nTiempo para añadir 5000 valores a l2: %dms\n\n", System.currentTimeMillis() - t0, t4);
    }

    private static void fill(List<Integer> list) {
        for (int i = 0; i < 5000000; i++) {
            list.add(random.nextInt());
        }
    }
}
