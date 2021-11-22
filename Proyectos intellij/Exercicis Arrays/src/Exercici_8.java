/*
Este programa es una funcion que devuelve una copia de un array bidimensional de enteros.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Exercici_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array = construirArray(sc);
        int[][] arrayCopia = copia(array);
        System.out.println(Arrays.deepToString(arrayCopia));
    }

    // Función para copiar el array.
    private static int[][] copia(int[][] arrayOriginal) {
        int[][] arrayCopia = new int[arrayOriginal.length][];
        for (int i = 0; i < arrayOriginal.length; i++) {
            arrayCopia[i] = new int[arrayOriginal[i].length];
            for (int j = 0; j < arrayOriginal[i].length; j++) {
                arrayCopia[i][j] = arrayOriginal[i][j];
            }
        }
        return arrayCopia;
    }

    // Función para construir array por datos de usuario.
    private static int[][] construirArray(Scanner sc) {
        // Pedimos longitud de la primera dimensión.
        System.out.println();
        System.out.print("¿Cual es la longitud de la primera dimension? (Filas): ");
        int filas = Integer.parseInt(sc.nextLine());
        int valores;

        int[][] array = new int[filas][];
        for (int i = 0; i < array.length; i++) {
            /*
             Este if es para que la primera vez que pide el numero de valores de cada "fila" del array sea distinta.
             Después los pide de forma genérica. Esto sirve para determinar cuantos valores meter en cada fila.
             */
            if (i == 0) {
                System.out.println();
                System.out.print("¿Cuántos valores tiene la primera fila? ");
                valores = Integer.parseInt(sc.nextLine());
            } else {
                System.out.println();
                System.out.print("¿Cuántos valores tiene la siguiente fila? ");
                valores = Integer.parseInt(sc.nextLine());
            }

            // Asignamos el número de valores a la fila.
            array[i] = new int[valores];

            // Ciclo para introducir los valores.
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("Introduce valor: ");
                array[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        return array;
    }

}