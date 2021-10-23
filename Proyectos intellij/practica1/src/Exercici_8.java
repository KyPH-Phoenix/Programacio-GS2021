/*
Este programa pasa las horas de formato 24h a AM/PM dada una hora por el usuario.
 */

import java.util.Scanner;

public class Exercici_8 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa pasa las horas de formato 24h a AM/PM dada una hora por el usuario.");
        System.out.println("");

        // Llamamos a la funcion Scanner.
        Scanner sc = new Scanner(System.in);

        // Pedimos la hora al usuario
        System.out.print("Introduce la hora: ");
        int hora = Integer.parseInt(sc.nextLine());
        System.out.print("Introduce el minuto: ");
        int minuto = Integer.parseInt(sc.nextLine());
        System.out.print("Introduce el segundo: ");
        int segundo = Integer.parseInt(sc.nextLine());

        // Condicion para terminar el programa si la hora introducida no es válida
        if (hora < 0 || hora > 23) {
            System.out.println("La hora no debe ser menor que 0 ni mayor que 23");
            System.exit(1);
        }
        if (minuto < 0 || minuto > 59) {
            System.out.println("El minuto no debe ser menor que 0 ni mayor que 59");
            System.exit(1);
        }
        if (segundo < 0 || minuto > 59) {
            System.out.println("El segundo no debe ser menor que 0 ni mayor que 59");
            System.exit(1);
        }

        String sufijo;

        // Transformamos la hora si es necesario. Solo se hara la transformación si la hora es mayor que 12.
        if (hora < 12) {
            sufijo = "AM";
        } else {
            sufijo = "PM";
        }
        switch (hora) {
            case 0:
                hora = 12;
                break;
            case 13,14,15,16,17,18,19,20,21,22,23,24:
                hora = hora - 12;
                break;
        }

        // Imprimimos la hora por pantalla.
        System.out.printf("La hora es: %d:%d:%d %s", hora, minuto,segundo, sufijo);

    }
}
