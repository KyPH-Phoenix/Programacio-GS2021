import java.util.Arrays;

public class Pruebas {
    public static void main(String[] args) {
        long n = 165;
        long[] array = new long[4];

        for (int i = array.length; i > 0; i--) {
            double potencia = Math.pow(10, i - 1);
            if ((long) (n / potencia) != 0) {
                array[array.length - i] = (long) (n / potencia);
                n = (long) (n % potencia);
            } else {
                array[array.length - i] = 0;
            }
        }

        int variableCualquiera = 0;

        for (int i = 0; i < array.length; i++) {
            variableCualquiera = array.length - i;
            if (array[i] != 0) {
                break;
            }
        }

        if (variableCualquiera > 3) {
            // millares

        } else {
            // centenas
        }

        System.out.println(Arrays.toString(array));
        System.out.println(variableCualquiera);
    }
}
