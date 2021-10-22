/*
Este programa escribe la tabla de multiplicar (del 1 al 10) de un número introducido por pantalla.
 */

import java.util.Scanner;

public class Exercici_4 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa escribe la tabla de multiplicar " +
                "(del 1 al 10) de un número introducido por pantalla.");
        System.out.println();

        // Llamamos a la funcion Scanner para pedir el valor por teclado.
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el numero del cual quieres la tabla: ");
        int numero = Integer.parseInt(sc.nextLine());

        /*
        Ciclo para calcular e imprimir la tabla.
        Dentro del For definimos la variable "ciclo" y la variable "resultado".
         */
        for (int ciclo = 1, resultado = numero; ciclo <= 10; ciclo++) {
            resultado = numero * ciclo;
            System.out.println(numero + " * " + ciclo + " = " + resultado);
        }
    }
}
