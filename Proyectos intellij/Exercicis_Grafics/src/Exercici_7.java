import java.util.Scanner;

public class Exercici_7 {
    // Llamamos a la función Turtle de forma global.
    static Turtle turtle = new Turtle(800, 800);

    // Función para dibujar una hoja.
    private static void hoja(double grados) {
        // Primera mitad de la hoja
        turtle.turnLeft((int) grados / 3);
        for (int j = 0; j < 100; j++) {
            turtle.forward(5);
            turtle.turnRight(1);
        }
        // Segunda mitad de la hoja
        turtle.turnRight(80);
        for (int j = 0; j < 100; j++) {
            turtle.forward(5);
            turtle.turnRight(1);
        }
    }

    public static void main(String[] args) {
        // Descripción del programa
        System.out.println("Este programa pinta una flor.");
        System.out.println();

        // Llamamos a la función Scanner.
        Scanner sc = new Scanner(System.in);

        // Pedimos variables al usuario.
        System.out.print("Número de hojas: ");
        int nHojas = Integer.parseInt(sc.nextLine());

        // Sacamos el angulo para cada hoja.
        double grados = 360.0 / nHojas;

        // Pintamos las hojas.
        for (int i = 0; i < nHojas; i++) {
            turtle.turnRight((int) grados * i);
            hoja(grados);
            turtle.goTo(0, 0);
            turtle.resetAngle();
        }

        // Mostramos el dibujo.
        turtle.show();
    }
}
