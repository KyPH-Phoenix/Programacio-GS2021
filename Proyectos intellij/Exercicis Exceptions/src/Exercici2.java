import java.util.List;

public class Exercici2 {
    public static void main(String[] args) {
        try {
            List li = null;
            li.add(2);
        } catch (Exception e) {
            System.out.println("No s'ha pogut afegir el valor perque l'objecte es null");
        }
    }
}
