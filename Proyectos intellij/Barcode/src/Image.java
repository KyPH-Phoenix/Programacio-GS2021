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

    // Funció que converteix la string del constructor a un array bidimensional.
    private String[][] convertToBidimensionalArray(String str) {
        // Lleva els \r que nomes surten a Windows. Despres fa un split de cada linia de la imatge.
        str = str.replace("\r", "");
        String[] rawNumbers = str.split("\n");

        // Extra line es perque a algunes imatges i ha un comentari a la 3ra linia però a altres no. Si el comentari
        // hi es extra line es queda a 0, si no es queda a 1.
        int extraLine = (str.charAt(3) == '#') ? 0 : 1;

        // Extreu el tamany de la imatge
        String sizes = rawNumbers[2 - extraLine];
        this.width = Integer.parseInt(sizes.split(" ")[0]);
        this.height = Integer.parseInt(sizes.split(" ")[1]);

        // Crea l'array bidimensional amb una altre funció.
        String[][] result = createArray(extraLine, rawNumbers);

        return result;
    }

    // Aquesta funció genera un array bidimensional dels pixels.
    private String[][] createArray(int extraLine, String[] rawNumbers) {
        String[][] result = new String[this.height][this.width];

        for (int i = 0, pos = 6 - extraLine; i < this.height; i++) {
            for (int j = 0; j < this.width; j++, pos += 3) {
                // Agafa els valors de les corresponents posicions.
                float red = Integer.parseInt(rawNumbers[pos]);
                float green = Integer.parseInt(rawNumbers[pos - 1]);
                float blue = Integer.parseInt(rawNumbers[pos - 2]);

                // Aquesta es la formula de NTSC per convertir de color a grayscale.
                int grayscale = (int) (0.2989 * red + 0.5870 * green + 0.1140 * blue);

                result[i][j] = (grayscale > 150) ? " " : "█";
            }
        }

        return result;
    }

    /*
        Les següents funcions funcionen igual i retornen una String de pixels "█" o " ".

        Consisteixen en un bucle que va posició per posició agafant cada valor de l'array segons correspongui.
    */
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

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                string.append(this.imageArray[i][j]);
            }
            if (i < this.height - 1) string.append("\n");
        }

        return string.toString();
    }
}
