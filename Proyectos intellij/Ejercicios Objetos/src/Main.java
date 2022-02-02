public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Juan", 35);
        Person p2 = new Person("Juan", 35);

        if (!(p1.equals(p2))) {
            System.out.println("diferents");
        } else {
            System.out.println("iguals");
        }
    }
}
