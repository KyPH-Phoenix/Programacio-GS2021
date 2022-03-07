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

    void playGame(Word word) {
        Alphabet alphabet = new Alphabet();
        while (!gallows.isHung() && !word.isGuessed()) {
            // Show game status
            showGameStatus(word, alphabet);

            char character = getInput();

            // If character is not valid (because repeated)
            if (alphabet.isUsed(character)) {
                System.out.println("Subnormal, menos 69420 puntos por gilipollas");
                continue;
            }

            // If character is valid
            alphabet.doGuess(character);
            if (!word.doGuess(character)) {
                this.gallows.addPart();
                System.out.println("This letter se va a la m");
            }
        }

        if (word.isGuessed()) {
            System.out.println("FELICIDADES, eres gilipollas pero no tantnto");
        } else {
            System.out.println("FELICIDADES, eres gilipollas");
        }
    }

    private void showGameStatus(Word word, Alphabet alphabet) {
        System.out.println();
        this.gallows.display();
        this.wordDisplay.display(word);
        this.alphabetDisplay.display(alphabet);
    }

    private char getInput() {
        while (true) {
            System.out.print("Introduce un caracter: ");
            String line = scanner.nextLine();
            if (line.length() == 1) {
                char c = line.toLowerCase().charAt(0);
                if ((c >= 'a' && c <= 'z') || c == 'ñ') return c;
            }
            System.out.println("El caràcter (o la cosa) que has introduit no és vàlida");
        }
    }
}
