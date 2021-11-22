import java.util.Locale;

public class Numbers {
    public static String say(long n) {
        String numero = "";
        int[] array = new int[4];

        for (int i = 4; i > 0; i = i--) {
            double magnitud = Math.pow(10, i);
            if ((long) (n / magnitud) != 0) {
                array[array.length - i] = (int) (n / magnitud);
                n = (long) (n % magnitud);
            } else {
                array[array.length - i] = 0;
            }
        }

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

    private static String zeroToNineteen (long n){
        String numero = "";
        switch ((int) n) {
            case 0:
                numero = "zero";
                break;
            case 1:
                numero = "one";
                break;
            case 2:
                numero = "two";
                break;
            case 3:
                numero = "three";
                break;
            case 4:
                numero = "four";
                break;
            case 5:
                numero = "five";
                break;
            case 6:
                numero = "six";
                break;
            case 7:
                numero = "seven";
                break;
            case 8:
                numero = "eight";
                break;
            case 9:
                numero = "nine";
                break;
            case 10:
                numero = "ten";
                break;
            case 11:
                numero = "eleven";
                break;
            case 12:
                numero = "twelve";
                break;
            case 13:
                numero = "thirteen";
                break;
            case 14:
                numero = "fourteen";
                break;
            case 15:
                numero = "fifteen";
                break;
            case 16:
                numero = "sixteen";
                break;
            case 17:
                numero = "seventeen";
                break;
            case 18:
                numero = "eighteen";
                break;
            case 19:
                numero = "nineteen";
        }
        return numero;
    }

    private static String tenMultiples (long n) {
        String numero = "";
        switch ((int) n) {
            case 20:
                numero = "twenty";
                break;
            case 30:
                numero = "thirty";
                break;
            case 40:
                numero = "forty";
                break;
            case 50:
                numero = "fifty";
                break;
            case 60:
                numero = "sixty";
                break;
            case 70:
                numero = "seventy";
                break;
            case 80:
                numero = "eighty";
                break;
            case 90:
                numero = "ninety";
                break;
        }
        return numero;
    }
}
