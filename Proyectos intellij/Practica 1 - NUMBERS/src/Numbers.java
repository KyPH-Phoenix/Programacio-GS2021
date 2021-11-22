import java.util.Locale;

public class Numbers {
    public static String say(long n) {
        /*
        Declaración de variables. En este caso la nomenclatura es:
            - Las primeras letras corresponden a la magnitud. Ej: bil = Bilion, thou = Thousand, tril = Trillion, etc.
            - Lo siguiente corresponde a si es unidades, decenas o centenas.
            Ejemplo:
                quadU = Quadrillion Units
                trilT = Trillion Tens
                thouH = Thousand Hundreds
         */


        String numero = "";
        int[] digits = convertirArray(n);
        String[] letters = new String[digits.length];

        int variableCualquiera = 0;

        for (int i = 0; i < digits.length; i++) {
            variableCualquiera = digits.length - i;
            if (digits[i] != 0) {
                break;
            }
        }

        /*if (variableCualquiera > 3) {
            if (variableCualquiera > 6) {
                if (variableCualquiera > 9) {
                    if (variableCualquiera > 12) {
                        if (variableCualquiera > 15) {
                            if (variableCualquiera > 18) {
                                // quintillones
                            } else {
                                //quadrillones
                            }
                        } else {
                            // trillones
                        }
                    } else {
                        // billones
                    }
                } else {
                    // millones
                }
            } else {
                //millares
            }
        } else {
            // centenas
        } */

        int a = 0;

        /*if (n < 100) {
            if (n < 20) {
                numero = zeroToNineteen(n);
            }
            if (n % 10 != 0) {
                numero = tenMultiples(n - (n % 10)) + "-" + zeroToNineteen(n % 10);
            } else {
                numero = tenMultiples(n);
            }
        }*/
        return numero.substring(0, 1).toUpperCase() + numero.substring(1);
    }

    public static long words(String s) {
        return 0;
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
        String[] array = new String[20];

        array[0] = "zero";
        array[1] = "one";
        array[2] = "two";
        array[3] = "three";
        array[4] = "four";
        array[5] = "five";
        array[6] = "six";
        array[7] = "seven";
        array[8] = "eight";
        array[9] = "nine";
        array[10] = "ten";
        array[11] = "eleven";
        array[12] = "twelve";
        array[13] = "thirteen";
        array[14] = "fourteen";
        array[15] = "fifteen";
        array[16] = "sixteen";
        array[17] = "seventeen";
        array[18] = "eighteen";
        array[19] = "nineteen";

        return array[n];
    }

    private static String tenMultiples(int n) {
        n = (n - 2) / 10;

        String[] array = new String[8];

        array[0] = "twenty";
        array[1] = "thirty";
        array[2] = "forty";
        array[3] = "fifty";
        array[4] = "sixty";
        array[5] = "seventy";
        array[6] = "eighty";
        array[7] = "ninety";

        return array[n];
    }
}
