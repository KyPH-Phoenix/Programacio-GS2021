public class Jugador {
    String nom;
    int nivell;
    int puntsExp;
    int puntsVida;
    int puntsVidaMax;
    int puntsAtac;
    int puntsDefensa;
    int exit;

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
    }

    void recuperaVida(int punts) {
        this.puntsVida += punts;
        if (this.puntsVida > this.puntsVidaMax)
            this.puntsVida = this.puntsVidaMax;
    }

    void restaVida(int punts) {
        this.puntsVida -= punts;º
        if (this.puntsVida < 0)
            this.puntsVida = 0;
    }

    void mostraEstadistiques() {
        System.out.printf("Nom: %s\nPunts Vida:%d\nPunts Atac: %d\nPunts Defensa: %d\n", this.nom, this.puntsVida, this.puntsAtac, this.puntsDefensa);
    }

    void penalitzacio(int punts) {
        if (Math.random() < 0.5) {
            this.puntsAtac -= punts;
            if (this.puntsAtac <= 0)
                this.puntsAtac = 1;
        } else {
            this.puntsDefensa -= punts;
            if (this.puntsDefensa <= 0)
                this.puntsDefensa = 1;
        }
    }
}
