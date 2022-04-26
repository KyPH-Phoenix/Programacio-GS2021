package Exercici2;

public class Main {
    public static void main(String[] args) {
        Circle cir1 = new Circle();
        Circle cir2 = new Circle(5);

        System.out.println("\nCirculos");
        System.out.println(cir1);
        System.out.println(cir2);

        Cylinder cyl1 = new Cylinder();
        Cylinder cyl2 = new Cylinder(3, 7);

        System.out.println("\nCilindros");
        System.out.println(cyl1);
        System.out.println(cyl2);
    }
}
