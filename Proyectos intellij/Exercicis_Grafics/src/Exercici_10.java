public class Exercici_10 {
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
        System.out.println();
        System.out.println();

        int longitud = 115;

        primerSemicirculo(longitud);
        segundoSemicirculo(longitud);

        turtle.show();

        double cosa = 360 / (2 * Math.PI);
        System.out.println(cosa*2);
    }
}
