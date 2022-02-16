public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(new float[]{1, 0, 2, 0, -1, -8});
        Polynomial p2 = new Polynomial("x^2 - 2x + 1");

        p1 = new Polynomial("-5x^7 + 42x^3 - 9");
        System.out.println(p1.toString());
    }
}
