import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(new float[]{1, 0, 2, 0, -1, -8});
        Polynomial p2 = new Polynomial("x^2 - 2x + 1");

        Polynomial p3 = new Polynomial("x^2 - 4");
        System.out.println(Arrays.toString(p3.roots()));
    }
}
