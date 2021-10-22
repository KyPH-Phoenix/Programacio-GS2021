/*
Este programa calcula y muestra por pantalla los primeros 40 numeros primos. 197
 */

public class Exercici_5_v2 {
    public static void main(String[] args) {
        // Descripcion del programa
        System.out.println("Este programa calcula y muestra por pantalla los " +
                "primeros 40 numeros primos.");
        System.out.println();

        // Declaración de variables.
        int ciclo = 1;
        int candidato = 1;
        int sumaPrimos = 0;
        boolean esPrimo;

        // Ciclo para detectar que es primo.
        while (ciclo <= 40) {
            esPrimo = true;
            // Para añadir el 1 y el 2.
            if (candidato <= 2) {
                esPrimo = true;
            }

            // El resto de números.
            else {
                for (int divisor = 2; divisor < candidato; divisor++) {
                    if (candidato % divisor == 0) {
                        esPrimo = false;
                    }
                }
            }

            // Si es primo listamos el número y lo sumamos a un total de numeros primos.
            if (esPrimo) {
                sumaPrimos = sumaPrimos + candidato;
                System.out.println(ciclo + ". " + candidato);
                ciclo++;
            }
            candidato++;
        }

        // Imprime la suma de los numeros.
        System.out.println();
        System.out.println("La suma de estos numero es: " + sumaPrimos);
    }
}

