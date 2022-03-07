import java.util.Scanner;

/**
 * Created by pnegre on 04/04/16.
 */
public class HangMan {
    private WordFactory wordFactory;

    HangMan(WordFactory wf) {
        this.wordFactory = wf;
    }

    public void play() {
        AlphabetDisplay alphabetDisplay = new TextAlphabetDisplay();
        WordDisplay wordDisplay = new TextWordDisplay();
        Gallows gallows = new TextGallows();

        GameController gameController = new GameController(alphabetDisplay, wordDisplay, gallows);

        gameController.playGame(this.wordFactory.makeWord());
    }

    public static void main(String[] args) {
        WordFactory wordFactory = new DictWordFactory();
        HangMan hm = new HangMan(wordFactory);
        hm.play();
    }
}






