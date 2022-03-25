public class Component {
    private String characters;
    private char character;
    private Component subcomponent;
    private Types type;

    enum Types {
        NORMCHAR, QUESTMARK, CHARGROUP, BOL, EOL, CLOUSURE
    }

    public String getCharacters() {
        return characters;
    }

    public Types getType() {
        return type;
    }

    public char getCharacter() {
        return character;
    }

    public Component getSubcomponent() {
        return subcomponent;
    }

    public void setSubcomponent(Component subcomponent) {
        this.subcomponent = subcomponent;
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
           String resultado = "\nComponente formado por: " + character + "\nEl tipo del grupo es: " + type.toString() + "\n";

           if (subcomponent != null) {
               resultado += "---------\nSubc" + this.subcomponent.toString().substring(2);
           }

           return resultado;
        }

        return "\nComponente formado por: [" + characters + "]\nEl tipo del grupo es: " + type.toString() + "\n";
    }
}
