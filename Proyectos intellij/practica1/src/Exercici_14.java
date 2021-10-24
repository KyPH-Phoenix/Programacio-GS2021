/*
Este programa hece el equivalente en "while" del codigo "for( a=0, b=0; a < 7; a++, b+=2".
*/

public class Exercici_14 {
    public static void main(String[] args) {
        // Descripción del programa.
        System.out.println("Este programa hece el equivalente en \"while\" del codigo \"for( a=0, b=0; a < 7; a++, b+=2\".");
        System.out.println();

        // Declaración de variables.
        int a = 0;
        int b = 0;

        // Ciclo
        while (a < 7) {
            a++;
            b+=2;

            // Simplemente pongo un print b para saber si se está ejecutando correctamente el ciclo.
            System.out.println(b);
        }

        // Print de a para saber si ha llegado a 7.
        System.out.println();
        System.out.println(a);
    }
}
