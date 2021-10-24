/*
Este programa determina si la no te de un alumno es insuficiente, suficiente, bien, notable o excelente dependiendo de
su valor.

0-4 Insuficiente
5 Suficiente
6-7 Bien
8 Notable
9-10 Excelente
 */

import java.util.Scanner;

public class Exercici_13 {
    public static void main(String[] args) {
        // Descripción del programa
        System.out.println("Este programa determina si la no te de un alumno es insuficiente, suficiente, bien, " +
                "notable o excelente dependiendo de \n" +
                "su valor.");
        System.out.println();

        // Llamamos a la función Scanner.
        Scanner sc = new Scanner(System.in);

        // Pedimos valores al usuario.
        System.out.print("Introduce tu nota: ");
        int notaValor = Integer.parseInt(sc.nextLine());

        // Declaramos la variable notaTexto.
        String notaTexto = null;

        // Comprobación de la nota.
        if (notaValor < 0 || notaValor > 10) {
            System.out.println("La nota no es válida");
            System.exit(1);
        }
        if (notaValor < 5) {
            notaTexto = "INSUFICIENTE";
        } else if (notaValor < 6) {
            notaTexto = "SUFICIENTE";
        } else if (notaValor < 8) {
            notaTexto = "BIEN";
        } else if (notaValor < 9) {
            notaTexto = "NOTABLE";
        } else {
            notaTexto = "EXCELENTE";
        }
        System.out.printf("Tu nota es un %s.", notaTexto);
    }
}
