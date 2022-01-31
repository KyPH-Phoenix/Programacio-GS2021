public class Exercici_2 {
    public static void main(String[] args) {
        Peix p1 = new Peix("Manolo");
        Peix p2 = new Peix("Ramon");
        Peix p3 = new Peix(p2);
        Peix p4 = new Peix(p1);

        System.out.println(p3.count);
        System.out.println(p4.equals(p1));
        System.out.println(p3.equals(p4));
    }
}
