public class Component {
    private char[] characters;
    private char character;
    enum Types {
        NORMCHAR, QUESTMARK, CHARGROUP, BOL, EOL, CLOUSURE
    }

    private Types type;

    public Types getType() {
        return type;
    }

    public char getCharacter() {
        return character;
    }

    public Component(char c, Types t) {
        this.character = c;
        this.type = t;
    }

    @Override
    public String toString() {
        if (type != Types.CHARGROUP) {
           return "\nGrupo formado por: " + character + "\nEl tipo del grupo es: " + type.toString() + "\n";
        }

        return "";
    }
}
