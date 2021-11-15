import java.util.Arrays;
import java.util.Scanner;

public class Exercici_4 {
    private static void inverteix(int[] array){
        for (int i = 0; i < array.length / 2; i++) {
            int t = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = t;
        }
    }

    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa invierte un array.");
        System.out.println();

        int[] array = {1, 5, 4, -8, 9, 15, 17};

        System.out.println("Original:");
        System.out.println(Arrays.toString(array));
        System.out.println();

        inverteix(array);

        System.out.println("Invertidoº:");
        System.out.println(Arrays.toString(array));
    }
}
