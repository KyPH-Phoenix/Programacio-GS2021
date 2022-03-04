import java.util.Scanner;

public interface WordFactory {
    Word makeWord();
}

class DefaultWordFactory implements WordFactory {
    public Word makeWord() {
        return new Word("Ordinador");
    }
}


class DictWordFactory implements WordFactory {
    @Override
    public Word makeWord() {
        return null;
    }
}