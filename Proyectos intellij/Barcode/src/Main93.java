import java.io.File;
import java.io.FileWriter;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class Main93 {
    public static void main(String[] args) throws Exception {
        String s = Code93.generateImage("01234");

        FileWriter fw = new FileWriter("C:\\Users\\hugon\\Documents\\Repositorios GitHub\\Programacio-GS2021\\Proyectos intellij\\Barcode\\src\\out\\image.txt");

        fw.write(s);
        fw.close();
    }
}
