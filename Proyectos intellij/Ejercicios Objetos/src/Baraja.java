import java.util.Random;

public class Baraja {
    Carta[] cartes = new Carta[48];

    Baraja() {
        Carta.Pal[] pals = Carta.Pal.values();
        Carta.Nums[] nums = Carta.Nums.values();

        int pos = 0;

        for (int i = 0; i < pals.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                this.cartes[pos] = new Carta(pals[i], nums[j]);
                pos++;
            }
        }
    }

    public void imrimeix() {
        for (int i = 0; i < cartes.length; i++) {
            this.cartes[i].imprimeix();
        }
    }

    void mezcla() {
        Carta[] ar = this.cartes;
        Random random = new Random();
        for (int i = 0; i < ar.length; i++) {
            int aleatori = random.nextInt(ar.length - i) + i;
            Carta temp = ar[i];
            ar[i] = ar[aleatori];
            ar[aleatori] = temp;
        }
    }
}
