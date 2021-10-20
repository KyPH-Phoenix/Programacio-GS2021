import java.util.Scanner;

public class Conversor_cm_in {
    public static void main(String[] args) {
        // Declara la constante cm_by_inch que son los cm que tiene una pulgada.
        final double cm_by_inch = 2.54;

        // Descripción del funcionamiento del programa.
        System.out.println();
        System.out.println("Este programa convierte un valor escrito en cm a pulgadas.");
        System.out.println();

        // Pide el valor al usuario
        Scanner sc= new Scanner(System.in);
        System.out.print("Introduce tu valor en cm: ");
        String userString = sc.nextLine();

        // Calcula el resultado y lo imprime por pantalla
        double cm = Double.parseDouble((userString));
        double inch = cm / cm_by_inch;
        System.out.printf("%.2f cm son %.2f pulgadas", cm, inch);

    }
}
