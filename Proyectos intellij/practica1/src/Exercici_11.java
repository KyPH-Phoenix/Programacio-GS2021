/*
Este prgrama te dice en qué estación estas dependiendo del día y el mes que introduzcas.
 */

import java.util.Scanner;

public class Exercici_11 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este prgrama te dice en qué estación estas dependiendo del día y el mes que introduzcas.");
        System.out.println();

        // Llamamos a la función Scanner.
        Scanner sc = new Scanner(System.in);

        // Preguntamos al usuario mes y día.
        System.out.print("Qué día es? ");
        int dia = Integer.parseInt(sc.nextLine());
        System.out.print("Qué mes es (en número)? ");
        int mes = Integer.parseInt(sc.nextLine());

        // Declaramos la variable estación.
        String estacion = null;

        // Determinamos la estación.
        if (mes <= 0 || mes > 12) {
            System.out.println("El més introducido no es válido.");
            System.exit(1);
        } else if (dia <= 0 || dia > 31) {
            System.out.println("El día introducido no es válido.");
            System.exit(2);
        } else if (mes < 4) {
            if (mes < 3) {
                estacion = "invierno";
            } else if (mes == 3 && dia < 20) {
                estacion = "invierno";
            } else {
                estacion = "primavera";
            }
        } else if (mes < 7) {
            if (mes < 6) {
                estacion = "primavera";
            } else if (mes == 6 && dia < 21) {
                estacion = "primavera";
            } else {
                estacion = "verano";
            }
        } else if (mes < 10) {
            if (mes < 9) {
                estacion = "verano";
            } else if (mes == 9 && dia < 22) {
                estacion = "verano";
            } else {
                estacion = "otoño";
            }
        } else {
            if (mes < 12) {
                estacion = "otoño";
            } else if (mes == 12 && dia < 21) {
                estacion = "otoño";
            } else {
                estacion = "invierno";
            }
        }

        // Imprimimos la estación por pantalla.
        System.out.printf("Estamos en %s", estacion);
    }
}
