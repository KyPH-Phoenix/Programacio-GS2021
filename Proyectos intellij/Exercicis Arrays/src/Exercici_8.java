import java.util.Arrays;
import java.util.Scanner;

public class Exercici_8 {
    private static int[][] copia(int[][] arrayOriginal) {
        int[][] arrayCopia = new int[arrayOriginal.length][];
        for (int i = 0; i < arrayOriginal.length; i++) {
            arrayCopia[i] = new int[arrayOriginal[i].length];
            for (int j = 0; j < arrayOriginal[i].length; j++) {
                arrayCopia[i][j] = arrayOriginal[i][j];
            }
        }
        return arrayCopia;
    }

    private static void primeraDim(int[][] array, Scanner sc) {

        System.out.print("¿Cuántos números tiene la primera dimensión del array? ");
        int dimension1 = Integer.parseInt(sc.nextLine());
        array[0] = new int[dimension1];
        for (int i = 0; i < dimension1; i++) {
            System.out.print("Introduce número: ");
            int valor = Integer.parseInt(sc.nextLine());
            array[0][i] = valor;
        }
    }

    private static void segundaDim(int[][] array, Scanner sc) {
        System.out.print("¿Cuántos números tiene la segunda dimensión de tu array? ");
        int dimension2 = Integer.parseInt(sc.nextLine());
        array[1] = new int[dimension2];
        for (int i = 0; i < dimension2; i++) {
            System.out.print("Introduce número: ");
            int valor = Integer.parseInt(sc.nextLine());
            array[1][i] = valor;
        }
    }

    private static void imprimir(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("{");
            for (int j = 0; j < array[i].length; j++) {
                if (j < 1) {
                    System.out.print(array[i][j]);
                }
                else {
                    System.out.print(", " + array[i][j]);
                }
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[2][];
        Scanner sc = new Scanner(System.in);
        primeraDim(array, sc);
        segundaDim(array, sc);
        int[][] arrayReplica = copia(array);
        imprimir(arrayReplica);
    }
}
