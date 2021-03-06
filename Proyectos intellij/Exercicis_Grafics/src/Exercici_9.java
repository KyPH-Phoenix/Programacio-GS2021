import java.util.Scanner;

public class Exercici_9 {
    // Llamamos a la función Turtle de forma global.
    static Turtle turtle = new Turtle(800, 800);

    // Función para dibujar el triángulo.
    private static void triangulo(double hipotenusa, double anguloAlpha, int longitudLado) {
        turtle.forward((int) hipotenusa);
        turtle.turnRight(180 - (int) anguloAlpha);
        turtle.forward(longitudLado);
        turtle.turnRight(180 - (int) anguloAlpha);
        turtle.forward((int) hipotenusa);
    }

    public static void main(String[] args) {
        // Llamamos a la función Scanner.
        Scanner sc = new Scanner(System.in);

        // Pedimos variables al usuario.
        System.out.println("Numero de triángulos: ");
        int numeroTriangulos = Integer.parseInt(sc.nextLine());
        System.out.println("Longitud del lado: ");
        int longitudLado = Integer.parseInt(sc.nextLine());

        // Sacamos los angulos de cada triángulo que faltan.
        double anguloBeta = 360.0 / numeroTriangulos;
        double anguloAlpha = (180.0 - anguloBeta) / 2.0;

        // Scamos la hipotenusa con la formula: Hipotenusa = (Lado / 2) / cos(Alpha)
        double hipotenusa = (longitudLado / 2.0) / Math.cos((anguloAlpha * Math.PI) / 180);

        // Dibujamos el circulo de triángulos.
        for (int i = 0; i < numeroTriangulos; i++) {
            turtle.resetAngle();
            double anguloFinal = (anguloBeta * i) - (anguloBeta / 2);
            turtle.turnRight((int) anguloFinal);
            triangulo(hipotenusa, anguloAlpha, longitudLado);
        }

        // Mostramos el dibujo.
        turtle.show();
    }
}
