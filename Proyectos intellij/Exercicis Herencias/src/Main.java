import Exercici2.Circle;

public class Main {
    public static void main(String[] args) {
        Circle cir1 = new Circle();
        Circle cir2 = new Circle(5);

        System.out.println(cir1.toString());
        System.out.println(cir2.toString());
    }
}
