public class Exercici4 {
    public static void main(String[] args) {
        try {
            throw new ExcepcioCustom("Manolito");
        } catch (ExcepcioCustom e) {
            System.out.println(e);
        }
    }
}

class ExcepcioCustom extends Exception {
    private String string;

    public ExcepcioCustom(String s) {
        this.string = s;
    }

    @Override
    public String toString() {
        return this.string;
    }
}