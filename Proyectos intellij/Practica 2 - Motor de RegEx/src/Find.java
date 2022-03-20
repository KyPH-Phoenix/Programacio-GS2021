import java.util.List;

public class Find {
    private String text;

    public Find(String s) {
        this.text = s;
    }

    public boolean match(String stringPat) {
        if (stringPat.equals("")) return false;

        Pattern pattern = new Pattern(stringPat);

        int textPos = 0;
        int patternPos = 0;

        int patternSize = pattern.getComponents().size();

        if (patternSize - 2 > text.length()) return false;

        for (; textPos < this.text.length(); textPos++, patternPos++) {
            char patternChar = pattern.getComponents().get(patternPos).getCharacter();
            char textChar = this.text.charAt(textPos);

            Component.Types type = pattern.getComponents().get(patternPos).getType();

            if (type.equals(Component.Types.NORMCHAR)) {
                if (patternChar == textChar) {
                    if (patternPos == patternSize - 1) return true;
                    continue;
                }
                if (textPos != 0 && patternPos != 0) textPos--;
            }

            if (type.equals(Component.Types.QUESTMARK)) {
                if (patternPos == patternSize - 1) return true;
                continue;
            }

            if (type.equals(Component.Types.BOL)) {
                if (textPos != 0) return false;
                textPos--;
                continue;
            }

            if (type.equals(Component.Types.EOL)) {
                if (textPos != text.length() || patternPos < patternSize) return false;
                return true;
            }

            patternPos = -1;
        }

        Component.Types type = pattern.getComponents().get(patternSize - 1).getType();

        if (type.equals(Component.Types.EOL)) {
            if (textPos != text.length()) return false;
            return true;
        }

        return false;
    }

    public Object capture(String s) {
        return null;
    }
}
