import java.util.Arrays;

public class Pruebas {
    public static void main(String[] args) {
        long n = 165;
        int[] array = new int[4];

        for (int i = array.length; i > 0; i--) {
            double potencia = Math.pow(10, i-1);
            if ((long) (n / potencia) != 0) {
                array[array.length - i] = (int) (n / potencia);
                n = (long) (n % potencia);
            } else {
                array[array.length - i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
