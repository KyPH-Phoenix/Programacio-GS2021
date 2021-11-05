public class Exercici_8 {
    static Turtle turtle = new Turtle(800, 800);

    private static void tirangulo () {
        for (int i = 0; i < 3; i++) {
            turtle.forward(200);
            turtle.turnRight(120);
        }
    }

    public static void main(String[] args) {
        turtle.turnLeft(30);
        for (int i = 0; i < 4; i++) {
            tirangulo();
            turtle.turnRight(90);
        }
        turtle.show();
    }
}
