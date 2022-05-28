// https://en.wikipedia.org/wiki/Code_93

public class Code93 {

    // Codifica emprant Code93
    static String encode(String str) {
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

        return getCharOf(total % 47);
    }

    private static int getValueOf(char c) {
        // € = ($)
        // > = (%)
        // Ç = (/)
        // < = (+)
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%€>Ç<*";

        for (int i = 0; i < characters.length(); i++) {
            if (c == characters.charAt(i)) return i;
        }

        return -1;
    }

    private static char getCharOf(int n) {
        // € = ($)
        // > = (%)
        // Ç = (/)
        // < = (+)
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%€>Ç<*";

        return characters.charAt(n);
    }

    private static String encodeChar(char c) {
        String[] encodedChars = {"131112", "111213", "111312", "111411", "121113", "121212", "121311", "111114",
                "131211", "141111", "211113", "211212", "211311", "221112", "221211", "231111", "112113", "112212",
                "112311", "122112", "132111", "111123", "111222", "111321", "121122", "131121", "212112", "212211",
                "211122", "211221", "221121", "222111", "112122", "112221", "122121", "123111", "121131", "311112",
                "311211", "321111", "112131", "113121", "211131", "121221", "312111", "311121", "122211", "111141"};

        return encodedChars[getValueOf(c)];
    }

    // Decodifica emprant Code93
    static String decode(String str) {
        return "";
    }

    // Decodifica una imatge. La imatge ha d'estar en format "ppm"
    public static String decodeImage(String str) {
        return "";
    }

    // Genera imatge a partir de barcode code93
    // Unitat barra mínima: 3 pixels
    // Alçada: 100px
    // Marges: vertical: 5px, horizontal: 15px
    public static String generateImage(String s) {
        return "";
    }
}
