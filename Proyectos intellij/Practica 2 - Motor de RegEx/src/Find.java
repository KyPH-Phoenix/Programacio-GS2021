import java.util.List;

public class Find {
    private String text;

    public Find(String s) {
        this.text = s;
    }

    public boolean match(String stringPat) {
        if (stringPat.equals("")) return false;

        Pattern pattern = new Pattern(stringPat);

        return textMatch(pattern, 0, 0);
    }

    private boolean textMatch(Pattern pattern, int textPos, int patternPos) {

        int patternSize = pattern.getComponents().size();

        for (; textPos < this.text.length(); textPos++, patternPos++) {

            Component component = pattern.getComponents().get(patternPos);

            Component.Types type = component.getType();

            if (type.equals(Component.Types.BOL)) {
                if (textPos != 0) return false;
                textPos--;
                continue;
            }

            if (characterMatch(component, type, textPos, patternPos)) {
                if (patternPos == patternSize - 1) return true;
                continue;
            }

            // Si no fa match, torna enrere el texte en 1 posició per evitar botar caracters
            if (textPos != 0 && patternPos != 0) textPos--;

            // Reset de la posicio del pattern
            patternPos = -1;
        }

        Component.Types type = pattern.getComponents().get(patternPos).getType();

        if (type.equals(Component.Types.EOL)) {
            if (textPos != text.length()) return false;
            return true;
        }

        return false;
    }

    private boolean characterMatch(Component component, Component.Types type, int textPos, int patternPos) {

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

            if (patternChar == '+') {
                if (!characterMatch(subComponent, subComponent.getType(), textPos, patternPos)) {
                    return false;
                }
            }


        }

        return false;
    }

    public Object capture(String s) {
        return null;
    }
}
