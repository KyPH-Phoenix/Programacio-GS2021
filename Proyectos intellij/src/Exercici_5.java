/*
Este programa calcula y muestra por pantalla los primeros 40 numeros primos. 197
 */

public class Exercici_5 {
    public static void main(String[] args) {
        // Descripcion del programa
        System.out.println("Este programa calcula y muestra por pantalla los " +
                "primeros 40 numeros primos.");
        System.out.println();

        // Declaración de variables.
        int ciclo = 1;
        int numero = 1;
        int sumaNumerosPrimos = 0;

        for (;ciclo < 40; ciclo++) {
            int x = 0;
            int divisor = 2;
            while (x == 0) {
                if (numero <= 2) {
                    sumaNumerosPrimos = sumaNumerosPrimos + numero;
                    x++;
                }
                else {
                    while (divisor < numero) {


                        }
                    }
                }
            }
            numero++;
        }

        // Imprime el resultado.
        System.out.println(sumaNumerosPrimos);
    }
}
