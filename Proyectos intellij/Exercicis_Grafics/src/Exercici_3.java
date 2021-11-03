/*
Este programa dibuja el numero de cuadrados en horizontal y vertical que el usuario quiere pero sin espacios.
 */

import java.util.Scanner;

public class Exercici_3 {
    // Llamamos a la función Turtle de forma global.
    static Turtle turtle = new Turtle(800, 800);

    // Función para hacer un cuadrado.
    private static void cuadrado(int lado) {
        for (int i = 0; i < 4; i++) {
            turtle.forward(lado);
            turtle.turnRight(90);
        }
    }

    // Función para dibujar una fila. Dibuja cuadrados en ciclo hasta que se cumple el numero de cuadrados
    private static void dibujaFila(int nCuadrados, int ladoCuadrado) {
        for (int i = 0; i < nCuadrados; i++) {
            cuadrado(ladoCuadrado);
            turtle.turnRight(90);
            turtle.forward(ladoCuadrado);
            turtle.turnLeft(90);
        }
    }

    // Función para pasar a la siguiente fila
    private static void goToNexRow(int nCuadrados, int longitudCuadrado) {
        turtle.penDown = false;
        turtle.turnLeft(90);
        turtle.forward(longitudCuadrado * nCuadrados);
        turtle.turnLeft(90);
        turtle.forward(longitudCuadrado);
        turtle.turnLeft(180);
        turtle.penDown = true;
    }

    // Función main
    public static void main(String[] args) {
        // Descripción del programa
        System.out.println("Este programa dibuja el numero de cuadrados en horizontal y vertical que el usuario quiere pero sin espacios.");
        System.out.println();

        // Llamamos a la función escáner.
        Scanner sc = new Scanner(System.in);

        // Pedimos las variables al usuario.
        System.out.print("Número de cuadrados horizontales: ");
        int nCuadradosHor = Integer.parseInt(sc.nextLine());
        System.out.print("Número de cuadrados verticales: ");
        int nCuadradosVer = Integer.parseInt(sc.nextLine());
        System.out.print("Longitud del lado del cuadrado: ");
        int longitudLado = Integer.parseInt(sc.nextLine());

        // Creamos el dibujo.
        for (int i = 0; i < nCuadradosVer; i++) {
            dibujaFila(nCuadradosHor, longitudLado);
            goToNexRow(nCuadradosHor, longitudLado);
        }

        // Mostramos el dibujo.
        turtle.show();
    }
}

