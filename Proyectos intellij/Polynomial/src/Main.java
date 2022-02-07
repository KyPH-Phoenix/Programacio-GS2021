public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(new float[]{-1, 5, 0, 0, 6, 3});
        Polynomial p2 = new Polynomial("3x + 5 + 2x^2");

        System.out.println(p2.toString());
    }
}
