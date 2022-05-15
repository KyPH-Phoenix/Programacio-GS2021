public class Exercici1 {
    public static void main(String[] args) {
        try {
            throw new Exception("Manolo");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Dins el finally");
        }
    }
}
