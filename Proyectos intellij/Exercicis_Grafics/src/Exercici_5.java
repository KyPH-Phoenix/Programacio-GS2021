import java.util.Scanner;

public class Exercici_5 {
    // Llamamos al a función Turtle de forma global
    static Turtle turtle = new Turtle(800, 800);

    // Función para hacer un cuadrado.
    private static void cuadrado(int lado) {
        for (int i = 0; i < 4; i++) {
            turtle.forward(lado);
            turtle.turnRight(90);
        }
    }

    // Funcion para pasar al siguiente cuadrado
    private static void siguienteCuadrado(){
        turtle.penDown = false;
        turtle.turnLeft(90);
        turtle.forward(20);
        turtle.turnLeft(90);
        turtle.forward(20);
        turtle.turnLeft(180);
        turtle.penDown = true;
    }

    public static void main(String[] args) {
        // Descipción del programa.
        System.out.println("Este programa dibuja una sucesión de cuadrados uno dentro del otro.");
        System.out.println();

        // Llamamos a la función Scanner.
        Scanner sc = new Scanner(System.in);

        // Pedimos los parámetros al usuario.
        System.out.print("Numero de cuadrados: ");
        int numeroCuadrados = Integer.parseInt(sc.nextLine());
        System.out.print("Longitud del primer cuadrado: ");
        int longitudLado = Integer.parseInt(sc.nextLine());

        // Ciclo para dibujar los cuadrados.
        for (int i = 0; i < numeroCuadrados; i++) {
            cuadrado(longitudLado);
            siguienteCuadrado();
            // Aumentamos el tamaño del lado para cada ciclo.
            longitudLado += (20*2);
        }

        // Mostramos el dibujo.
        turtle.show();
    }
}
