public class Main {
    public static void main(String[] args) {
        Nombre n1 = new Nombre(255);
        Nombre n2 = new Nombre("IV");

        System.out.println(n1.bin());
        System.out.println(n1.hex());
    }
}
