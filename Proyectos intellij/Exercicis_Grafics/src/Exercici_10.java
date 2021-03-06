public class Exercici_10 {
    // Llamamos a la función Turtle de forma global.
    static Turtle turtle = new Turtle(800, 800);

    private static void primerSemicirculo(int longitud) {
        // primera linea recta de la figura.
        turtle.forward(longitud);

        // Hcemos la curva
        turtle.turnRight(90);
        for (int i = 0; i < 90; i++) {
            turtle.forward(2);
            turtle.turnRight(1);
        }
        // Este es un pixel que falta en la figura por la precisión del programa, lo he añadido manualmente para que sea simétrica.
        turtle.forward(1);

        // Segunda linea recta de la figura.
        turtle.turnRight(90);
        turtle.forward(longitud);
    }

    private static void segundoSemicirculo(int longitud) {
        // primera linea recta de la figura.
        turtle.forward(longitud);

        // Hcemos la curva
        turtle.turnLeft(90);
        for (int i = 0; i < 90; i++) {
            turtle.forward(2);
            turtle.turnLeft(1);
        }
        // Este es un pixel que falta en la figura para que sea simétrica, lo he añadido manualmente.
        turtle.forward(1);

        // Segunda linea recta de la figura.
        turtle.turnLeft(90);
        turtle.forward(longitud);
    }

    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa representa la siguiente figura:");
        System.out.println();

        // Longitud del radio.
        int longitud = 115;

        // Pintamos la figura.
        primerSemicirculo(longitud);
        segundoSemicirculo(longitud);

        // Mostramos el dibujo.
        turtle.show();
    }
}
