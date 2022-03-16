import java.util.List;

public class Find {
    private String text;

    public Find(String s) {
        this.text = s;
    }

    public boolean match(String stringPat) {
        if (stringPat.equals("")) return false;

        int substringLastPosition = this.text.length() - stringPat.length() + 1;
        for (int i = 0; i < substringLastPosition; i++) {
            if (this.text.substring(i, i + stringPat.length()).equals(stringPat)) {
                return true;
            }
        }
        return false;
    }

    public Object capture(String s) {
        return null;
    }
}
