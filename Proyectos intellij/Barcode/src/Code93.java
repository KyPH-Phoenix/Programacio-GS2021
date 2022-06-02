// https://en.wikipedia.org/wiki/Code_93

import java.util.ArrayList;
import java.util.List;

public class Code93 {

    // Codifica emprant Code93
    static String encode(String str) {
        str = processSpecialChars(str);

        char chk1 = getChecksum(str, 20);
        char chk2 = getChecksum(str + chk1, 15);

        str = "*" + str + chk1 + chk2 + "*";
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result += encodeChar(c);
        }

        return convertToPalitos(result);
    }

    private static String processSpecialChars(String str) {
        String lowerABC = "abcdefghijklmnopqrstuvwxyz";

        for (char c : str.toCharArray()) {
            if (lowerABC.contains("" + c)) {
                str = str.replace("" + c, "<" + (char) (c - 32));
            }

            if (c == ',') str = str.replace("" + c, "@L");

            if (c == '*') str = str.replace("" + c, "@J");
        }

        return str;
    }

    private static String convertToPalitos(String s) {
        String result = "";
        int i = 0;
        while (i < s.length()) {
            int n = Integer.parseInt("" + s.charAt(i));

            for (int j = 0; j < n; j++) {
                result += "█";
            }
            i++;

            n = Integer.parseInt("" + s.charAt(i));

            for (int j = 0; j < n; j++) {
                result += " ";
            }
            i++;
        }

        result += "█";

        return result;
    }

    private static char getChecksum(String str, int resetNumber) {
        int total = 0;

        for (int i = str.length() - 1, j = 1; i >= 0; i--, j++) {
            char c = str.charAt(i);
            int value = getValueOf(c) * j;
            total += value;

            if (j == resetNumber) j = 0;
        }

        return getCharFromValue(total % 47);
    }

    private static int getValueOf(char c) {
        // € = ($)
        // > = (%)
        // @ = (/)
        // < = (+)
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%€>@<*";

        for (int i = 0; i < characters.length(); i++) {
            if (c == characters.charAt(i)) return i;
        }

        return -1;
    }

    private static char getCharFromValue(int n) {
        // € = ($)
        // > = (%)
        // Ç = (/)
        // < = (+)
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%€>Ç<*";

        return characters.charAt(n);
    }

    // Este array es estatico porque se usa en mas de una funcion.
    final static String[] encodedChars = {"131112", "111213", "111312", "111411", "121113", "121212", "121311", "111114",
            "131211", "141111", "211113", "211212", "211311", "221112", "221211", "231111", "112113", "112212",
            "112311", "122112", "132111", "111123", "111222", "111321", "121122", "131121", "212112", "212211",
            "211122", "211221", "221121", "222111", "112122", "112221", "122121", "123111", "121131", "311112",
            "311211", "321111", "112131", "113121", "211131", "121221", "312111", "311121", "122211", "111141"};


    private static String encodeChar(char c) {
        return encodedChars[getValueOf(c)];
    }

    // Decodifica emprant Code93
    static String decode(String str) {
        if (str.charAt(str.length() - 1) != '█') return null;

        List<String> values = symbolsToNumbers(str);
        String result = "";

        for (int i = 1; i < values.size() - 3; i++) {
            result += getCharOfString(values.get(i));
        }

        if (!checkChecksums(result, values)) return null;

        result = revertSpecialChars(result);

        return result;
    }

    private static String revertSpecialChars(String result) {
        result = result.replace("@L", ",");
        result = result.replace("@J", "*");

        String upperABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (char c : upperABC.toCharArray()) {
            result = result.replace("<" + c, "" + (char) (c + 32));
        }

        return result;
    }

    private static boolean checkChecksums(String result, List<String> values) {
        char chk1 = getCharOfString(values.get(values.size() - 3));
        char chk2 = getCharOfString(values.get(values.size() - 2));

        if (chk1 != getChecksum(result, 20)) return false;
        return chk2 == getChecksum(result + chk1, 15);
    }

    private static char getCharOfString(String value) {
        for (int i = 0; i < encodedChars.length; i++) {
            if (value.equals(encodedChars[i])) return getCharFromValue(i);
        }

        return '@';
    }

    private static List<String> symbolsToNumbers(String str) {
        List<String> result = new ArrayList<>();
        int smallestSize = countSmallerBar(str);
        int state = 1;

//        str = removeBeginAndEndSpaces(str);

        String value = "";

        for (int i = 0, count = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (state % 2 == 1) {
                if (c == '█') {
                    count++;
                } else {
                    value += count / smallestSize;

                    // Reset variables
                    state++;
                    count = 0;
                }
            }

            if (state % 2 == 0) {
                if (c == ' ') {
                    count++;
                } else {
                    value += count / smallestSize;

                    // Reset Variables
                    //// Si el estado = 6 guarda el valor y resetea el estado y la variable "value";
                    if (state == 6) {
                        result.add(value);
                        value = "";

                        state = 1;
                        //// Si no simplemente suma 1 al estado
                    } else {
                        state++;
                    }
                    count = 0;
                    i--;
                }
            }
        }

//        if (state != 1) return null;

        return result;
    }

    private static String removeBeginAndEndSpaces(String str) {
        int count1 = 0;
        int count2 = 0;
        char c;

        do {
            c = str.charAt(count1);
            if (c == ' ') count1++;
        } while (c == ' ');

        do {
            c = str.charAt(count2);
            if (c == ' ') count2++;
        } while (c == ' ');

        str = str.substring(count1, str.length() - count2 + 1);

        System.out.println(str);

        return str;
    }

    private static int countSmallerBar(String str) {
        int min = 1000;
        int count = 0;
        char lastChar = str.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == lastChar) {
                count++;
            } else {
                if (count < min) min = count;
                lastChar = c;
                count = 0;
                i--;
            }
        }

        return min;
    }

    // Decodifica una imatge. La imatge ha d'estar en format "ppm"
    public static String decodeImage(String str) {
        Image image = new Image(str);
        System.out.println(image);
        String result = "";

        result = readHorizontal(image);

        return result;
    }

    private static String readHorizontal(Image image) {
        String[][] imageArray = image.getImageArray();

        for (int i = 0; i < imageArray.length / 2 + 1; i++) {
            String symbolStr = image.getRow(i);

            if (decode(symbolStr) == null) {
                symbolStr = image.getRow(imageArray.length - i - 1);
                if (decode(symbolStr) != null) return decode(symbolStr);
                continue;
            }

            return decode(symbolStr);
        }

        for (int i = 0; i < imageArray.length / 2 + 1; i++) {
            String symbolStr = image.getReverseRow(i);

            if (decode(symbolStr) == null) {
                symbolStr = image.getReverseRow(imageArray.length - i - 1);
                if (decode(symbolStr) != null) return decode(symbolStr);
                continue;
            }

            return decode(symbolStr);
        }

        return null;
    }

    // Genera imatge a partir de barcode code93
    // Unitat barra mínima: 3 pixels
    // Alçada: 100px
    // Marges: vertical: 5px, horizontal: 15px
    public static String generateImage(String s) {
        return "";
    }
}
