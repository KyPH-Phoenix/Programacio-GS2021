import java.util.Locale;

public class Numbers {
    public static String say(long n) {

        int[] digits = convertirArray(n);
        int longitudNumero = cifrasNumero(digits);

        String resultado = sacarCentenas(longitudNumero, digits);

        //System.out.println(resultado.substring(0,1).toUpperCase() + resultado.substring(1));

        return resultado.substring(0,1).toUpperCase() + resultado.substring(1);
    }

    public static long words(String s) {

        return 0;
    }

    private static String sacarCentenas (int longitudNumero, int[] array) {
        String centenas = "";
        String decenunidades = "";
        String decenas = "";
        String unidades = "";

        String resultado = "";

        // Cifra de las centenas
        if (longitudNumero % 3 == 0) {
            centenas = zeroToNineteen((int) array[array.length - longitudNumero]) + " hundred";
            resultado = centenas;

            // Añade un and si los digitos de despues no son 0.
            if (array[array.length - longitudNumero + 1] + array[array.length - longitudNumero + 2] != 0) {
                resultado = resultado + " and ";
            }
            // Pasa a la siguiente cifra
            longitudNumero--;
        }

        long decenasyUnidades = 0;

        if (longitudNumero > 1) {
            decenasyUnidades = (array[array.length - longitudNumero] * 10) + array[array.length - longitudNumero + 1];
        }

        if (array[array.length - longitudNumero] < 2 && decenasyUnidades > 0) {
            decenunidades = zeroToNineteen((int) decenasyUnidades);
            resultado = resultado + decenunidades;
        } else {
            if (array[array.length - longitudNumero] != 0 && longitudNumero == 2) {
                decenas = tenMultiples(array[array.length - longitudNumero]);
                resultado = resultado +  decenas;
                if (array[array.length - longitudNumero + 1] != 0) {
                    resultado = resultado + "-";
                }
                longitudNumero--;
            }

            if (array[array.length - longitudNumero] != 0 && longitudNumero == 1) {
                unidades = zeroToNineteen((int) array[array.length - longitudNumero]);
            }
            resultado = resultado + unidades;
        }

        return resultado;
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

