import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(new float[]{1, 0, 2, 0, -1, -8});
        Polynomial p2 = new Polynomial("x^2 - 2x + 1");

        Polynomial p = new Polynomial("x^7 + 89x^6 - 90x^5 + 10x^2 +890x - 900");
        //-90f, -1.5849f, 1f
        System.out.println(Arrays.toString(p.roots()));
    }
}
