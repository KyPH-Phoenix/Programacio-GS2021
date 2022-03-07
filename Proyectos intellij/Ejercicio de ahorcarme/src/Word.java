

public class Word {
    private String theString;
    private String goodChars = "";

    Word(String s) {
        this.theString = s;
    }

    public String toString() {
        StringBuilder resultat = new StringBuilder();
        for (int i = 0; i < this.theString.length(); i++) {
            char c = this.theString.charAt(i);

            resultat.append((goodChars.contains("" + c) ? c : "-"));
        }
        return resultat.toString();
    }

    boolean isGuessed() {
        for (char c : this.theString.toCharArray()) {
            if (!this.goodChars.contains("" + c)) return false;
        }

        return true;
    }

    boolean doGuess(char c) {
        if (theString.contains("" + c)) {
            goodChars += c;
            return true;
        }
        return false;
    }
}


