// https://en.wikipedia.org/wiki/Code_93

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Code93 {

    // Codifica emprant Code93
    static String encode(String str) {
        // Primer processa els caracters especials i les minúscules.
        str = processSpecialChars(str);

        // Despres calcula els checksums.
        char chk1 = getChecksum(str, 20);
        char chk2 = getChecksum(str + chk1, 15);

        str = "*" + str + chk1 + chk2 + "*";
        String result = "";

        // Aquest bucle codifica caràcter per caracter la string sencera, dexiant defora el primer i el darrer.
        // El format de la codificació és "111411" (*).
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result += encodeChar(c);
        }

        // Converteix els numeros a "█" o " " segons correspongui.
        return convertToPalitos(result);
    }

    private static String processSpecialChars(String str) {
        String lowerABC = "abcdefghijklmnopqrstuvwxyz";

        // Processa caracter per caracter
        for (char c : str.toCharArray()) {
            // Comprova les minuscules primer
            if (lowerABC.contains("" + c)) {
                str = str.replace("" + c, "<" + (char) (c - 32));
            }

            // Desperes comprova el * i la ,
            if (c == ',') str = str.replace("" + c, "@L");

            if (c == '*') str = str.replace("" + c, "@J");
        }

        return str;
    }

    // Funció per convertir de números a píxels.
    private static String convertToPalitos(String s) {
        String result = "";
        int i = 0;

        // Bucle que va caracter per caracter convertint-lo a pixels
        while (i < s.length()) {
            int n = Integer.parseInt("" + s.charAt(i));

            // Bucle que converteix els "█"
            for (int j = 0; j < n; j++) {
                result += "█";
            }
            i++;

            n = Integer.parseInt("" + s.charAt(i));

            // Bucle que converteix els " "
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

            // Si el valor de j es igual a 20 o a 15 (depenent del checksum) el resetea.
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

    // Aquest array es estatic perque s'empra en més d'una funcio.
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

        // Converteix els caracters a numeros
        List<String> values = symbolsToNumbers(str);
        String result = "";

        // Comprova que no sigui null
        if (values == null || values.size() == 0) return null;

        // Comprova que la string comença i acaba per *
        char begin = getCharOfString(values.get(0));
        char end = getCharOfString(values.get(values.size() - 1));
        if (begin != '*' || end != '*') return null;

        // Bucle que converteix els valors a caracters
        for (int i = 1; i < values.size() - 3; i++) {
            char c = getCharOfString(values.get(i));

            //  Si el valor no es valid es representa amb una "ñ" i torna null.
            if (c == 'ñ') return null;
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

        return 'ñ';
    }

    private static List<String> symbolsToNumbers(String str) {
        List<String> result = new ArrayList<>();

        // Calcula la barra més petita per tenir una referència.
        int smallestSize = countSmallerBar(str);
        int state = 1;

        // Esborra els espais incial i final, si n'hi ha.
        str = removeBeginAndEndSpaces(str);

        if (str == null) return null;

        String value = "";

        for (int i = 0, count = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // Estat 1, 3 i 5. Vol dir que estam çercant una barra i aturam quan trobam un espai.
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

            // Estat 2 i 4. Vol dir que estam contat espais i aturam quan trobam una barra.
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

        // Si l'estat no es 1 quan acaba vol dir que no hi havia "█" final o que el darrer caràcter estava incomplet.
        if (state != 1) return null;

        return result;
    }

    private static String removeBeginAndEndSpaces(String str) {
        int count1 = 0;
        int count2 = 0;
        char c;

        // Conta quants espais hi ha abans de la cadena de simbols
        do {
            // Si la string es buida torna null
            if (count1 == str.length()) return null;
            c = str.charAt(count1);
            if (c == ' ') count1++;
        } while (c == ' ');

        // Conta quants espais hi ha després de la cadena de simbols
        do {
            c = str.charAt(str.length() - count2 - 1);
            if (c == ' ') count2++;
        } while (c == ' ');

        // El resultat es un substring que lleva els espais del davant i del darrera
        str = str.substring(count1, str.length() - count2);

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
        // Genera una imatge a partir de la string
        Image image = new Image(str);
        String result;

        // Si després de llegir la imatge el resultat no és null, el retorna.
        result = readHorizontal(image);
        if (result != null) return result;

        // En cas contrari fa el mateix pero en vertical.
        result = readVertical(image);

        return result;
    }

    // Funció que llegeix en horitzontal
    private static String readHorizontal(Image image) {
        String[][] imageArray = image.getImageArray();

        // Bucle que va llegint per parells les linies (la 1ª i la darrera, la 2ª i la penultima, etc.).
        for (int i = 0; i < imageArray.length / 2 + 1; i++) {
            String symbolStr = image.getRow(i);

            // Si la linia "i" no te sentit llegeix la "darrera - i" .
            if (decode(symbolStr) == null) {
                symbolStr = image.getRow(imageArray.length - i - 1);
                if (decode(symbolStr) != null) return decode(symbolStr);

                // Si la darrera - i no te sentit llegeix la "i" a l'inreves.
                symbolStr = image.getReverseRow(i);

                // Si no te sentit llegeix la "darrera - i" a l'inreves.
                if (decode(symbolStr) == null) {
                    symbolStr = image.getReverseRow(imageArray.length - i - 1);
                    if (decode(symbolStr) != null) return decode(symbolStr);
                    continue;
                }
            }
            return decode(symbolStr);
        }

        // Si al final del bucle cap te sentit retorna null.
        return null;
    }

    // Funció que llegeix en vertical
    private static String readVertical(Image image) {
        String[][] imageArray = image.getImageArray();

        // Bucle que va llegint per parells les columnes (la 1ª i la darrera, la 2ª i la penultima, etc.).
        for (int i = 0; i < imageArray[0].length; i++) {
            String symbolStr = image.getColumn(i);

            // Si la columna "i" no te sentit llegeix la "darrera - i".
            if (decode(symbolStr) == null) {
                symbolStr = image.getColumn(imageArray[i].length - i - 1);
                if (decode(symbolStr) != null) return decode(symbolStr);

                // Si la darrera - i no te sentit llegeix la "i" a l'inreves.
                symbolStr = image.getReverseColumn(i);

                if (decode(symbolStr) == null) {
                    symbolStr = image.getReverseColumn(imageArray[i].length - i - 1);
                    if (decode(symbolStr) != null) return decode(symbolStr);
                    continue;
                }
            }
            return decode(symbolStr);
        }

        // Si al final del bucle cap te sentit retorna null.
        return null;
    }

    // Genera imatge a partir de barcode code93
    // Unitat barra mínima: 3 pixels
    // Alçada: 180px
    // Marges: vertical: 5px, horizontal: 15px
    public static String generateImage(String s) {
        // Processa els caràcters especials, empra la funció encode i triplica la gruixada de les barres i espais.
        String line = encode(processSpecialChars(s));
        line = line.replace("█", "███");
        line = line.replace(" ", "   ");

        // Calcul de dimensions de la imatge.
        int width = line.length() + 30;
        int height = 190;

        // Capçalera de la imatge.
        String result = "P3\n" + width + " " + height + "\n255\n";
        result += Utils.addVerticalMargin(width, 5);

        // Defineix la linia com: marge + linia + marge.
        String codedLine = Utils.addHorizontalMargin(15) +
                Utils.codeLine(line) + Utils.addHorizontalMargin(15);

        // S'afegeix 180 vegades la linia al resultat.
        for (int i = 0; i < 180; i++) {
            result += codedLine;
        }

        // S'afegeix el marge vertical inferior i es lleva el "/n" final.
        result += Utils.addVerticalMargin(width, 5);
        result = result.substring(0, result.length() - 1);

        return result;
    }

    static void cacaCaca(String result, String line, int i, int[] ints) {

    }
}
