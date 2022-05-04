import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a;

        while (true) {
            try {
                a = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Error: valor introducido invalido. Vuelve a intentar");
            }
        }

        System.out.println(a);
    }
}
