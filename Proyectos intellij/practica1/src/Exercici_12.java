/*
Este programa nos muestra el signo del zodiaco de una persona dependiendo de su fecha de nacimiento.
 */

import java.util.Scanner;

public class Exercici_12 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa nos muestra el signo del zodiaco de una persona dependiendo de su fecha de nacimiento.");
        System.out.println();

        // Llamamos a la función Scanner.
        Scanner sc = new Scanner(System.in);

        // Pedimos las variables al usuario.
        System.out.print("En que día naciste? ");
        int dia = Integer.parseInt(sc.nextLine());
        System.out.print("En qué mes naciste (0-12)? ");
        int mes = Integer.parseInt(sc.nextLine());

        // Declaramos la variable signo.
        String signo = null;

        // Determinamos la estación.
        if (mes <= 0 || mes > 12) {
            System.out.println("El més introducido no es válido.");
            System.exit(1);
        } else if (dia <= 0 || dia > 31) {
            System.out.println("El día introducido no es válido.");
            System.exit(2);
        }

        switch (mes) {
            case 1:
                if (dia < 21) {
                    signo = "capricornio";
                } else {
                    signo = "acuario";
                }
                break;
            case 2:
                if (dia < 19) {
                    signo = "acuario";
                } else {
                    signo = "piscis";
                }
                break;
            case 3:
                if (dia < 21) {
                    signo = "piscis";
                } else {
                    signo = "aries";
                }
                break;
            case 4:
                if (dia < 21) {
                    signo = "aries";
                } else {
                    signo = "tauro";
                }
                break;
            case 5:
                if (dia < 21) {
                    signo = "tauro";
                } else {
                    signo = "geminis";
                }
                break;
            case 6:
                if (dia < 22) {
                    signo = "geminis";
                } else {
                    signo = "cancer";
                }
                break;
            case 7:
                if (dia < 23) {
                    signo = "cancer";
                } else {
                    signo = "leo";
                }
                break;
            case 8:
                if (dia < 23) {
                    signo = "leo";
                } else {
                    signo = "virgo";
                }
                break;
            case 9:
                if (dia < 23) {
                    signo = "virgo";
                } else {
                    signo = "libra";
                }
                break;
            case 10:
                if (dia < 23) {
                    signo = "libra";
                } else {
                    signo = "escorpio";
                }
                break;
            case 11:
                if (dia < 23) {
                    signo = "escorpio";
                } else {
                    signo = "sagitario";
                }
                break;
            case 12:
                if (dia < 22) {
                    signo = "sagitario";
                } else {
                    signo = "capricornio";
                }
                break;
        }

        // Imprimimos la estación por pantalla.
        System.out.println();
        System.out.printf("Tu signo del zodiaco es %s.", signo);
    }
}
