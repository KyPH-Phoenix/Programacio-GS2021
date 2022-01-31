import java.util.Random;

public class Baraja {
    // Cada baralla es internament un array de 48 cartes
    Carta[] cartes = new Carta[48];

    // Constructor
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

    // Funció per imprimir la baralla
    public void imrimeix() {
        for (int i = 0; i < cartes.length; i++) {
            this.cartes[i].imprimeix();
        }
    }

    // Funció per mezclar la baralla
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
