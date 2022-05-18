public class Exercici7 {
    public static void main(String[] args) {
        try {
            throw new Excep1();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Excep1 extends Exception {}
class Excep2 extends Exception {}
class Excep3 extends Exception {}

