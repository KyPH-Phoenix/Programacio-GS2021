public class Funciones {
    private static double dist(double x, double y) {
        double h;
        h = (x * x) + (y * y);
        h = Math.sqrt(h);
        return h;
    }

    private static int mitad(int a) {
        a = a / 2;
        return a;
    }

    public static void main(String[] args) {
        double x = 4;
        double y = 5;
        double h = dist(x, y);
        System.out.println();
        System.out.println(h);

        int a = 10;
        int b = mitad(a);
        System.out.println();
        System.out.println(b);
    }
}
