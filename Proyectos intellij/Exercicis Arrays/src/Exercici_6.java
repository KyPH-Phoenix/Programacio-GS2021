import java.util.Arrays;
import java.util.Scanner;

public class Exercici_6 {
    private static boolean[][] crearArray(int dimensiones) {
        boolean[][] array = new boolean[dimensiones][];

        for (int i = 0; i < array.length; i++) {
            array[i] = new boolean[array.length];
        }
        return array;
    }

    private static void dibujarCruz(boolean[][] array) {
        int centro = array.length / 2;
        boolean par = (array.length & 1) == 0;
        for (int i = 0; i < array.length; i++) {
            array[centro][i] = array[i][centro] = true;
            if (par) {
                array[centro - 1][i] = array[i][centro - 1] = true;
            }
        }
    }

    private static void imprimir(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] ? '*' : ' ');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dimensiones del array: ");
        int dimensiones = Integer.parseInt(sc.nextLine());

        boolean[][] array = crearArray(dimensiones);
        dibujarCruz(array);
        imprimir(array);
    }
}
