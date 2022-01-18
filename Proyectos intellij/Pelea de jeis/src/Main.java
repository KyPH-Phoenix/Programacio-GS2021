public class Main {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Hugo", 5, 8);
        Jugador jugador2 = new Jugador("Pau Puto", 1, 1);

        String estr1 = "ATAC";
        String estr2 = "DEFENSA";

        int exit1 = 5;
        int exit2 = 4;

        jugador1.mostraEstadistiques();
        jugador2.mostraEstadistiques();

        ronda(jugador1, estr1, exit1, jugador2, estr2, exit2);

        jugador1.mostraEstadistiques();
        jugador2.mostraEstadistiques();
    }

    static void ronda(Jugador jugador1, String estr1, int exit1, Jugador jugador2, String estr2, int exit2) {
        if (estr1.equals("ATAC") && estr2.equals("DEFENSA")) {
            jugador2.recuperaVida(exit2);
        }
    }
}
