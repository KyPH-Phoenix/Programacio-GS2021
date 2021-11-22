/*
Este programa comprueba si hay valores duplicados en un array.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Exercici_13 {
    public static void main(String[] args) {
        // Genera el array.
        int[] array = generarArray();

        // Comprueba si hay valores repetidos.
        if (comprobar(array)) {
            System.out.println();
            System.out.println("Se repiten números.");
        } else {
            System.out.println();
            System.out.println("No se repiten números.");
        }
    }

    // Función para generar array.
    private static int[] generarArray() {
        // Pedimos la longitud del array al usuario.
        Scanner sc = new Scanner(System.in);
        System.out.print("¿De cuantos valores quieres el array? ");

        int[] array = new int[Integer.parseInt(sc.nextLine())];

        // Creamos el array con números random
        for (int i = 0; i < array.length; i++) {
            int numero = (int) (Math.random() * 1_000_000);
            array[i] = numero;
        }

        return array;
    }

    // Función para comprobar valores.
    private static boolean comprobar(int[] array) {
        boolean iguales = false;

        // Primero ordena array.
        Arrays.sort(array);

        // Luego comprueba si algún numero es igual al siguiente.
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                iguales = true;
                break;
            }
        }
        return iguales;
    }
}
