public class Main {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Hugo", 3, 8);
        Jugador jugador2 = new Jugador("Pau Puto", 2, 7);

        /*
        Als seguents camps:
            1 = atac
            2 = defensa
            3 = engany
            4 = maniobra
         */

        int estr1 = 2;
        int estr2 = 4;

        jugador1.exit = 5;
        jugador2.exit = 4;


        jugador1.mostraEstadistiques();
        System.out.println();
        jugador2.mostraEstadistiques();
        System.out.println();

        ronda(jugador1, estr1, jugador2, estr2);

        System.out.println();
        jugador1.mostraEstadistiques();
        System.out.println();
        jugador2.mostraEstadistiques();
    }

    static void ronda(Jugador jugador1, int estr1, Jugador jugador2, int estr2) {

        Jugador[] estrategia = new Jugador[4];

        if (estr1 == estr2) {
            estrIguales(jugador1, estr1, jugador2);
        } else {
            sacarRol(estrategia, estr1, estr2, jugador1, jugador2);

            if (estrategia[0] != null) {
                if (estrategia[1] != null) {
                    estrategia[1].recuperaVida(estrategia[1].exit);
                } else if (estrategia[2] != null) {
                    estrategia[2].restaVida(estrategia[0].puntsAtac);
                } else {
                    estrategia[3].restaVida(estrategia[0].puntsAtac);
                }
            } else if (estrategia[1] != null) {
                if (estrategia[2] != null) {
                    estrategia[1].restaVida(estrategia[2].puntsAtac * 2);
                } else {
                    estrategia[1].penalitzacio(estrategia[3].exit);
                }
            } else {
                estrategia[2].penalitzacio(estrategia[3].exit);
            }

            for (int i = 0; i < estrategia.length; i++) {
                if (estrategia[i] != null && estrategia[i].nom.equals(jugador1.nom)) {
                    jugador1 = estrategia[i];
                }

                if (estrategia[i] != null && estrategia[i].nom.equals(jugador2.nom)) {
                    jugador2 = estrategia[i];
                }
            }
        }
    }

    static void estrIguales(Jugador jugador1, int estr1, Jugador jugador2) {
        if (estr1 == 1 || estr1 == 3) {
            jugador1.restaVida(jugador2.puntsAtac);
            jugador2.restaVida(jugador1.puntsAtac);
        }

        if (estr1 == 2) {
            jugador1.recuperaVida(jugador1.exit);
            jugador2.recuperaVida(jugador2.exit);
        }

        if (estr1 == 4) {
            jugador1.penalitzacio(jugador2.exit);
            jugador2.penalitzacio(jugador1.exit);
        }
    }

    static void sacarRol(Jugador[] estrategia, int estr1, int estr2, Jugador jugador1, Jugador jugador2) {
        for (int i = 0; i < estrategia.length; i++) {
            if (estr1 == i + 1) {
                estrategia[i] = jugador1;
            } else if (estr2 == i + 1) {
                estrategia[i] = jugador2;
            } else {
                estrategia[i] = null;
            }
        }
    }
}
