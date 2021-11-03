import java.util.Scanner;

public class Exercici_4 {
    // Llamamos al a función Turtle de forma global
    static Turtle turtle = new Turtle(800, 800);

    // Función que dibuja hojas a la izquierda.
    private static void hojaIzquierda(int tamañoHojas) {
        turtle.turnLeft(90);
        turtle.forward(tamañoHojas);
        turtle.turnRight(135);
        turtle.forward((int) Math.sqrt((tamañoHojas * tamañoHojas) * 2));
        turtle.turnLeft(45);
    }

    // Función que dibuja la punta del árbol.
    private static void punta(int tamañoHojas) {
        turtle.turnRight(45);
        turtle.forward(tamañoHojas / 3);
        turtle.turnRight(90);
        turtle.forward(tamañoHojas / 3);
    }

    // Función que dibuja hojas a la derecha.
    private static void hojaDerecha(int tamañoHojas) {
        turtle.forward((int) Math.sqrt((tamañoHojas * tamañoHojas) * 2));
        turtle.turnRight(135);
        turtle.forward(tamañoHojas);
        turtle.turnLeft(135);
    }

    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa pinta un árbol.");
        System.out.println();

        // Llamamos a la función Scanner.
        Scanner sc = new Scanner(System.in);

        // Pedimos los parámetros al usuario.
        System.out.print("Número de hojas: ");
        int numeroHojas = Integer.parseInt(sc.nextLine());
        System.out.print("Tamaño de hojas: ");
        int tamañoHojas = Integer.parseInt(sc.nextLine());

        // Primera parte del tronco.
        turtle.forward(tamañoHojas / 2);

        // Dibujamos la primera hilera de hojas
        for (int i = 0; i < numeroHojas; i++) {
            hojaIzquierda(tamañoHojas);
        }

        // Dibujamos la punta
        punta(tamañoHojas);

        // Dibujamos la segunda hilera de hojas
        for (int i = 0; i < numeroHojas; i++) {
            hojaDerecha(tamañoHojas);
        }

        // Dibujamos el segundo trozo del tronco.
        turtle.turnRight(45);
        turtle.forward(tamañoHojas / 2);

        // Mostramos el dibujo
        turtle.show();
    }
}
