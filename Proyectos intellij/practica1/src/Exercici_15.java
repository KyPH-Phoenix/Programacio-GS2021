/*
Este programa es un bucle infinito. Como la condición para que el bucle termine no se cumple nunca, seguirá ejecutándose
hasta que se termine el programa manualmente.
 */

public class Exercici_15 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa es un bucle infinito. Como la condición para que el bucle termine no se\n" +
                "cumple nunca, seguirá ejecutándose hasta que se termine el programa manualmente.");
        System.out.println();

        // Declaración de variables.
        int i = 0;

        // Bucle.
        while (true){
            i++;
            if (i < 10)
                continue;
            i++;
            if (i == 10)
                break;
        }
    }
}
