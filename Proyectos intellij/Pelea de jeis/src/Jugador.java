public class Jugador {
    String nom;
    int nivell;
    int puntsExp;
    int puntsVida;
    int puntsVidaMax;
    int puntsAtac;
    int puntsDefensa;
    int exit;
    boolean penalizado;
    int tipoPenalizacion;
    int puntosPenalizados;


    // Constructor
    public Jugador(String nom, int puntsAtac, int puntsDefensa) {
        this.nom = nom;
        this.nivell = 0;
        this.puntsExp = 0;
        this.puntsVida = 20;
        this.puntsVidaMax = 20;
        this.puntsAtac = puntsAtac;
        this.puntsDefensa = puntsDefensa;
        this.exit = 0;
        this.penalizado = false;
        this.tipoPenalizacion = -1;
    }

    // Funcion para recuperar vida del jugador
    void recuperaVida(int punts) {
        this.puntsVida += punts;
        if (this.puntsVida > this.puntsVidaMax)
            this.puntsVida = this.puntsVidaMax;

        System.out.printf("\n%s recupera %d puntos de vida.\n", this.nom, punts);
    }

    // Funcion para restar vida al jugador
    void restaVida(int punts) {
        this.puntsVida -= punts;º
        if (this.puntsVida < 0)
            this.puntsVida = 0;
        System.out.printf("\n%s pierde %d puntos de vida.\n", this.nom, punts);
    }

    // Funcion para mostrar estadisticas del jugador
    void mostraEstadistiques() {
        System.out.printf("\nNom: %s\nPunts Vida:%d\nPunts Atac: %d\nPunts Defensa: %d\n", this.nom, this.puntsVida, this.puntsAtac, this.puntsDefensa);
    }

    // Funcion para penalizar al jugador, si se puede.
    void penalitzacio(int punts) {
        // Si el valor de exito (monedas tiradas) es 0 no hara nada. (La penalizacion falla)
        if (punts == 0) {
            System.out.printf("La penalización hacia %s ha fallado", this.nom);
        } else if (!this.penalizado) {
            // En caso de que no sea 0 y el jugador no este previamente penalizado entonces si se penaliza.
            this.puntosPenalizados = punts;
            if (Math.random() < 0.5) {
                this.puntsAtac -= punts;
                if (this.puntsAtac <= 0)
                    this.puntsAtac = 1;
                this.tipoPenalizacion = 0;
                System.out.printf("\n%s sufre un penalizacion al ataque de %d puntos.\n", this.nom, punts);
            } else {
                this.puntsDefensa -= punts;
                if (this.puntsDefensa <= 0)
                    this.puntsDefensa = 1;
                this.tipoPenalizacion = 1;
                System.out.printf("\n%s sufre un penalizacion a la defensa de %d puntos.\n", this.nom, punts);
            }

            // Esta variable determina si el jugador esta o no penalizado.
            this.penalizado = true;
        } else {
            // Si el jugador ya esta penalizado no ocurre nada.
            System.out.printf("\n%s no puede ser penalizado porque ya está penalizado.\n", this.nom);
        }
    }

    // Funcion para tirar monedas.
    void tirarMonedas(int estr) {
        if (estr == 2) {
            this.exit = ((int) (Math.random() * (this.puntsDefensa + 1)));
        } else {
            this.exit = ((int) (Math.random() * (this.puntsAtac + 1)));
        }
    }
}
