/*
Este programa muestra por pantalla la sucesion de las potencias de 2.
 */

public class Exercici_3 {
    public static void main(String[] args) {
        // Descripcion del programa.
        System.out.println("Este programa muestra por pantalla la sucesion de las potencias de 2.");
        System.out.println();

        // Declaración de variables.
        int numero = 2;
        int ciclo = 0;

        // Ciclo
        while (ciclo < 10) {
            System.out.println(numero);
            numero = numero * 2;
            ciclo++;
        }
    }
}
