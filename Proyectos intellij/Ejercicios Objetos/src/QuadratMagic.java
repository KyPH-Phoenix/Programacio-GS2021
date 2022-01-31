public class QuadratMagic {
    int dimensio;

    // Constructor
    QuadratMagic(int n) {
        this.dimensio = n;
    }

    // Funcio per imprimir el quadrat
    void imprimeix() {
        int n = this.dimensio;
        int[][] ar = new int[n][n];

        for (int i = 0; i < n; i++) {
            // Aqui he emprat aquesta funció per evitar un for dins un altre for
            creaFila(i, ar, n);
        }

        imprimeixQuadrat(ar);
    }

    // Funcio que crea cada fila del quadrat
    private void creaFila(int i, int[][] ar, int n) {
        for (int j = 0; j < n; j++) {
            if (i > 0 && j > 0) {
                ar[i][j] = ar[i][j - 1] + ar[i - 1][j];
            } else {
                ar[i][j] = 1;
            }
        }
    }

    // Funció interna per imprimir el quadrat. No es la mateixa que "imprimeix"
    private void imprimeixQuadrat(int[][] ar) {
        int digits = digitsMaxims(ar[ar.length - 1][ar.length - 1]);

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                System.out.printf("% " + (digits + 1) + "d", ar[i][j]);
            }
            System.out.println();
        }
    }

    // Funcio per treure els digits del numero mes gran
    private int digitsMaxims(int n) {
        return ("" + n).length();
    }
}
