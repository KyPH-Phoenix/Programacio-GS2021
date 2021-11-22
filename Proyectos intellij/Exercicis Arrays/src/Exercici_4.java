/*
Este programa invierte un array.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Exercici_4 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa invierte un array.");
        System.out.println();

        int[] array = {1, 5, 4, -8, 9, 15, 17};

        System.out.println("Original:");
        System.out.println(Arrays.toString(array));
        System.out.println();

        // Invertimos array.
        inverteix(array);

        System.out.println("Invertidoº:");
        System.out.println(Arrays.toString(array));
    }

    // Función para invertir el array.
    private static void inverteix(int[] array) {
        // array.lenght / 2 porque si no lo invierte dos veces y se queda original.
        for (int i = 0; i < array.length / 2; i++) {
            int t = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = t;
        }
    }

}
