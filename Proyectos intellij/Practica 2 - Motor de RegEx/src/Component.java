public class Component {
    private char[] characters;
    private char character;
    private enum Types {
        NORMCHAR, QUESTMARK, CHARGROUP, BOL, EOL, CLOUSURE
    }

    private Types types;

    public Component(char c, Types t) {
        this.character = c;
        this.types = t;
    }

}
