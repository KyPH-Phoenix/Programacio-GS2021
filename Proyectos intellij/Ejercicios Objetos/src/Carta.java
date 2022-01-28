public class Carta {

    enum Pal { OROS, BASTOS, ESPADAS, COPAS};
    enum Nums { AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, SOTA, CABALLO, REY};

    Pal pal;
    Nums num;

    Carta(Pal pal, Nums num) {
        this.pal = pal;
        this. num = num;
    }

    public void imprimeix(){
        System.out.println(this.num.toString() + " de " + this.pal.toString());
    }
}
