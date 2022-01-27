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

    // Getters y setters que se necesitan en el main
    public String getNom() {
        return nom;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }
    public int getPuntsVida() {
        return puntsVida;
    }

    public int getExit() {
        return exit;
    }

    public boolean isPenalizado() {
        return penalizado;
    }

    public int getPuntsExp() {
        return puntsExp;
    }

    public void setPuntsExp(int puntsExp) {
        this.puntsExp = puntsExp;
    }

    // Constructor
    public Jugador(String nom, int puntsAtac, int puntsDefensa) {
        this.nom = nom;
        this.nivell = 0;
        this.puntsExp = 0;
        this.puntsVida = 10;
        this.puntsVidaMax = 10;
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
        this.puntsVida -= punts;
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
                if (this.puntsAtac <= 0) {
                    // Los puntos penalizados no seran todos los que se resten al prinipio si estos son menor o
                    // igual que 0;
                    this.puntosPenalizados = this.puntosPenalizados - 1 - Math.abs(this.puntsAtac);
                    this.puntsAtac = 1;
                }
                this.tipoPenalizacion = 0;
                System.out.printf("\n%s sufre un penalizacion al ataque de %d puntos.\n", this.nom, this.puntosPenalizados);
            } else {
                this.puntsDefensa -= punts;
                if (this.puntsDefensa <= 0) {
                    // Los puntos penalizados no seran todos los que se resten al prinipio si estos son menor o
                    // igual que 0;
                    this.puntosPenalizados = this.puntosPenalizados - 1 - Math.abs(this.puntsDefensa);
                    this.puntsDefensa = 1;
                }
                this.tipoPenalizacion = 1;
                System.out.printf("\n%s sufre un penalizacion a la defensa de %d puntos.\n", this.nom, this.puntosPenalizados);
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

    // Funcion para quitar la penalizacion
    void quitarPenalizacion() {
        if (this.tipoPenalizacion == 0) {
            this.puntsAtac += this.puntosPenalizados;
        } else {
            this.puntsDefensa += this.puntosPenalizados;
        }

        this.penalizado = false;
        this.puntosPenalizados = 0;
        System.out.printf("\nLa penalizacion que afectaba a %s ha dejado de hacer efecto\n", this.nom);
    }

    // Funcion para asignar el nombre.
    void asignaNom(String nom) {
        this.nom = nom + " (" + this.nom + ")";
    }

    // Funcion para aumentar experiencia
    void aumentaExp() {
        this.puntsExp += 25;
        if (this.puntsExp >= 100) {
            System.out.printf("\n¡%s ha subido de nivel!\n\n", this.nom);
            mostraEstadistiques();
            this.nivell++;
            this.puntsExp = this.puntsExp - 100;
            this.ajustarStats();
        }
    }

    // Funcion para subir stats de acuerdo al nivel
    void ajustarStats() {
        this.puntsVida += this.nivell * 2;
        this.puntsVidaMax += this.nivell * 2;
        this.puntsAtac += this.nivell;
        this.puntsDefensa += this.nivell;
    }
}
