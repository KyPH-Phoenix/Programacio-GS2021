package Exercici3;

public class Main {
    public static void main(String[] args) {
        Shape sh1 = new Shape();
        Shape sh2 = new Shape("Blue", false);

        System.out.println(sh1);
        System.out.println(sh2);

        System.out.println("\nCirculos");

        Circle cir1 = new Circle();
        Circle cir2 = new Circle(3);
        Circle cir3 = new Circle(5, "Orange", false);

        System.out.println(cir1);
        System.out.println(cir2);
        System.out.println(cir3);
    }
}
