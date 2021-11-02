import java.util.Scanner;

public class Exercici_2 {
    static Turtle turtle=new Turtle(900, 900);

    private static void escalonAbajo(int longitudEscalon, int alturaEscalon) {
        turtle.forward(longitudEscalon);
        turtle.turnRight(90);
        turtle.forward(alturaEscalon);
        turtle.turnLeft(90);
    }

    private static void escalonArriba(int longitudEscalon, int alturaEscalon) {
        turtle.turnLeft(90);

    }

    public static void main(String[] args) {
        // Descripción del prigrama.
        System.out.println();
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

        turtle.forward(longEscalon*2);

        for (int i = 0; i < numEscalones; i++) {

        }
        turtle.show();
    }
}
