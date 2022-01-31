public class Peix {
    String nom;
    static int count;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    Peix(String nom) {
        count++;
        setNom(nom);
    }

    Peix(Peix p) {
        count++;
        this.nom = p.getNom();
    }

    public boolean equals(Peix p) {
        return this.nom.equals(p.nom);
    }
}
