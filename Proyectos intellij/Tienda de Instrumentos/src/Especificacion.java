public class Especificacion {
    private static final int MAX_ATRIBUTOS = 100;

    private String[] atributos = new String[MAX_ATRIBUTOS];
    private Object[] valores = new Object[MAX_ATRIBUTOS];
    private int nAtributos = 0;

    public String[] getAtributos() {
        return atributos;
    }

    public Object[] getValores() {
        return valores;
    }

    public void añadirEsp(String nombreAtributo, Object valor) {
        if (this.nAtributos < MAX_ATRIBUTOS) {
            this.atributos[this.nAtributos] = nombreAtributo;
            this.valores[this.nAtributos] = valor;
            nAtributos++;
        }
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < this.nAtributos; i++) {
            resultado.append(String.format("%s: %s\n", this.atributos[i], this.valores[i]));
        }

        return resultado.toString();
    }

    public boolean match(Especificacion espCerca) {
        Especificacion espInst = this;
        for (int i = 0; i < espCerca.nAtributos; i++) {
            String atributo = espCerca.atributos[i];
            Object valor = espCerca.valores[i];
            if (!atributoMatch(atributo, valor)) {
                return false;
            }
        }

        return true;
    }

    private boolean atributoMatch(String atributo, Object valor) {
        for (int i = 0; i < this.nAtributos; i++) {
            if (atributos[i].equals(atributo)) {
                return valores[i].equals(valor);
            }
        }

        return false;
    }
}
