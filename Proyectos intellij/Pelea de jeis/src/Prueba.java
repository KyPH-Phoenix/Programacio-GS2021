public class Prueba {
    public static void main(String[] args) {
        long contadorMenor = 0;
        long totalMenor = 0;
        long totalMayor = 0;
        long contadorMayor = 0;
        long i = 0;
        long j = 0;
        long totalSaltos = 0;

        for (long objetivo = 20; objetivo != j; i++) {
            totalMayor = 0;
            totalMenor = 0;
            for (j = 0; objetivo != totalMayor && objetivo != totalMenor; j++) {
                if (Math.random() < 0.5) {
                    contadorMenor++;
                    contadorMayor = 0;
                } else {
                    contadorMayor++;
                    contadorMenor = 0;
                }

                if (contadorMenor > totalMenor)
                    totalMenor = contadorMenor;

                if (contadorMayor > totalMayor)
                    totalMayor = contadorMayor;
            }
            totalSaltos += j;
        }

        System.out.println("Total intentos: " + i);
        System.out.println("Total saltos: " + totalSaltos);
        System.out.println("--------");
        System.out.println(j);
        System.out.println(totalMayor);
        System.out.println(totalMenor);

        /*
        for (long objetivo = 10; objetivo != totalMayor && objetivo != totalMenor; j++) {
            if (Math.random() < 0.5) {
                contadorMenor++;
                contadorMayor = 0;
            } else {
                contadorMayor++;
                contadorMenor = 0;
            }

            if (contadorMenor > totalMenor)
                totalMenor = contadorMenor;

            if (contadorMayor > totalMayor)
                totalMayor = contadorMayor;
        }*/
    }
}
