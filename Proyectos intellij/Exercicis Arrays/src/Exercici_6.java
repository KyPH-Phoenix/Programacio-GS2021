/*
Este programa dibuja una cruz mediante un array booleano de dos dimensiones.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Exercici_6 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa dibuja una cruz mediante un array booleano de dos dimensiones.");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        // Pedimos parámetros al usuario.
        System.out.print("Dimensiones del array: ");
        int dimensiones = Integer.parseInt(sc.nextLine());

        // Creamos array, dibujamos la cruz e imprimimos array.
        boolean[][] array = crearArray(dimensiones);
        dibujarCruz(array);
        imprimir(array);
    }

    // Función para crear el array.
    private static boolean[][] crearArray(int dimensiones) {
        boolean[][] array = new boolean[dimensiones][];

        // Añadimos cada fila del array.
        for (int i = 0; i < array.length; i++) {
            array[i] = new boolean[array.length];
        }
        return array;
    }

    // Función para dibujar la cruz.
    private static void dibujarCruz(boolean[][] array) {
        // Declaramos las variables para saber el centro del array y si es par.
        int centro = array.length / 2;
        boolean par = (array.length & 1) == 0;

        // Ciclo para dibujar la cruz en el centro.
        for (int i = 0; i < array.length; i++) {
            array[centro][i] = array[i][centro] = true;
            if (par) {
                array[centro - 1][i] = array[i][centro - 1] = true;
            }
        }
    }

    // Función para imprimir el array. Donde hay un false introducimos " " y donde hay un true un "*".
    private static void imprimir(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] ? '*' : ' ');
            }
            System.out.println();
        }
    }
}
