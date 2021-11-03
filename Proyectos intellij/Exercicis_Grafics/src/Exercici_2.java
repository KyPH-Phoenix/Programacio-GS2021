/*
Este programa dibuja una escalera con el numero de escalones y sus dimensiones proporcionados por el usuario.
 */

import java.util.Scanner;

public class Exercici_2 {
    // Llamamos a la función Turtle de forma global.
    static Turtle turtle = new Turtle(900, 900);

    // Función para hacer un escalon descendente.
    private static void escalonAbajo(int longitudEscalon, int alturaEscalon) {
        turtle.forward(longitudEscalon);
        turtle.turnRight(90);
        turtle.forward(alturaEscalon);
        turtle.turnLeft(90);
    }

    // Función para hacer un escalon ascendente.
    private static void escalonArriba(int longitudEscalon, int alturaEscalon) {
        turtle.turnLeft(90);
        turtle.forward(alturaEscalon);
        turtle.turnRight(90);
        turtle.forward(longitudEscalon);
    }

    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa dibuja una escalera con el numero de escalones y sus dimensiones proporcionados por el usuario.");
        System.out.println();

        // Llamamos a la función Scanner.
        Scanner sc = new Scanner(System.in);

        // Pedimos los valores al usuario.
        System.out.print("Longitud del escalón: ");
        int longEscalon = Integer.parseInt(sc.nextLine());
        System.out.print("Altura del escalón: ");
        int alturaEscalon = Integer.parseInt(sc.nextLine());
        System.out.print("Número de escalones: ");
        int numEscalones = Integer.parseInt(sc.nextLine());

        // Ponemos el puntero de turtle mirando hacia la derecha.
        turtle.turnRight(90);

        // Ciclo que dibuja los escalones descendentes
        for (int i = 0; i < numEscalones; i++) {
            escalonAbajo(longEscalon, alturaEscalon);
        }

        // Espacio entre escaleras.
        turtle.forward(longEscalon * 2);

        // Ciclo que dibuja los escalones ascendentes.
        for (int i = 0; i < numEscalones; i++) {
            escalonArriba(longEscalon, alturaEscalon);
        }

        // Muestra el dibujo.
        turtle.show();
    }
}
