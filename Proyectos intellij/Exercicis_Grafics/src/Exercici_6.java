import java.util.Scanner;

public class Exercici_6 {
    // Llamamos a la función Turtle de forma global.
    static Turtle turtle = new Turtle(800, 800);

    // Función para dibujar una vuelta de la espiral.
    private static void vuelta(int lado, int angulo, int numeroLados) {
        for (int i = 0; i < numeroLados; i++) {
            turtle.forward(lado);
            turtle.turnRight(angulo);
            lado += 5;
        }
    }

    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa dibuja una espiral de una forma geométrica.");
        System.out.println();

        // Llamamos a la función Scanner.
        Scanner sc = new Scanner(System.in);

        // Pedimos los parámetros al usuario.
        System.out.print("Número de vueltas de la espiral: ");
        int numeroVueltas = Integer.parseInt(sc.nextLine());
        System.out.print("Número de lados del polígono base: ");
        int numeroLados = Integer.parseInt(sc.nextLine());

        // Definimos algunas variables.
        int angulo = 360 / numeroLados;
        int lado = 40;

        // Ciclo para hacer la espiral.
        for (int i = 0; i < numeroVueltas; i++) {
            vuelta(lado, angulo, numeroLados);
            // Despues de cada vuelta aumento el tamaño de los lados correspondientemente.
            lado += (numeroLados * 5);
        }

        // Mostramos el dibujo.
        turtle.show();
    }
}
