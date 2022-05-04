
// Consultar taula https://en.wikipedia.org/wiki/Barcode#Linear_barcodes
// Code11: https://en.wikipedia.org/wiki/Code_11

// Generadors de codis:
//     https://barcode.tec-it.com/en/Code11
//     https://www.free-barcode-generator.net/code-11/
//     https://products.aspose.app/barcode/generate


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Code11 {

    // Codifica un String amb Code11
    static String encode(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            result += encodeChar(s.charAt(i));
            if (i < s.length() - 1 ) result += " ";
        }

        return result;
    }

    private static String encodeChar(char c) {
        switch (c) {
            case '*': return "█ ██  █";
            case '0': return "█ █ ██";
            case '1': return "██ █ ██";
            case '2': return "█  █ ██";
            case '3': return "██  █ █";
            case '4': return "█ ██ ██";
            case '5': return "██ ██ █";
            case '6': return "█  ██ █";
            case '7': return "█ █  ██";
            case '8': return "██ █  █";
            case '9': return "██ █ █";
            case '-': return "█ ██ █";
            default: return "";
        }
    }

    // Decodifica amb Code11
    static String decode(String s) {
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (state == 0) {

            }
        }
        return "";
    }

    // Decodifica una imatge. La imatge ha d'estar en format "ppm"
    public static String decodeImage(String str) {
        return "";
    }

    // Genera imatge a partir de codi de barres
    // Alçada: 100px
    // Marges: vertical 4px, horizontal 8px
    public static String generateImage(String s) {
        return "";
    }
}
