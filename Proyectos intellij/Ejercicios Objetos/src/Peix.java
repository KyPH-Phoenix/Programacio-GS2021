public class Peix {
    String nom;
    static int count;

    // Getter del nom
    public String getNom() {
        return nom;
    }

    // Setter del nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Constructor base
    Peix(String nom) {
        count++;
        setNom(nom);
    }

    // Constructor copia
    Peix(Peix p) {
        count++;
        this.nom = p.getNom();
    }

    // Funcio per comparar noms
    public boolean equals(Peix p) {
        return this.nom.equals(p.nom);
    }
}
