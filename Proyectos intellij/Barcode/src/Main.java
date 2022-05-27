public class Main {
    public static void main(String[] args) {
        Image11 i = new Image11(UtilTests.getImageAsString("code11_446688120.ppm"));
        System.out.println(i);

        Code11.decode("█ ██  █ █ █ ██ █ ██  █");

        Code11.decode("█ ███  ██ █ █ █ █ ███ █ ███   █");

        Code11.decodeImage(UtilTests.getImageAsString("code11_446688120.ppm"));

//        System.out.println(Code11.decodeImage(UtilTests.getImageAsString("code11_0123452.ppm")));
//          Code11.decodeImage(UtilTests.getImageAsString("code11_0123-4567.ppm"));

        System.out.println("*0123452*");
    }
}
