public class Exercici5 {
    public static void main(String[] args) {
        int i = 10;
        int[] ar = {2, 5, -1};

        while (true) {
            try {
                int num = ar[i];
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            } finally {
                i--;
            }
        }
    }
}
