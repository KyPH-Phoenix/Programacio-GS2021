public class Peix {
    String nom;

    int count = 1;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    Peix(String nom) {
        setNom(nom);
    }

    Peix(Peix p) {
        this.count = p.count + 1;
        this.nom = p.getNom();
    }

    public boolean iguals(Peix p) {
        return this.equals(p);
    }
}
