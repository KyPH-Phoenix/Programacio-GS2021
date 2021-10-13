import java.util.Scanner;

public class ProblemaScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame tu edad: ");
        int edad = sc.nextInt();
        System.out.print("Dame tu nombre: ");
        String nombre = sc.nextLine();

        System.out.printf("Hola, %s. Tienes %d años.", nombre, edad);
    }
}
