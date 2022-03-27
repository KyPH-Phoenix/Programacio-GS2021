public class Find {
    private String text;
    private Pattern pattern;
    private int textPos = 0;

    public Find(String s) {
        this.text = s;
    }

    public boolean match(String stringPat) {
        if (stringPat.equals("")) return false;

        this.pattern = new Pattern(stringPat);

        return textMatch(0, 0);
    }

    private boolean textMatch(int textPos, int patternPos) {
        this.textPos = textPos;

        int patternSize = this.pattern.getComponents().size();

        for (; this.textPos < this.text.length(); this.textPos++, patternPos++) {

            Component component = this.pattern.getComponents().get(patternPos);

            Component.Types type = component.getType();

            if (type.equals(Component.Types.BOL)) {
                if (this.textPos != 0) return false;
                this.textPos--;
                continue;
            }

            if (characterMatch(component, this.textPos, patternPos)) {
                if (patternPos == patternSize - 1) return true;
                continue;
            }

            // Si no fa match, torna enrere el texte en 1 posició per evitar botar caracters
            if (this.textPos != 0 && patternPos != 0) this.textPos--;

            // Reset de la posicio del pattern
            patternPos = -1;
        }

        Component.Types type = this.pattern.getComponents().get(patternPos).getType();

        if (type.equals(Component.Types.EOL)) {
            if (this.textPos != text.length()) return false;
            return true;
        }

        return false;
    }

    private boolean characterMatch(Component component, int textPos, int patternPos) {

        Component.Types type = component.getType();

        // Per evitar que surti del string als clousures, si li passam una possició massa grosa retorna false.
        if (textPos >= this.text.length()) return false;

        char textChar = this.text.charAt(textPos);
        char patternChar = '0';
        String patternGroup = "";

        if (type.equals(Component.Types.CHARGROUP)) {
            patternGroup = component.getCharacters();
        } else {
            patternChar = component.getCharacter();
        }

        if (type.equals(Component.Types.NORMCHAR)) {
            if (patternChar == textChar) {
                return true;
            }
            return false;
        }

        if (type.equals(Component.Types.QUESTMARK)) {
            return true;
        }

        if (type.equals(Component.Types.CHARGROUP)) {
            if (patternGroup.contains("" + textChar)) {
                return true;
            }
        }

        if (type.equals(Component.Types.CLOUSURE)) {
            Component subComponent = component.getSubcomponent();

            return (clousureMatch(patternChar, subComponent, patternPos, textPos));
        }

        return false;
    }

    private boolean clousureMatch(char patternChar, Component subComponent, int patternPos, int textPos) {
        if (patternChar == '+') {
            if (!characterMatch(subComponent, textPos, patternPos)) {
                return false;
            }
        }

        int clousurePosition = textPos;

        while (characterMatch(subComponent, clousurePosition, patternPos)) clousurePosition++;

        while (clousurePosition >= textPos + 1) {
            if (clousurePosition == this.text.length()) {
                this.textPos = clousurePosition - 1;
                return true;
            }
            if (textMatch(clousurePosition, patternPos + 1)) {
                this.textPos = clousurePosition - 1;
                return true;
            }
            clousurePosition--;
        }

        this.textPos--;
        return true;
    }

    public Object capture(String s) {
        return null;
    }
}
