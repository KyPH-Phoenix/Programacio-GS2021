public class Main {
    public static void main(String[] args) {
//        Image11 i = new Image11(UtilTests.getImageAsString("code11_446688120.ppm"));
//        System.out.println(i);
//
//        Code11.decode("█ ██  █ █ █ ██ █ ██  █");
//
//        Code11.decode("█ ███  ██ █ █ █ █ ███ █ ███   █");
//
//        Code11.decodeImage(UtilTests.getImageAsString("code11_446688120.ppm"));
//
////        System.out.println(Code11.decodeImage(UtilTests.getImageAsString("code11_0123452.ppm")));
////          Code11.decodeImage(UtilTests.getImageAsString("code11_0123-4567.ppm"));
//
//        System.out.println("*0123452*");
//
        String s = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
        int[] ar = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42};

        int n1 = 13289;
        int n2 = 0;

        System.out.println(s.length() == ar.length);
        System.out.println(n1);

        for (int i = ar.length - 1, j = 1; i >= 0; i--, j++) {
            n2 += ar[i] * j;
            if (j == 20) j = 0;
        }

        System.out.println(n2 % 47);

    }
}
