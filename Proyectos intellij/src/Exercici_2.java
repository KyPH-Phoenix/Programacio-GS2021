/*
Este programa convierte una temperatura introducida por teclado
de Celsius a Farenheit.
 */

import java.util.Scanner;

public class Exercici_2 {
    public static void main(String[] args) {
        /*
        La formula para convertir de Cº a Fº es: Fº=(Cº*9/5)+32
         */

        // Descripción del programa
        System.out.println("Este programa es un conversor de grados celsius a farenheit.");
        System.out.println();

        // Llamamos a la función Scanner para pedir el valor al usuario
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce los grados celsius: ");
        double celsius = Double.parseDouble(sc.nextLine());

        // Calcula e imprime el resultado.
        double farenheit = ((celsius * 9.0) / 5.0) + 32.0;
        System.out.printf("%.2f grados celsius son %.2f grados farenheit.", celsius, farenheit);
    }
}
