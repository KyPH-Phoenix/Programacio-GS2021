/*
Este programa imprime por pantalla los 100 primeros números impares.
 */

public class Exercici_1 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa imprime por pantalla los 100 primeros números impares.");
        System.out.println();

        // Declaración de variables.
        int numero = 1;
        int ciclo = 0;

        // Ciclo para y sumar al número base.
        while (ciclo < 100) {
            System.out.println(numero);
            numero = numero + 2;
            ciclo++;
        }
    }
}

