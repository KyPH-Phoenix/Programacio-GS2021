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

            if (character == '[') {
                i++;
                character = pat.charAt(i);

                String charGroup = "";
                while (character != ']') {
                    if (character == '-') {
                        charGroup += addRange(pat.charAt(i - 1), pat.charAt(i + 1));
                    } else {
                        charGroup += character;
                    }

                    i++;
                    character = pat.charAt(i);
                }
                Component comp = new Component(charGroup, Component.Types.CHARGROUP);
                this.components.addElement(comp);
                continue;
            }

            if (character == '%' && i == 0) {
                Component comp = new Component(character, Component.Types.BOL);
                this.components.addElement(comp);
                continue;
            }

            if (character == '$' && i == pat.length() - 1) {
                Component comp = new Component(character, Component.Types.EOL);
                this.components.addElement(comp);
                continue;
            }

            if (character == '*' || character == '+') {
                Component comp = new Component(character, Component.Types.CLOUSURE);
                comp.setSubcomponent(this.components.get(i - 2));
                this.components.remove(i - 2);
                this.components.addElement(comp);
                continue;
            }

            Component component = new Component(character, Component.Types.NORMCHAR);
            this.components.addElement(component);
        }
    }

    private String addRange(char firstChar, char lastChar) {
        String resultado = "";

        for (int i = firstChar + 1; i < lastChar; i++) {
            resultado += (char) i;
        }

        return resultado;
    }

    @Override
    public String toString() {
        return components.toString();
    }
}
