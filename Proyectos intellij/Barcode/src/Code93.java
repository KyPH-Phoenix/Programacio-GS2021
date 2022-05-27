// https://en.wikipedia.org/wiki/Code_93

public class Code93 {

    // Codifica emprant Code93
    static String encode(String str) {
        char chk1 = getChecksum(str);
        char chk2 = getChecksum(str + chk1);

        str = "*" + str + chk1 + chk2 + "*";

        System.out.println(str);

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result += encodeChar(c);
        }
        
        return result;
    }

    private static char getChecksum(String str) {
        int total = 0;

        for (int i = 0, j = str.length(); i < str.length(); i++, j--) {
            char c = str.charAt(i);
            total += getValueOf(c) * j;
        }

        return getCharOf(total);
    }

    private static int getValueOf(char c) {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%*";

        for (int i = 0; i < characters.length(); i++) {
            if (c == characters.charAt(i)) return i;
        }

        return -1;
    }

    private static char getCharOf(int n) {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";

        return characters.charAt(n);
    }

    private static String encodeChar(char c) {
        String[] encodedChars = {"131112", "111213", "111312", "111411", "121113", "121212", "121311", "111114",
                "131211", "141111", "211113", "211212", "211311", "221112", "221211", "231111", "112113", "112212",
                "112311", "122112", "132111", "111123", "111222", "111321", "121122", "131121", "212112", "212211",
                "211221", "221121", "222111", "112122", "112221", "122121", "123111", "121131", "311112", "311211",
                "321111", "112131", "113121", "211131", "121221", "312111", "311121", "122211", "111141",};

        return encodedChars[getValueOf(c)];
    }

    /*
        0	"131112",	100010100
        1	"111213",	101001000
        2	"111312",	101000100
        3	"111411",	101000010
        4	"121113",	100101000
        5	"121212",	100100100
        6	"121311",	100100010
        7	"111114",	101010000
        8	"131211",	100010010
        9	"141111",	100001010
        A	"211113",	110101000
        B	"211212",	110100100
        C	"211311",	110100010
        D	"221112",	110010100
        E	"221211",	110010010
        F	"231111",	110001010
        G	"112113",	101101000
        H	"112212",	101100100
        I	"112311",	101100010
        J	"122112",	100110100
        K	"132111",	100011010
        L	"111123",	101011000
        M	"111222",	101001100
        N	"111321",	101000110
        O	"121122",	100101100
        P	"131121",	100010110
        Q	"212112",	110110100
        R	"212211",	110110010
        T	"211221",	110100110
        U	"221121",	110010110
        V	"222111",	110011010
        W	"112122",	101101100
        X	"112221",	101100110
        Y	"122121",	100110110
        Z	"123111",	100111010
        -	"121131",	100101110
        .	"311112",	111010100
        SPACE	"311211",	111010010
        $	"321111",	111001010
        /	"112131",	101101110
        +	"113121",	101110110
        %	"211131",	110101110
        ($)	"121221",	100100110
        (%)	"312111",	111011010
        (/)	"311121",	111010110
        (+)	"122211",	100110010
        Start/Stop *	"111141",	101011110
        (Reverse stop)	114111	101111010
     */
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
