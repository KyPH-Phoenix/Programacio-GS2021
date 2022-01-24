import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Introduce nombre del jugador
        System.out.print("¿Cuál es tu nombre? ");
        String nom = sc.nextLine();

        // Seleccion de raza del jugador
        System.out.println("Elije tu raza:");
        System.out.println("    1. Humano");
        System.out.println("    2. Orco (Defensa+, Ataque-)");
        System.out.println("    3. Elfo (Defensa--, Ataque++)");
        System.out.println("    4. Gigante (Defensa++, Ataque--)");
        int raza = Integer.parseInt(sc.nextLine());
        int razaBot = (int) (Math.random() * 4);

        // Asigna los valores de la raza a los luchadores
        Jugador jugador1 = asignaRaza(raza - 1);
        Jugador jugador2 = asignaRaza(razaBot);

        // Asigna el nombre correcto a los jugadores
        jugador1.nom = nom + " (" + jugador1.nom + ")";
        jugador2.nom = "SkyNet (" + jugador2.nom + ")";

        // Variables de victorias
        int victorias1 = 0;
        int victorias2 = 0;
        int ganador = 0;

        // Combate
        for (int i = 0; i < 10; i++) {
            System.out.printf("\nSiguiente combate: %d\n", i + 1);
            int penaliz1 = 6;
            int penaliz2 = 6;
            ganador = 0;
            for (int j = 0; j < 10; j++) {
                // Array con la palabra para cada estrategia.
                String[] estrategia = {"ataque", "defensa", "engaño", "maniobra"};

                // Muestra las estadisticas de cada jugador al principio del turno
                jugador1.mostraEstadistiques();
                jugador2.mostraEstadistiques();

                // El jugador y la máquina eligen estrategia
                int estr1 = elegirEstr();
                System.out.printf("\n%s ha elejido %s\n", jugador1.nom, estrategia[estr1 - 1]);
                int estr2 = estrRandom();
                System.out.printf("\n%s ha elejido %s\n", jugador2.nom, estrategia[estr2 - 1]);

                // Se tiran las monedas
                jugador1.tirarMonedas(estr1);
                jugador2.tirarMonedas(estr2);

                ronda(jugador1, estr1, jugador2, estr2);

                // Los siguientes condicionales quitan la penalizacion de los jugadores o pasan los turnos.
                if (jugador1.penalizado) {
                    penaliz1--;
                    if (penaliz1 == 0) {
                        penaliz1 = 6;
                        quitarPenalizacion(jugador1);
                    }
                }

                if (jugador2.penalizado) {
                    penaliz2--;
                    if (penaliz2 == 0) {
                        penaliz2 = 6;
                        quitarPenalizacion(jugador2);
                    }
                }

                // Termina el combate si la vida de uno de los dos jugadores llega a 0
                if (jugador1.puntsVida == 0) {
                    ganador = 2;
                    victorias2++;
                    break;
                }

                if (jugador2.puntsVida == 0) {
                    ganador = 1;
                    victorias1++;
                    break;
                }
            }
            // Mensaje de fin de combate y del ganador.
            System.out.printf("\nEl combate %d ha finalizado.\n", i + 1);

            if (ganador == 1) {
                System.out.printf("\nGanador del combate: %s\n", jugador1.nom);
            } else if (ganador == 2) {
                System.out.printf("\nGanador del combate: %s\n", jugador2.nom);
            } else {
                System.out.println("\nHa habido un empate.");
            }

            // Resetea stats
            jugador1 = asignaRaza(raza - 1);
            jugador2 = asignaRaza(razaBot);
            jugador1.nom = nom + " (" + jugador1.nom + ")";
            jugador2.nom = "SkyNet (" + jugador2.nom + ")";
        }

        // Imprime el numero de victorias de cada jugador
        System.out.printf("\n%s ha ganado %d veces\n", jugador1.nom, victorias1);
        System.out.printf("\n%s ha ganado %d veces\n", jugador2.nom, victorias2);
    }

    // Funcion para quitar la penalizacion
    static void quitarPenalizacion(Jugador jugador) {
        if (jugador.tipoPenalizacion == 0) {
            jugador.puntsAtac += jugador.puntosPenalizados;
        } else {
            jugador.puntsDefensa += jugador.puntosPenalizados;
        }

        jugador.penalizado = false;
        jugador.puntosPenalizados = 0;
        System.out.printf("\nLa penalizacion que afectaba a %s ha dejado de hacer efecto\n", jugador.nom);
    }

    // Funcion para asignar la raza al jugador
    static Jugador asignaRaza(int raza) {
        // Aqui crea la raza como objetos en un array
        Jugador[] razas = new Jugador[4];
        crearRazas(razas);

        // Selecciona la raza correspondiente
        return razas[raza];
    }

    // Funcion para asignar los valores al array de razas.
    static void crearRazas(Jugador[] razas) {
        razas[0] = new Jugador("Humano", 5, 5);
        razas[1] = new Jugador("Orco", 4, 6);
        razas[2] = new Jugador("Elfo", 7, 3);
        razas[3] = new Jugador("Gigante", 3, 7);
    }

    // Funcion para elegir la estrategia del jugador
    static int elegirEstr() {
        System.out.println("\nElije tu estrategia:");
        System.out.println("    1. Ataque");
        System.out.println("    2. Defensa");
        System.out.println("    3. Engaño");
        System.out.println("    4. Maniobra");

        return Integer.parseInt(sc.nextLine());
    }

    // Funcion que elige una estrategia aleatoria para la maquina
    static int estrRandom() {
        return ((int) (Math.random() * 4)) + 1;
    }

    // Funcion de cada ronda del combate
    static void ronda(Jugador jugador1, int estr1, Jugador jugador2, int estr2) {
        // Array con las posibles estrategias de los jugadores
        Jugador[] estrategia = new Jugador[4];

        // Primero hace los casos en los que las estrategias son iguales.
        if (estr1 == estr2) {
            estrIguales(jugador1, estr1, jugador2);
        } else {
            // Cuando las estrategias no son iguales asigna un rol (estrategia) a cada jugador dependiendo de su
            // eleccion
            sacarRol(estrategia, estr1, estr2, jugador1, jugador2);

            // A partir de aquí se comprueban las estrategias y se actua segun estas.
            /*
            0. Ataque
            1. Defensa
            2. Engaño
            3. Maniobra
             */
            if (estrategia[0] != null) {
                if (estrategia[1] != null) {
                    estrategia[1].recuperaVida(estrategia[1].exit);
                } else if (estrategia[2] != null) {
                    estrategia[2].restaVida(estrategia[0].exit);
                } else {
                    estrategia[3].restaVida(estrategia[0].exit);
                }
            } else if (estrategia[1] != null) {
                if (estrategia[2] != null) {
                    estrategia[1].restaVida(estrategia[2].exit * 2);
                } else {
                    estrategia[1].penalitzacio(estrategia[3].exit);
                }
            } else {
                estrategia[2].penalitzacio(estrategia[3].exit);
            }

            // Finalmente se comparan los nombres y se asignan los valores resultantes al jugador correspondiente.
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

    // Funcion que recoge los casos en los que las estrategias son iguales.
    static void estrIguales(Jugador jugador1, int estr1, Jugador jugador2) {
        if (estr1 == 1 || estr1 == 3) {
            jugador1.restaVida(jugador2.exit);
            jugador2.restaVida(jugador1.exit);
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

    // Funcion que define la estrategia del jugador, correspondiente a la funcion de cada turno.
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
