public class Image11 {
    private int height;
    private int width;
    private String[][] imageArray;
    private String value;

    public Image11(String str) {
        this.imageArray = convertToBidimensionalArray(str);
        this.value = decodeImage();
    }

    private String decodeImage() {

        return null;
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
