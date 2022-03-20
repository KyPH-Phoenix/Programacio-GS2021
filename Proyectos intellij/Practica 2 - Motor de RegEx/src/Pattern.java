public class Pattern {
    private Box<Component> components = new Box();

    public Box<Component> getComponents() {
        return components;
    }

    public Pattern(String pat) {
        boolean nextCharNormal = false;
        char character;

        for (int i = 0; i < pat.length(); i++) {
            character = pat.charAt(i);

            if (nextCharNormal) {
                Component component = new Component(character, Component.Types.NORMCHAR);
                this.components.addElement(component);
                nextCharNormal = false;
                continue;
            }

            if (character == '?') {
                Component comp = new Component(character, Component.Types.QUESTMARK);
                this.components.addElement(comp);
                continue;
            }

            if (character == '@') {
                nextCharNormal = true;
                continue;
            }

            /*if (character == '[') {
                while (character != ']') {

                }
                continue;
            }*/

            if (character == '%') {
                Component comp = new Component(character, Component.Types.BOL);
                this.components.addElement(comp);
                continue;
            }

            if (character == '$') {
                Component comp = new Component(character, Component.Types.EOL);
                this.components.addElement(comp);
                continue;
            }

            if (character == '*' || character == '+') {
                Component comp = new Component(character, Component.Types.CLOUSURE);
                this.components.addElement(comp);
                continue;
            }

            Component component = new Component(character, Component.Types.NORMCHAR);
            this.components.addElement(component);
        }
    }

    @Override
    public String toString() {
        return components.toString();
    }
}
