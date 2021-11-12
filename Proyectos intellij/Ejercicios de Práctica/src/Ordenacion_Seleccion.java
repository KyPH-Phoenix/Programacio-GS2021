import java.util.Arrays;

public class Ordenacion_Seleccion {
    private static int trobarMinim (int[] numbers, int n) {
        // n = donde empieza
        // numbers = array
        int pos = n;
        int length = numbers.length;
        System.out.println(length);
        int num = numbers[n];

        for (int i = 0; i < length; i++) {
            if (num > numbers[pos]) {
                num = numbers[i];
                pos = i;
            }
        }
        return(pos);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 5, 7, -3, 6, -5, 8, 15, 25, 12, -84, -7, 10};

        for (int i = 0, n = numbers.length; i < n; i++) {
            int pos = trobarMinim(numbers, i);
            int t = numbers[i];
            numbers[i] = numbers[pos];
            numbers[pos] = t;
        }
        System.out.println(Arrays.toString(numbers));
    }
}
