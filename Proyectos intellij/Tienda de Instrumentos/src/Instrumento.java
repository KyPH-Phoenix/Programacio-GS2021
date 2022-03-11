public class Instrumento {
    private int nSerie;
    private Especificacion especificacion;

    public int getnSerie() {
        return nSerie;
    }

    public void setnSerie(int nSerie) {
        this.nSerie = nSerie;
    }

    public Especificacion getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(Especificacion especificacion) {
        this.especificacion = especificacion;
    }

    public Instrumento() {}

    public Instrumento(Especificacion esp) {
        this.especificacion = esp;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        resultado.append(String.format("Numero de serie: %s\n", this.nSerie));
        resultado.append(especificacion.toString());

        return resultado.toString();
    }
}
