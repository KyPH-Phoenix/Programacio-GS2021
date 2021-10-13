import java.util.Scanner;

public class Estructura {
    public static void main(String[] args) {
        // Salida de datos
        System.out.println("Hola");
        /*
        System.out -->  Class
        println --> Metodo/Función
        ("Hola") --> Argumentos
         */

        // Introducción de datos
        Scanner s= new Scanner(System.in);
        System.out.print("Introdueix el teu nom: ");
        String nom = s.nextLine();
        System.out.println("Hola "+ nom);
        /*

         */
    }
}
