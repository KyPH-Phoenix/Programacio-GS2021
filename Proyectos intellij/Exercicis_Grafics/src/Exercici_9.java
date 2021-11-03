import java.util.Scanner;

public class Exercici_9 {
    static Turtle turtle = new Turtle(800, 800);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Numero de triángulos: ");
        int numeroTriangulos = Integer.parseInt(sc.nextLine());
        System.out.println("Longitud del lado: ");
        int longitudLado = Integer.parseInt(sc.nextLine());

        double anguloBeta = 360.0 / numeroTriangulos;
        double anguloAlpha = (180 - anguloBeta) / 2;
        anguloAlpha = (anguloAlpha * Math.PI) / 180.0;
        int ladoRestante = longitudLado;
    }
}
