import java.util.Arrays;

public class Ordenacion_Bubble {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 7, -3, 6, -5, 8, 15, 25, 12, -84, -5, 10};

        for (int n = numbers.length; n > 1; n--) {
            for (int i = 0; i < n - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int a = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = a;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
