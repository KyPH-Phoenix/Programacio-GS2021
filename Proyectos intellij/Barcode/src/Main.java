
import static org.junit.Assert.*;

public class Main {
    public static void main(String[] args) {
        Code11.decode("█ ██  █ █ █ ██ █ ██  █");

        Code11.decode("█ ███  ██ █ █ █ █ ███ █ ███   █");

        System.out.println(Code11.decodeImage(UtilTests.getImageAsString("code11_0123452.ppm")));
//        Code11.decodeImage(UtilTests.getImageAsString("code11_0123-4567.ppm"));

        System.out.println("0123452");
    }
}
