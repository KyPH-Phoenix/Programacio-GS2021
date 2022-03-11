public class Inventario {
    private final static int MAX_INSTR = 1000;
    private Instrumento[] instrumentos = new Instrumento[MAX_INSTR];
    private int nInstr = 0;

    public void buscar(Especificacion esp) {
        for (int i = 0; i < this.nInstr; i++) {
            Instrumento instr = this.instrumentos[i];
            Especificacion espInst = instr.getEspecificacion();
            if (espInst.match(esp)) {
                System.out.println("\n" + instr);
            }
        }
    }

    public void añadirInstrumentos(Instrumento instr) {
        if (nInstr < MAX_INSTR) {
            this.instrumentos[nInstr] = instr;
            nInstr++;
        }
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append(String.format("Numero de instrumentos: %s\n", this.nInstr));
        for (int i = 0; i < this.nInstr; i++) {
            resultado.append(String.format("\nInstrumento %d\n", i + 1));
            resultado.append(instrumentos[i].toString());
        }
        return resultado.toString();
    }
}
