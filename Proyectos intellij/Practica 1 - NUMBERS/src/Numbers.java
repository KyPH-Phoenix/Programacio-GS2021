import java.util.Locale;

public class Numbers {
    public static String say(long n) {
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

        String[] array = {"zero","one","two","three","four","five","six", "seven","eight","nine","ten","eleven",
                "twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};

        return array[n];
    }

    private static String tenMultiples(int n) {
        n = (n / 10) - 2;

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
