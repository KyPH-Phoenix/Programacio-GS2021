import java.util.Arrays;

public class Pruebas {
    public static void main(String[] args) {
        long n = 1;
        int[] array = convertirArray(n);
        int variableCualquiera = cifrasNumero(array);

        System.out.println(Arrays.toString(array));
        System.out.println(variableCualquiera);

        String decenas = "";
        String unidades = "";
        String decenunidades = "";
        String centenas = "";
        String resultado = "";

        // Cifra de las centenas
        if (variableCualquiera % 3 == 0) {
            centenas = zeroToNineteen((int) array[array.length - variableCualquiera]) + " hundred";
            resultado = centenas;

            // Añade un and si los digitos de despues no son 0.
            if (array[array.length - variableCualquiera + 1] + array[array.length - variableCualquiera + 2] != 0) {
                resultado = resultado + " and ";
            }
            // Pasa a la siguiente cifra
            variableCualquiera--;
        }

        long decenasyUnidades = 0;

        if (variableCualquiera > 1) {
            decenasyUnidades = (array[array.length - variableCualquiera] * 10) + array[array.length - variableCualquiera + 1];
        }

        if (array[array.length - variableCualquiera] < 2 && decenasyUnidades > 0) {
            decenunidades = zeroToNineteen((int) decenasyUnidades);
            resultado = resultado + decenunidades;
        } else {
            if (array[array.length - variableCualquiera] != 0 && variableCualquiera == 2) {
                decenas = tenMultiples(array[array.length - variableCualquiera]);
                resultado = resultado +  decenas;
                if (array[array.length - variableCualquiera + 1] != 0) {
                    resultado = resultado + "-";
                }
                variableCualquiera--;
            }

            if (array[array.length - variableCualquiera] != 0 && variableCualquiera == 1) {
                unidades = zeroToNineteen((int) array[array.length - variableCualquiera]);
            }
            resultado = resultado + unidades;
        }

        System.out.println(resultado.substring(0,1).toUpperCase() + resultado.substring(1));
    }

    private static int cifrasNumero(int[] arrayDigits) {
        int longitudNumero = 0;

        for (int i = 0; i < arrayDigits.length; i++) {
            longitudNumero = arrayDigits.length - i;
            if (arrayDigits[i] != 0) {
                break;
            }
        }

        return longitudNumero;
    }

    private static int[] convertirArray (long n) {
        int[] array = new int[21];

        for (int i = array.length; i > 0; i--) {
            double potencia = Math.pow(10, i - 1);
            if ((long) (n / potencia) != 0) {
                array[array.length - i] = (int) (n / potencia);
                n = (long) (n % potencia);
            } else {
                array[array.length - i] = 0;
            }
        }
        return array;
    }

    private static String zeroToNineteen(int n) {
        String[] array0_19 = {"zero","one","two","three","four","five","six", "seven","eight","nine","ten","eleven",
                "twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};

        return array0_19[n];
    }

    private static String tenMultiples(int n) {
        n = (n) - 2;

        String[] array20_90 = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

        return array20_90[n];
    }
}
