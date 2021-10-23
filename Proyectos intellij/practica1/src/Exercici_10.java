/*
Este programa calcula el factorial de un número.
 */

import java.util.Scanner;

public class Exercici_10 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa calcula el factorial de un número.");
        System.out.println();

        // Llamamos a la funcion Scanner.
        Scanner sc = new Scanner(System.in);

        // Pedimos el número al usuario.
        System.out.print("Introduce el número: ");
        int numero = Integer.parseInt(sc.nextLine());

        // Declaración de variable
        long resultado = 1;

        // Ciclo para hacer el factorial.
        for (int ciclo = 1; ciclo <= numero; ciclo++) {
            resultado = resultado * ciclo;
        }

        // Imprimimos el resultado por pantalla
        System.out.printf("El resultado es: %d", resultado);
    }
}
