import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class Prueba2 {
    public static void main(String[] args) {
        String cadena = "Zero";

        int longitud = cadena.length() - 1;

        cadena = cadena.replace(" and", "");
        cadena = cadena.replace("-", " ");
        cadena = cadena.toLowerCase();

        System.out.println(cadena);

        String[] cadenaSeparada = cadena.split(" ");

        System.out.println(Arrays.toString(cadenaSeparada));

        long numero = 0;
        long resultado = 0;

        for (int i = 0; i < cadenaSeparada.length; i++) {
            if (!potencias(cadenaSeparada[i])) {
                if (cadenaSeparada[i].equals("hundred")) {
                    numero *= 100;
                } else if (cadenaSeparada[i].endsWith("ty")) {
                    numero += tenMultiplesSay(cadenaSeparada[i]);
                } else {
                    numero += zeroToNineteenSay(cadenaSeparada[i]);
                }
            } else {
                resultado += multiplicarPorPotencia(numero, cadenaSeparada[i]);
                numero = 0;
            }
        }

        resultado += numero;

        System.out.println(resultado);
    }

    private static int zeroToNineteenSay(String word) {
        String[] array0_19 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        int pos = 0;

        while (pos < array0_19.length) {
            if (word.equals(array0_19[pos])) {
                break;
            }
            pos++;
        }

        return pos;
    }

    private static int tenMultiplesSay(String word) {
        String[] array20_90 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        int pos = 0;

        while (pos < array20_90.length) {
            if (word.equals(array20_90[pos])) {
                break;
            }
            pos++;
        }

        return (pos + 2) * 10;
    }

    private static boolean potencias(String word) {
        String[] sufijos = {"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion"};

        boolean potencia = false;

        for (int i = 0; i < sufijos.length; i++) {
            if (word.equals(sufijos[i])) {
                potencia = true;
            }
        }

        return potencia;
    }

    private static long multiplicarPorPotencia(long numero, String potencia) {
        String[] sufijos = {"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion"};

        for (int i = 0; i < sufijos.length; i++) {
            if (sufijos[i].equals(potencia)) {
                numero *= Math.pow(10, i * 3);
            }
        }

        return numero;
    }
}

