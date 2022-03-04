import java.util.Scanner;

public class GameController {
    private AlphabetDisplay alphabetDisplay;
    private WordDisplay wordDisplay;
    private Gallows gallows;

    private Scanner scanner = new Scanner(System.in);

    GameController(AlphabetDisplay ad, WordDisplay wd, Gallows g) {
        this.alphabetDisplay = ad;
        this.wordDisplay = wd;
        this.gallows = g;
    }

    void playGame(Word w) {
        Alphabet alphabet = new Alphabet();
        while (!gallows.isHung() && !w.isGuessed()) {
            // Show game status
            this.gallows.display();
            this.wordDisplay.display(w);
            this.alphabetDisplay.display(alphabet);

            char input = getInput();
        }
    }

    private char getInput() {
        String line = scanner.nextLine();
        while (true) {
            if (line.length() == 1) {
                char character = line.toLowerCase().charAt(0);
                if (character >= 'a' && character <= 'z') return character;
            } else {
                System.out.println("El caràcter (o la cosa) que has introduit no és vàlida");
            }
        }
    }
}
