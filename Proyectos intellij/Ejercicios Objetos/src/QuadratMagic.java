public class QuadratMagic {
    void imprimeix(int n) {
        int[][] ar = new int[n][n];
        int longitud = ar.length;

        for (int i = 0; i < longitud; i++) {
            creaFila(i, ar, longitud);
            System.out.println();
        }
    }

    static void creaFila(int i, int[][] ar, int longitud) {
        for (int j = 0; j < longitud; j++) {
            if (i > 0 && j > 0) {
                ar[i][j] = ar[i][j - 1] + ar[i - 1][j];
            } else {
                ar[i][j] = 1;
            }

            System.out.print(ar[i][j] + " ");
        }
    }
}
