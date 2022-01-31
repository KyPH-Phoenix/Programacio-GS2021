public class Carta {
    // Cream un enum per els possibles valors de pals i un altre per als de numero de cada carta.
    enum Pal {OROS, BASTOS, ESPADAS, COPAS}

    ;

    enum Nums {AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, SOTA, CABALLO, REY}

    ;

    // Cada objecte tindra el seu valor
    Pal pal;
    Nums num;

    // Constructor
    Carta(Pal pal, Nums num) {
        this.pal = pal;
        this.num = num;
    }

    // Funció per imprimir el valor de la carta
    public void imprimeix() {
        System.out.println(this.num.toString() + " de " + this.pal.toString());
    }
}
