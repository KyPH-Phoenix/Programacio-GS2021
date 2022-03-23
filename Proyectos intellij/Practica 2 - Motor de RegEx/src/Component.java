public class Component {
    private String characters;
    private char character;
    enum Types {
        NORMCHAR, QUESTMARK, CHARGROUP, BOL, EOL, CLOUSURE
    }
    private Component subcomponent;

    private Types type;

    public String getCharacters() {
        return characters;
    }

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

    public Component(String s, Types t) {
        this.characters = s;
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
