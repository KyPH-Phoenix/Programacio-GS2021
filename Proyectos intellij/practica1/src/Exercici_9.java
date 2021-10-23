/*
Este programa calcula el máximo divisor común usando el teorema de euclides.
 */

import java.util.Scanner;

public class Exercici_9 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa calcula el máximo divisor común usando el teorema de euclides.");
        System.out.println();

        // Llamamos a la funcion Scanner
        Scanner sc = new Scanner(System.in);

        // Pedimos los dos numeros al usuario
        System.out.print("Introduce el primer número: ");
        int numero1 = Integer.parseInt(sc.nextLine());
        System.out.print("Introduce el segundo número: ");
        int numero2 = Integer.parseInt(sc.nextLine());

        // Guardamos los valores
        int copiaNum1 = numero1;
        int copiaNum2 = numero2;

        // Ciclo para sacar el MCD
        while (numero1 != numero2) {
            if (numero1 < numero2) {
                // Intercambiamos las variables si el numero1 es mas pequeño
                int t = numero1;
                numero1 = numero2;
                numero2 = t;
            }
            numero1 = numero1 - numero2;
        }

        // Imprimimos por pantalla el resultado
        System.out.printf("El MCD de %d y %d es: %d", copiaNum1, copiaNum2, numero1);
    }
}