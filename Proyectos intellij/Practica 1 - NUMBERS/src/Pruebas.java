import java.util.Arrays;

public class Pruebas {
    public static void main(String[] args) {
        long n = 136;
        long[] array = new long[4];

        for (int i = array.length; i > 0; i--) {
            double potencia = Math.pow(10, i - 1);
            if ((long) (n / potencia) != 0) {
                array[array.length - i] = (long) (n / potencia);
                n = (long) (n % potencia);
            } else {
                array[array.length - i] = 0;
            }
        }

        int variableCualquiera = 0;

        for (int i = 0; i < array.length; i++) {
            variableCualquiera = array.length - i;
            if (array[i] != 0) {
                break;
            }
        }

        /*if (variableCualquiera > 3) {
            // millares

        } else {
            while (variableCualquiera > 0) {

            }
        }*/

        String centenas = zeroToNineteen(array.length - variableCualquiera) + " hundred";
        String resultado = centenas;
        variableCualquiera--;
        String decenas = "";
        String unidades = "";
        String decenunidades = "";

        if (array[array.length - variableCualquiera] < 2) {
            long menosQue20 = (array[array.length - variableCualquiera] * 10) + array[array.length - variableCualquiera + 1];
            decenunidades = zeroToNineteen((int) menosQue20);
            resultado = resultado + " and " + decenunidades;
        } else {
            if (array[array.length - variableCualquiera] != 0) {
                decenas = tenMultiples((int) array[variableCualquiera]);
                resultado = centenas + " and " + decenas;
                if (array[array.length - variableCualquiera + 1] != 0) {
                    resultado = resultado + "-";
                }
            }
            variableCualquiera--;
            if (array[array.length - variableCualquiera] != 0) {
                unidades = zeroToNineteen((int) array[array.length - variableCualquiera]);
            }
            resultado = resultado + unidades;
        }

        System.out.println(Arrays.toString(array));
        System.out.println(variableCualquiera);
        System.out.println(resultado.substring(0,1).toUpperCase() + resultado.substring(1));
    }

    private static int[] convertirArray (long n) {
        int[] array = new int[21];

        for (int i = array.length; i > 0; i--) {
            double magnitud = Math.pow(10, i);
            if ((long) (n / magnitud) != 0) {
                array[array.length - i] = (int) (n / magnitud);
                n = (long) (n % magnitud);
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
