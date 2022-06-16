
// Consultar taula https://en.wikipedia.org/wiki/Barcode#Linear_barcodes
// Code11: https://en.wikipedia.org/wiki/Code_11

// Generadors de codis:
//     https://barcode.tec-it.com/en/Code11
//     https://www.free-barcode-generator.net/code-11/
//     https://products.aspose.app/barcode/generate


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Code11 {

    // Codifica un String amb Code11
    static String encode(String s) {
        String result = "";

        // Bucle que codifica cada caracter, un per un.
        for (int i = 0; i < s.length(); i++) {
            result += encodeChar(s.charAt(i));

            // Si no es el darrer caracter, afegeix un espai despres de codificar cada un.
            // Si es el darrer no afageix res.
            if (i < s.length() - 1) result += " ";
        }

        return result;
    }

    // Switch amb totes les posibles combinacions de barres i espais que corresponen a cada caracter. La funció retorna
    // la opció que correspon al caracter.
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
        // Conta quina es la barra mes gruixada.
        int maxBars = countMaxBars(s);

        /*  Dins aquest bucle es proven les distintes possibles combinacions de barres petites, començant per la mes
            grossa possible i provant amb una mes petita en cada iteracio. */
        for (int i = maxBars - 1; i > 0; i--) {
            String result = "";

            // Llista que conté els valors en "1" o "0" de cada caracter.
            List<String> charactersList = convertChars2binary(s, i);

            if (charactersList == null) return null;

            // Comprovam que el primer caràcter sigui "*".
            String firstChar = decodeChar(charactersList.get(0));

            if (firstChar == null) continue;
            if (!firstChar.equals("*")) continue;

            boolean notValid = false;

            // Dins aquest bucle es prova a decodificar cada caracter. Si hi ha algun que no es valor que no es valid
            // surt del bucle i torna a fer tot el proces pero amb una "barra petita" encara mes petita.
            for (String numCharacter : charactersList) {
                String decodedChar = decodeChar(numCharacter);
                if (decodedChar == null) {
                    notValid = true;
                    break;
                }
                result += decodedChar;
            }

            // Aquí es valida si s'ha sortit del bulce anterior amb exit o no.
            if (notValid) continue;

            return result;
        }

        return null;
    }

    // Switch que decodifica els valors en "0" i "1" als caracters corresponents.
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

    // Funció que converteix la string de "█"/" " a "0"/"1".
    private static List<String> convertChars2binary(String s, int minBars) {
        List<String> result = new ArrayList<>();
        String characterValue = "";

        // Es conta el valor màxim d'espais.
        int maxSpaces = countMaxSpaces(s);

        int state = 0;
        int nBars = 0;
        int nSpaces = 0;

        // El següent bucle es una maquina d'estats. Ho fet d'aquesta forma perque me pareixia que quedava bastant clar.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Si el caracter no es ni espai ni barra la funcio torna null;
            if (c != ' ' && c != '█') return null;

            // Estat 0, 2 i 4. Vol dir que estam çercant una barra i aturam quan trobam un espai.
            if (state == 0 || state == 2 || state == 4) {
                // Això succeirà si encara no hem començat a contar cap barra.
                if (c == ' ' && nBars == 0) continue;

                if (c == '█') {
                    nBars++;
                    continue;
                }

                // Aquí hem acabat de contar barres.
                if (c == ' ') {
                    // Si la longitud de la barra es menor o igual que la minima afegim 0 al resultat. Si no, afegim 1.
                    characterValue += (nBars <= minBars) ? "0" : "1";
                    nBars = 0;

                    // Si el estat es 4 (el màxim possible) afegim la seqüencia de numeros a una entrada de la llista de
                    // resultats. Si no, sumam 1 a l'estat.
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

            // Estat 1 i 3. Vol dir que estam contat espais i aturam quan trobam una barra.
            if (state == 1 || state == 3) {
                if (c == ' ') {
                    nSpaces++;
                    continue;
                }

                // Aquí hem acabat de contar espais.
                if (c == '█') {
                    // Si la longitud del espai es menor o igual que la minima afegim 0 al resultat. Si no, afegim 1.
                    if (maxSpaces == 2) characterValue += (nSpaces < maxSpaces) ? "0" : "1";
                    else characterValue += (nSpaces < maxSpaces - 1) ? "0" : "1";
                    nSpaces = 0;
                    state++;
                    i--;
                }
            }
        }

        // Com que el bucle atura una posició abans de acabar la string, validam si el darrer caracter es una barra.
        if (s.charAt(s.length() - 1) == '█') {
            characterValue += (nBars <= minBars) ? "0" : "1";
            result.add(characterValue);
            characterValue = "";
        }

        // Si al final troba que "characterValue" no está buid vol dir que s'ha deixat un caracter a mitges i per tant
        // el codi de barres no es valid.
        if (!characterValue.equals("")) return null;

        return result;
    }

    // Funció que reotrna el tamany del espai mes gran.
    private static int countMaxSpaces(String s) {
        int maxSpaces = 0;
        int counter = 0;
        int i = 0;

        // Primer es bota els espais inicials.
        while (s.charAt(i) == ' ') {
            i++;
        }

        // Comença a partir dels espais incials (que no te en compte).
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                counter++;
            } else {
                if (counter > maxSpaces) maxSpaces = counter;
                counter = 0;
            }
        }

        // Afegeix el darrer valor en cas de que s'ho hagi deixat.
        if (s.charAt(s.length() - 1) != ' ') {
            maxSpaces = Math.max(counter, maxSpaces);
        }

        return maxSpaces;
    }

    // Funció que retorna el tamany de la barra més gran. Funciona de manera pareguda a la funció anterior.
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

    // Decodifica una imatge. La imatge ha d'estar en format "ppm".
    public static String decodeImage(String str) {
        // Genera una imatge a partir de la string
        Image image = new Image(str);
        String result = readHorizontal(image);

        // Si després de llegir la imatge el resultat no és null, el retorna.
        if (result != null) {
            image.setValue(result);
            return image.getValue();
        }

        // En cas contrari fa el mateix pero en vertical.
        result = readVertical(image);
        image.setValue(result);

        return image.getValue();
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

    // Genera imatge a partir de codi de barres
    // Alçada: 100px
    // Marges: vertical 4px, horizontal 8px
    // Gruixada: 10px
    // Prima: 3px
    public static String generateImage(String s) {
        String line = "";

        // Aquest bucle converteix la string a "█" o " ".
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            line += generatePixels(c);

            // Afegeix un espai si no es el darrer caràcter.
            if (i < s.length() - 1) line += "   ";
        }

        // Calcul de dimensions de la imatge.
        int width = line.length() + 16;
        int height = 108;

        // Capçalera de la imatge.
        String result = "P3\n" + width + " " + height + "\n255\n";

        // Afegeix un marge vertical adalt.
        result += Utils.addVerticalMargin(width, 4);

        // Defineix la linia com: marge + linia + marge.
        String codedLine = Utils.addHorizontalMargin(8)
                + Utils.codeLine(line) + Utils.addHorizontalMargin(8);

        // S'afegeix 100 vegades la linia al resultat.
        for (int i = 0; i < 100; i++) {
            result += codedLine;
        }

        // S'afegeix el marge vertical inferior i es lleva el "/n" final.
        result += Utils.addVerticalMargin(width, 4);
        result = result.substring(0, result.length() - 1);

        return result;
    }

    // Switch amb els valors de cada caràcter.
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
