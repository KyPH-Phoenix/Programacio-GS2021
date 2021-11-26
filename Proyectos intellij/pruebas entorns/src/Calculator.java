public class Calculator {

    public static void main(String[] args) {
        StringBuilder new = resultado()
        String resultado = "";
        String hola = "hola";
        resultado = resultado + hola + " que tal";
        System.out.println(resultado);
        String tuMama = ". Me cago en tu madre";
        resultado = resultado + tuMama;
        System.out.println("------------");
        System.out.println(resultado);

    }


    static int add(int x, int y) {
        return x + y;
    }

    static int substract(int x, int y) {
        return x - y;
    }

    static int product(int x, int y) {
        return x * y;
    }

    static int divide(int x, int y) {
        return x / y;
    }

    static int remainder(int x, int y) {
        return x % y;
    }

    static double add(double x, double y) {
        return x + y;
    }

    static double substract(double x, double y) {
        return x - y;
    }

    static double multiply(double x, double y) {
        return x * y;
    }

    static double divide(double x, double y) {
        return x / y;
    }

    static double power(double b, double e) {
        double result = b;
        if (e == 0) {
            result = 1;
        } else {
            for (int i = 0; i < e; i++) {
                result = result * b;
            }
        }
        return result;
    }
}
