public class Main {
    public static void main(String[] args) {
        Caixa caixa = new Caixa();

        caixa.addElement("Juan");
        caixa.addElement(2);
        caixa.addElement(true);
        caixa.addElement("Antonio");

        caixa.remove(1);

        System.out.println(caixa);

        caixa.get(1);
    }
}
