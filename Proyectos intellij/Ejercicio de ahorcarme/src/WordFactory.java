import java.util.Scanner;

public interface WordFactory {
    Word makeWord();
}

class DefaultWordFactory implements WordFactory {
    public Word makeWord() {
        return new Word("ordinador");
    }
}


class DictWordFactory implements WordFactory {
    private String[] words = {
            "aprobar",
            "manolo",
            "juanma",
            "wsrtyuytrcewazethujkouytredguiuyteqa",
            "uvuvwevwevwe",
            "onyetenyevwe",
            "ugwemuhwem",
            "osas"
    };

    @Override
    public Word makeWord() {
        return new Word(this.words[(int) (Math.random() * words.length)]);
    }
}