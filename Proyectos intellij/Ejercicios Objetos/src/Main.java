public class Main {
    public static void main(String[] args) {
        Peix p1 = new Peix("Manolo");
        Peix p2 = new Peix(p1);
        Peix p3 = new Peix(p2);

        System.out.printf("%d, %d, %d", p1.count, p2.count, p3.count);
    }
}
