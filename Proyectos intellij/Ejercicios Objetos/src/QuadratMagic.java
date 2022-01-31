public class QuadratMagic {
    void imprimeix(int n) {
        int[][] ar = new int[n][n];
        int longitud = ar.length;

        for (int i = 0; i < longitud; i++) {
            creaFila(i, ar, longitud);
        }

        imprimeixQuadrat(ar);
    }

    static void creaFila(int i, int[][] ar, int longitud) {
        for (int j = 0; j < longitud; j++) {
            if (i > 0 && j > 0) {
                ar[i][j] = ar[i][j - 1] + ar[i - 1][j];
            } else {
                ar[i][j] = 1;
            }
        }
    }

    void imprimeixQuadrat(int[][] ar) {
        int digits = digitsMaxims(ar[ar.length - 1][ar.length - 1]);

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                System.out.printf("% " + (digits + 1) + "d", ar[i][j]);
            }
            System.out.println();
        }
    }

    private int digitsMaxims(int n) {
        return ("" + n).length();
    }
}
