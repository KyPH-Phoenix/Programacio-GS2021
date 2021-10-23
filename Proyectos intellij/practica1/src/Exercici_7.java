/*
Este programa soluciona una ecuacion de segundo grado (ax²+bx+c) dados a, b y c por el usuario.
 */

import java.util.Scanner;

public class Exercici_7 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa soluciona una ecuacion de segundo grado (ax²+bx+c) dados a, b y c por el usuario.");
        System.out.println();

        // Llamamos a la función Scanner.
        Scanner sc = new Scanner(System.in);

        // Pedimos los valores al usuario.
        System.out.print("Introduce el valor de a: ");
        double a = Integer.parseInt(sc.nextLine());
        System.out.print("Introduce el valor de b: ");
        double b = Integer.parseInt(sc.nextLine());
        System.out.print("Introduce el valor de c: ");
        double c = Integer.parseInt(sc.nextLine());

        // Calculamos el valor del discriminante, el valor que esta dentro de la raíz cuadrada.
        double discriminante = b * b - 4d * a * c;

        if (a == 0) {
            double solucion = c / b;
            System.out.printf("Solo hay una solucion: %.2f\n", solucion);
        } else if (discriminante < 0) {
            System.out.println("No hay solucion");
        } else if (discriminante == 0) {
            double solucion = b / 2 * a;
            System.out.printf("Solo hay una solucion: %.2f\n", solucion);
        } else {
            double solucion1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double solucion2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.printf("Hay dos soluciones: %.2f y %.2f\n", solucion1, solucion2);
        }
    }
}
