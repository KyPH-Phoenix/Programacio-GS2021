
import static org.junit.Assert.*;

public class Main {
    public static void main(String[] args) {
        Image i1 = new Image(UtilTests.getImageAsString("code11_0123452.ppm"));


        System.out.println(i1);
//        System.out.println(Code11.decodeImage(UtilTests.getImageAsString("code11_0123452.ppm")));
//        Code11.decodeImage(UtilTests.getImageAsString("code11_0123-4567.ppm"));

        System.out.println("*0123452*");
    }
}
