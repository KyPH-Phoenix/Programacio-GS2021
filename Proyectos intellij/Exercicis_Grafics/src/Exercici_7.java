import java.util.Scanner;

public class Exercici_7 {
    static Turtle turtle = new Turtle(800, 800);

    private static void hoja (double grados) {
        turtle.turnLeft((int)grados/3);
        for (int j = 0; j < 100; j++) {
            turtle.forward(5);
            turtle.turnRight(1);
        }
        turtle.turnRight(80);
        for (int j = 0; j < 100; j++) {
            turtle.forward(5);
            turtle.turnRight(1);
        }
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.print("Número de hojas: ");
        int nHojas = Integer.parseInt(sc.nextLine());

        double grados = 360.0 / nHojas;

        for (int i = 0; i < nHojas; i++) {
            turtle.turnRight((int) grados*i);
            hoja(grados);
            turtle.goTo(0, 0);
            turtle.resetAngle();
        }
        turtle.show();
    }
}
