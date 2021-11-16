public class Exercici_8 {
    // Llamamos a la función Turtle de forma global.
    static Turtle turtle = new Turtle(800, 800);

    // Función para dibujar un triángulo.
    private static void tirangulo() {
        for (int i = 0; i < 3; i++) {
            turtle.forward(200);
            turtle.turnRight(120);
        }
    }

    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa dibuja la siguiente figura:");
        System.out.println();

        // Hacemos los cuatro triángulos.
        turtle.turnLeft(30);
        for (int i = 0; i < 4; i++) {
            tirangulo();
            turtle.turnRight(90);
        }

        // Muestra el dibujo.
        turtle.show();
    }
}
