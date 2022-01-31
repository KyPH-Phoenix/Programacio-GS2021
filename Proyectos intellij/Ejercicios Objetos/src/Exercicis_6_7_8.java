public class Exercicis_6_7_8 {
    public static void main(String[] args) {
        Carta as_oros = new Carta(Carta.Pal.OROS, Carta.Nums.AS);
        as_oros.imprimeix();

        Baraja baraja = new Baraja();
        baraja.mezcla();
        baraja.imrimeix();
    }
}
