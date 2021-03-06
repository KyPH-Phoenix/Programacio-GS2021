package Containers2.Exercici8;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
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

        test(l1);

        long t3 = System.currentTimeMillis() - t0 - t1 - t2;
        System.out.printf("Tiempo desde que comenzó el programa: %dms\nTiempo para acceder a l1: %dms\n\n", System.currentTimeMillis() - t0, t3);

        test(l2);

        long t4 = System.currentTimeMillis() - t0 - t1 - t2 - t3;
        System.out.printf("Tiempo desde que comenzó el programa: %dms\nTiempo para acceder a l2: %dms\n\n", System.currentTimeMillis() - t0, t4);

    }

    static Random random = new Random();

    private static void test(List<Integer> list) {
        for (int i = 0; i < 1000; i++) {
            list.get(random.nextInt(list.size()));
        }
    }

    private static void fill(List<Integer> list) {

        for (int i = 0; i < 5000000; i++) {
            list.add(random.nextInt());
        }
    }
}
