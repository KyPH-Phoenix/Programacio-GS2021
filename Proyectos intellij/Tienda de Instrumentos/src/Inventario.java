import java.util.Arrays;

public class Inventario {
    private final static int MAX_INSTR = 1000;
    private Intstrumento[] intstrumentos = new Intstrumento[MAX_INSTR];
    private int nInstr = 0;

    public Intstrumento[] buscarInstrumentos(Especificacion esp) {
        return null;
    }

    public void añadirInstrumentos(Intstrumento instr) {
        if (nInstr < MAX_INSTR) {
            this.intstrumentos[nInstr] = instr;
            nInstr++;
        }
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append(String.format("Numero de instrumentos: %s\n", this.nInstr));
        for (int i = 0; i < this.nInstr; i++) {
            resultado.append(String.format("\nInstrumento %d\n", i + 1));
            resultado.append(intstrumentos[i].toString());
        }
        return resultado.toString();
    }
}
