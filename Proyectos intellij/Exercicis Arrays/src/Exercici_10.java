/*
Esta función calcula una media ponderada de unas notas dependiendo del peso de cada una.
 */

import java.util.Scanner;

public class Exercici_10 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Esta función calcula una media ponderada de unas notas dependiendo del peso de cada una.");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        // Creamos los arrays con funciones que piden datos al usuario.
        int[] notas = pedirNotas(sc);
        double[] peso = pedirPeso(sc, notas.length);

        // Calculamos la media.
        double mediaNotas = realizarMedia(notas, peso);

        // Imprimimos nota con 2 decimales.
        System.out.printf("%.2f", mediaNotas);
    }

    // Función para pedir las notas al usuario.
    private static int[] pedirNotas(Scanner sc) {
        // Preguntamos cuantas notas hay.
        System.out.println();
        System.out.print("Cuantas notas vas a introducir? ");
        int[] notas = new int[Integer.parseInt(sc.nextLine())];

        // Ciclo para escribir las notas.
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Introduce la nota " + (i + 1) + ": ");
            notas[i] = Integer.parseInt(sc.nextLine());
        }

        return notas;
    }

    // Función para pedir los pesos de las notas.
    private static double[] pedirPeso(Scanner sc, int longitud) {
        double[] pesos = new double[longitud];

        /*
        Ciclo para pedir los pesos de las notas. No pedimos el número de valores porque es el mismo del array "notas"
         */
        for (int i = 0; i < pesos.length; i++) {
            System.out.print("Introduce el peso de la nota " + (i + 1) + ": ");
            pesos[i] = Double.parseDouble(sc.nextLine());
        }

        return pesos;
    }

    // Función para realizar la media de las notas.
    private static double realizarMedia(int[] notas, double[] peso) {
        // Validamos si los valores introducimos son válidos. En caso de que no, la función retorna error.
        boolean validezValores = comprobarValidez(notas, peso);
        if (!validezValores) {
            return -1;
        }

        // Hacemos la media ponderada de las notas según su peso.
        double mediaNotas = 0;
        for (int i = 0; i < notas.length; i++) {
            mediaNotas = mediaNotas + (notas[i] * peso[i]);
        }
        return mediaNotas;
    }

    // Función para comprobar si los valores de las notas y los pesos son válidos.
    private static boolean comprobarValidez(int[] notas, double[] peso) {
        // Comprueba que los dos arrays tengan la misma longitud.
        if (notas.length != peso.length) {
            return false;
        }

        // Comprueba que la suma de todos los pesos sea igual a 1.
        double pesoTotal = 0;
        for (int i = 0; i < peso.length; i++) {
            pesoTotal = pesoTotal + peso[i];
        }
        if (pesoTotal < 0.9999999999 || pesoTotal > 1.0000000001) {
            return false;
        }

        // Comprueba que ninguna nota es menor que 0 ni mayor que 10.
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 0 || notas[i] > 10) {
                return false;
            }
        }

        // Si los valores son validos, devuelve true. En caso contrario, false.
        return true;
    }


}
