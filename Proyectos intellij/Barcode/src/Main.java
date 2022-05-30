import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        // Horizontal
        Image i = new Image(UtilTests.getImageAsString("code11_446688120.ppm"));

        String s = readHorizontal(i.getImageArray());
        System.out.println(s);

        // Reverse Horizontal
        i = new Image(UtilTests.getImageAsString("code11_789-12-98_.ppm"));
        s = readHorizontal(i.getImageArray());

        String expected = "*789-12-98*";
        System.out.println("Expected: " + expected + " Actual: " + s);

        // Vertical
        i = new Image(UtilTests.getImageAsString("code11_95612-7.ppm"));
        s = readVertical(i.getImageArray());

        expected = "*95612-7*";
        System.out.println("Expected: " + expected + " Actual: " + s);

        // Reverse Vertical
        i = new Image(UtilTests.getImageAsString("code11_2226-78-984376.ppm"));
        s = readVertical(i.getImageArray());

        expected = "*2226-78-984376*";
        System.out.println("Expected: " + expected + " Actual: " + s);
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

        for (int i = 0; i < imageArray.length / 2 + 1; i++) {
            String symbolStr = ReverseRowToString(imageArray, i);

            if (Code11.decode(symbolStr) == null) {
                symbolStr = ReverseRowToString(imageArray, imageArray.length - i - 1);
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

    private static String ReverseRowToString(String[][] imageArray, int row) {
        String result = "";

        for (int i = imageArray[row].length - 1; i >= 0; i--) {
            result += imageArray[row][i];
        }

        return result;
    }

    private static String readVertical(String[][] imageArray) {
        for (int i = 0; i < imageArray[0].length; i++) {
            String symbolStr = columnToString(imageArray, i);

            if (Code11.decode(symbolStr) == null) {
                symbolStr = columnToString(imageArray, imageArray[i].length - i - 1);
                if (Code11.decode(symbolStr) != null) return Code11.decode(symbolStr);
                continue;
            }

            return Code11.decode(symbolStr);
        }

        for (int i = 0; i < imageArray[0].length; i++) {
            String symbolStr = ReverseColumnToString(imageArray, i);

            if (Code11.decode(symbolStr) == null) {
                symbolStr = ReverseColumnToString(imageArray, imageArray[i].length - i - 1);
                if (Code11.decode(symbolStr) != null) return Code11.decode(symbolStr);
                continue;
            }

            return Code11.decode(symbolStr);
        }

        return null;
    }

    private static String columnToString(String[][] imageArray, int column) {
        String result = "";

        for (int i = 0; i < imageArray.length; i++) {
            result += imageArray[i][column];
        }

        return result;
    }

    private static String ReverseColumnToString(String[][] imageArray, int column) {
        String result = "";

        for (int i = imageArray.length - 1; i >= 0; i--) {
            result += imageArray[i][column];
        }

        return result;
    }
}
