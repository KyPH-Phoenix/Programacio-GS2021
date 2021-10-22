/*
Este programa muestra los primeros 30 múltiplos de 5 que no son múltiplos de 3.
 */

public class Exercici_6 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa muestra los primeros 30 múltiplos de 5 que no son múltiplos de 3.");
        System.out.println();

        // Declaración de variables.
        int multiplo = 5;
        int ciclo = 1;
        boolean esMultiplo;

        // Ciclo para listar los numeros.
        while (ciclo <= 30) {
            esMultiplo = true;
            if (multiplo % 3 == 0) {
                esMultiplo = false;
            }
            if (esMultiplo) {
                System.out.println(ciclo + ". " + multiplo);
                ciclo++;
            }
            multiplo += 5;
        }
    }
}
