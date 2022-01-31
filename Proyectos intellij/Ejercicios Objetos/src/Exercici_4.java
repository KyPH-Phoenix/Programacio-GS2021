public class Exercici_4 {
    public static void main(String[] args) {
        Nombre n1 = new Nombre(56);
        Nombre n2 = new Nombre("CXVII");

        System.out.println(n1.valor);
        System.out.println(n1.bin());
        System.out.println(n1.hex());

        System.out.println();

        System.out.println(n2.valor);
        System.out.println(n2.bin());
        System.out.println(n2.hex());
    }
}
