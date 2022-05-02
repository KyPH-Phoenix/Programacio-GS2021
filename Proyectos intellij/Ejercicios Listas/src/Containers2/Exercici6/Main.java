package Containers2.Exercici6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List il = new IntList(new int[]{1,2,3});

        // Comprova que el mètode «size()» funciona
        System.out.println(il.size());

        // Comprova que es poden treure elements amb «get()»
        System.out.println("----");
        System.out.println(il.get(1));

        // Què passa si intento afegir elements (il.add(10))?
        //il.add(10);
        // No funciona

        // Recórre la llista amb un Iterador
        Iterator<Integer> it = il.listIterator();
        System.out.println("----");
        while (it.hasNext()) System.out.println(it.next());

        // Comprova si funciona el mètode «contains()»
        System.out.println("----");
        System.out.println(il.contains(1));
        System.out.println(il.contains(56));

        // Comprova si funciona el mètode «sublist()»
        System.out.println("----");
        System.out.println(il.subList(1, il.size()));

        // Comprova si funciona el mètode «remove()»
        //System.out.println("----");
        //il.remove(2);
        //System.out.println(il);
        // No funciona

        // Converteix la llista a un Array d'Objects i imprimeix-la
        System.out.println("----");
        Object[] array = il.toArray();
        System.out.println(Arrays.toString(array));
    }
}
