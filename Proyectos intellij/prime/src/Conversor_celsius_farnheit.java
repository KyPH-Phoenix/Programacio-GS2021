import java.util.Scanner;

public class Conversor_celsius_farnheit {
    public static void main(String[] args) {
        // Formula es: Fº=(Cº*9/5)+32
        // Breve descripción del programa
        System.out.println("Este programa es un conversor de grados celsius a farenheit");
        System.out.println();

        // Pide el valor al usuario
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce los grados celsius: ");
        String userString = sc.nextLine();

        // Convierte el userInput a double
        double celsius = Double.parseDouble(userString);

        // Cálculo y resultado
        double farenheit = ((celsius * 9.0) / 5.0) + 32.0;
        System.out.printf("%.2f grados celsius son %.2f grados farenheit.", celsius, farenheit);
    }
}
