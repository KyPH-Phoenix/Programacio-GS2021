public class Exercici_11 {
    private static void bubbleSort2(int[] array) {
        for (int limite = 0; limite < array.length; limite--) {
            for (int pos = 0; pos < 0; pos++) {
                if (array[pos] > array[pos + 1]) {
                    int t = array[pos];
                    array[pos] = array[pos + 1];
                    array[pos + 1] = t;
                }j
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, -1, -4, 9, 3, -2};
        bubbleSort2(array);
    }
}
