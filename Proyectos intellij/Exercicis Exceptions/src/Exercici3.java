public class Exercici3 {
    public static void main(String[] args) {
        try {
            int[] ar = {1, 2};
            int num = ar[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
