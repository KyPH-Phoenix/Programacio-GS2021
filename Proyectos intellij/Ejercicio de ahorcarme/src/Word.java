

public class Word {
    private String theString;

    Word(String s) {
        this.theString = s;
    }

    public String toString() {
        return this.theString;
    }

    boolean isGuessed() {
        return false;
    }

    boolean doGuess(char c) {
        return false;
    }
}


