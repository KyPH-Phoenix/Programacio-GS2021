
// Consultar taula https://en.wikipedia.org/wiki/Barcode#Linear_barcodes
// Code11: https://en.wikipedia.org/wiki/Code_11

// Generadors de codis:
//     https://barcode.tec-it.com/en/Code11
//     https://www.free-barcode-generator.net/code-11/
//     https://products.aspose.app/barcode/generate


import java.util.ArrayList;
import java.util.Arrays;
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
        return switch (c) {
            case '*' -> "█ ██  █";
            case '0' -> "█ █ ██";
            case '1' -> "██ █ ██";
            case '2' -> "█  █ ██";
            case '3' -> "██  █ █";
            case '4' -> "█ ██ ██";
            case '5' -> "██ ██ █";
            case '6' -> "█  ██ █";
            case '7' -> "█ █  ██";
            case '8' -> "██ █  █";
            case '9' -> "██ █ █";
            case '-' -> "█ ██ █";
            default -> "";
        };
    }

    // Decodifica amb Code11
    static String decode(String s) {
        int maxBars = countMaxBars(s);

        for (int i = maxBars - 1; i > 0; i--) {
            String result = "";
            List<String> charactersList = convertChars2binary(s, i);

            if (charactersList == null) return null;

            String firstChar = decodeChar(charactersList.get(0));

            if (firstChar == null) continue;
            if (!firstChar.equals("*")) continue;

            boolean notValid = false;

            for (String numCharacter : charactersList) {
                String decodedChar = decodeChar(numCharacter);
                if (decodedChar == null) {
                    notValid = true;
                    break;
                }
                result += decodedChar;
            }

            if (notValid) continue;

            return result;
        }

        return null;
    }

    private static String decodeChar(String s) {
        return switch (s) {
            case "00001" -> "0";
            case "10001" -> "1";
            case "01001" -> "2";
            case "11000" -> "3";
            case "00101" -> "4";
            case "10100" -> "5";
            case "01100" -> "6";
            case "00011" -> "7";
            case "10010" -> "8";
            case "10000" -> "9";
            case "00100" -> "-";
            case "00110" -> "*";
            default -> null;
        };
    }

    private static List<String> convertChars2binary(String s, int minBars) {
        List<String> result = new ArrayList<>();
        String characterValue = "";

        int maxSpaces = countMaxSpaces(s);

        int state = 0;
        int nBars = 0;
        int nSpaces = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ' && c != '█') return null;
            if (state == 0 || state == 2 || state == 4) {
                if (c == ' ' && nBars == 0) continue;

                if (c == '█') {
                    nBars++;
                    continue;
                }

                if (c == ' ') {
                    characterValue += (nBars <= minBars) ? "0" : "1";
                    nBars = 0;
                    if (state != 4) {
                        state++;
                    } else {
                        result.add(characterValue);
                        state = 0;
                        characterValue = "";
                        continue;
                    }
                }
            }

            if (state == 1 || state == 3) {
                if (c == ' ') {
                    nSpaces++;
                    continue;
                }

                if (c == '█') {
                    if (maxSpaces == 2) characterValue += (nSpaces < maxSpaces) ? "0" : "1";
                    else characterValue += (nSpaces < maxSpaces - 1) ? "0" : "1";
                    nSpaces = 0;
                    state++;
                    i--;
                }
            }
        }

        if (s.charAt(s.length() - 1) != ' ') {
            characterValue += (nBars <= minBars) ? "0" : "1";
            result.add(characterValue);
            characterValue = "";
        }

        if (!characterValue.equals("")) return null;

        return result;
    }

    private static int countMaxSpaces(String s) {
        int maxSpaces = 0;
        int counter = 0;
        int i = 0;

        while (s.charAt(i) == ' ') {
            i++;
        }

        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                counter++;
            } else {
                if (counter > maxSpaces) maxSpaces = counter;
                counter = 0;
            }
        }

        if (s.charAt(s.length() - 1) != ' ') {
            maxSpaces = Math.max(counter, maxSpaces);
        }

        return maxSpaces;
    }

    private static int countMaxBars(String s) {
        int maxBars = 0;
        int counter = 0;

        for (char c : s.toCharArray()) {
            if (c == '█') {
                counter++;
            } else {
                if (counter > maxBars) maxBars = counter;
                counter = 0;
            }
        }

        if (counter > maxBars) maxBars = counter;

        return maxBars;
    }

    // Decodifica una imatge. La imatge ha d'estar en format "ppm"
    public static String decodeImage(String str) {
        Image image = new Image(str);

        String result = readHorizontal(image.getImageArray());
        if (result != null) return result;

        String invertedStr = invert(str);
        int[][] values = convertToBidimensionalArray(invertedStr);

        result = decodeStringToResult(values, str);

        return result;
    }

    private static String readHorizontal(String[][] imageArray) {
        for (int i = 0; i < imageArray.length / 2 + 1; i++) {
            String symbolStr = rowToString(imageArray, i);

            if (Code11.decode(symbolStr) == null) {
                symbolStr = rowToString(imageArray, imageArray.length - i - 1);
                if (Code11.decode(symbolStr) != null) return Code11.decode(symbolStr);
                continue;
            }

            return Code11.decode(symbolStr);
        }

        return null;
    }

    private static String rowToString(String[][] imageArray, int row) {
        String result = "";

        for (int i = 0; i < imageArray[row].length; i++) {
            result += imageArray[row][i];
        }

        return result;
    }

    private static String decodeStringToResult(int[][] values, String str) {
        for (int i = 0; i < values.length / 2 + 1; i++) {
            String symbolStr = codeToPalitos(str, values, i);

            if (decode(symbolStr) == null) {
                symbolStr = codeToPalitos(str, values, values.length - i - 1);
                if (decode(symbolStr) != null) return decode(symbolStr);
                continue;
            }

            return decode(symbolStr);
        }

        return null;
    }

    private static String invert(String str) {
        str = str.replace("\r", "");

        String[] aux = str.split("\n");
        int extraLine = (aux.length % 2 != 0) ? 1 : 0;

        String result = "";

        for (int i = 0; i < 4 - extraLine; i++) {
            result += aux[i] + "\n";
        }

        for (int i = aux.length - 1; i > 3 - extraLine; i--) {
            result += aux[i];
            result += (i == 4 - extraLine) ? "" : "\n";
        }

        return result;
    }

    private static String codeToPalitos(String str, int[][] values, int line) {
        String result = "";

        for (int i = 0; i < values[line].length; i++) {
            int value = values[line][i];
            if (value < 150) {
                result += "█";
            } else {
                result += " ";
            }
        }

        return result;
    }

    private static int[][] convertToBidimensionalArray(String str) {
        str = str.replace("\r", "");

        String[] rawNumbers = str.split("\n");

        int extraLine = (rawNumbers.length % 2 != 0) ? 1 : 0;

        String pixels = rawNumbers[2 - extraLine];

        int pixWide = Integer.parseInt(pixels.split(" ")[0]);
        int pixTall = Integer.parseInt(pixels.split(" ")[1]);

        System.out.println(pixWide * pixTall);

        int[][] result = new int[pixTall][pixWide];

        for (int i = 0, pos = 6 - extraLine; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++, pos += 3) {
                float red = Integer.parseInt(rawNumbers[pos]);
                float green = Integer.parseInt(rawNumbers[pos - 1]);
                float blue = Integer.parseInt(rawNumbers[pos - 2]);

                result[i][j] = (int) (0.2989 * red + 0.5870 * green + 0.1140 * blue);
            }
        }

        return result;
    }

    // Genera imatge a partir de codi de barres
    // Alçada: 100px
    // Marges: vertical 4px, horizontal 8px
    // Gruixada: 10px
    // Prima: 3px
    public static String generateImage(String s) {
        String line = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            line += generatePixels(c);

            if (i < s.length() - 1) line += "   ";
        }

        int width = line.length() + 16;
        int heigth = 108;

        String result = "P3\n" + width + " " + heigth + "\n255\n";

        result += addVerticalMargin(width);

        String codedLine = codedLine(line);

        for (int i = 0; i < 100; i++) {
            result += addHorizontalMargin();
            result += codedLine;
            result += addHorizontalMargin();
        }

        result += addVerticalMargin(width);
        result = result.substring(0, result.length() - 1);

        return result;
    }

    private static String codedLine(String line) {
        String result = "";

        for (char c : line.toCharArray()) {
            result += (c == ' ') ? "255\n255\n255\n" : "0\n0\n0\n";
        }

        return result;
    }

    private static String addHorizontalMargin() {
        String result = "";

        for (int i = 0; i < 8; i++) {
            result += "255\n255\n255\n";
        }

        return result;
    }

    private static String addVerticalMargin(int width) {
        String result = "";

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < width; j++) {
                result += "255\n255\n255\n";
            }
        }

        return result;
    }

    public static String generatePixels(char c) {
        return switch (c) {
            case '*' -> "███   ██████████          ███";
            case '0' -> "███   ███   ██████████";
            case '1' -> "██████████   ███   ██████████";
            case '2' -> "███          ███   ██████████";
            case '3' -> "██████████          ███   ███";
            case '4' -> "███   ██████████   ██████████";
            case '5' -> "██████████   ██████████   ███";
            case '6' -> "███          ██████████   ███";
            case '7' -> "███   ███          ██████████";
            case '8' -> "██████████   ███          ███";
            case '9' -> "██████████   ███   ███";
            case '-' -> "███   ██████████   ███";
            default -> "";
        };
    }
}
