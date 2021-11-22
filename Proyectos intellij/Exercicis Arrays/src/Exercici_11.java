/*
Este programa ordena un array usando bubble sort en 2 pasadas.
 */
import java.util.Arrays;

public class Exercici_11 {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, -1, -4, 9, 3, -2};

        // ordena array.
        bubbleSort2(array);
        System.out.println(Arrays.toString(array));
    }

    // Función para ordenar los números.
    private static void bubbleSort2(int[] array) {
        int limiteI = 0;
        int limiteD = array.length;

        while (limiteD > limiteI) {
            // Pasada 1
            for (int pos = 0; pos < limiteD - 1; pos++) {
                if (array[pos] > array[pos + 1]) {
                    int t = array[pos];
                    array[pos] = array[pos + 1];
                    array[pos + 1] = t;
                }
            }
            limiteD--;

            // Pasada 2.
            for (int pos = limiteI-1; pos > 0; pos--) {
                if (array[pos - 1] > array[pos]) {
                    int t = array[pos];
                    array[pos] = array[pos - 1];
                    array[pos - 1] = t;
                }
            }
            limiteI++;
        }
    }
}
