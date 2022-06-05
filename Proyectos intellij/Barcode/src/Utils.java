/* ***************************************************************************************************
 *  Aquesta classe està pensada per asistir a la generació d'imatges tant de code 11 com de code 93. *
 * ************************************************************************************************* */

public class Utils {
    // Funció que codifica una lina de "█" o " " a 255 o 0.
    public static String codeLine(String line) {
        String result = "";

        for (char c : line.toCharArray()) {
            // Si el caracter es un espai replena amb 255 i si no amb 0.
            result += (c == ' ') ? "255\n255\n255\n" : "0\n0\n0\n";
        }

        return result;
    }

    // Funció que afegeix un marge vertical.
    public static String addVerticalMargin(int width, int height) {
        String result = "";

        // La gruixa i la alçada del marge depen dels parametres que li passem.
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result += "255\n255\n255\n";
            }
        }

        return result;
    }

    // Funció que afegeix un marge vertical.
    public static String addHorizontalMargin(int marginWidth) {
        String result = "";

        // La gruixa del marge depen del valor que li passem.
        for (int i = 0; i < marginWidth; i++) {
            result += "255\n255\n255\n";
        }

        return result;
    }
}
