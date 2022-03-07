public class Alphabet {
    private String usedChars = "";

    public String getUsedChars() {
        return usedChars;
    }

    public boolean isUsed(char c) {
        return this.usedChars.contains("" + c);
    }

    public void doGuess(char c) {
        usedChars += c;
    }
}


interface AlphabetDisplay {
    void display(Alphabet a);
}

class TextAlphabetDisplay implements AlphabetDisplay {
    public void display(Alphabet a) {
        System.out.printf("Palabras usadas: %s\n", a.getUsedChars());
    }
}