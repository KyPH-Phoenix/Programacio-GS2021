public class Image {
    private int height;
    private int width;
    private String[][] imageArray;
    private String value;

    public Image(String str) {
        this.imageArray = convertToBidimensionalArray(str);
    }

    public String[][] getImageArray() {
        return imageArray;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }


    private String[][] convertToBidimensionalArray(String str) {
        str = str.replace("\r", "");
        String[] rawNumbers = str.split("\n");

        int extraLine = (rawNumbers.length % 2 != 0) ? 1 : 0;

        String pixels = rawNumbers[2 - extraLine];

        this.width = Integer.parseInt(pixels.split(" ")[0]);
        this.height = Integer.parseInt(pixels.split(" ")[1]);

        String[][] result = createArray(extraLine, rawNumbers);

        return result;
    }

    private String[][] createArray(int extraLine, String[] rawNumbers) {
        String[][] result = new String[this.height][this.width];

        for (int i = 0, pos = 6 - extraLine; i < this.height; i++) {
            for (int j = 0; j < this.width; j++, pos += 3) {
                float red = Integer.parseInt(rawNumbers[pos]);
                float green = Integer.parseInt(rawNumbers[pos - 1]);
                float blue = Integer.parseInt(rawNumbers[pos - 2]);

                int grayscale = (int) (0.2989 * red + 0.5870 * green + 0.1140 * blue);

                result[i][j] = (grayscale > 150) ? " " : "█";
            }
        }

        return result;
    }

    public String getRow(int row) {
        String result = "";

        for (int i = 0; i < imageArray[row].length; i++) {
            result += imageArray[row][i];
        }

        return result;
    }

    public String getReverseRow(int row) {
        String result = "";

        for (int i = imageArray[row].length - 1; i >= 0; i--) {
            result += imageArray[row][i];
        }

        return result;
    }

    public String getColumn(int column) {
        String result = "";

        for (int i = 0; i < imageArray.length; i++) {
            result += imageArray[i][column];
        }

        return result;
    }

    public String getReverseColumn(int column) {
        String result = "";

        for (int i = imageArray.length - 1; i >= 0; i--) {
            result += imageArray[i][column];
        }

        return result;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append(this.value + "\n\n");

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                string.append(this.imageArray[i][j]);
            }
            if (i < this.height - 1) string.append("\n");
        }

        return string.toString();
    }
}
