import java.util.Locale;
import java.util.Scanner;

public class Control_execucio {
    public static void main(String[] args) {
        // True - False
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el primer valor: ");
        String userFirst = sc.nextLine();
        System.out.print("Introduce el segundo valor: ");
        String userSecond = sc.nextLine();

        int a = Integer.parseInt((userFirst));
        int b = Integer.parseInt((userSecond));

        if (a == b) {
            System.out.println("a = b");
        } else if (a <= b) {
            System.out.println("a <= b");
        } else if (a > b) {
            System.out.println("a > b");
        }

        // Switch
        System.out.print("Introduce un numero de mes: ");
        String mes = sc.nextLine().toLowerCase(Locale.ROOT);

        /* switch (mes) {
            case 1:
                System.out.println("Enero");
                break;
            case 2:
                System.out.println("Febrer");
                break;
            case 3:
                System.out.println("Marzo");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Mayo");
        }
         */
        switch (mes) {
            case "enero":
                System.out.println("1");
                break;
            case "febrero":
                System.out.println("2");
                break;
            case "marzo":
                System.out.println("3");
                break;
            default:
                System.out.println("No es un mes válido.");
                break;
        }

        int ciclo = 1;
        while (ciclo == 1) {
            System.out.print("¿Quieres hacer algo mas? (Si/No)");
            String confirm = sc.nextLine().toLowerCase(Locale.ROOT);
            switch (confirm) {
                case "si":
                    System.out.println("Si");
                    break;
                case "no":
                    ciclo++;
                    System.out.println("No");
                    break;
                default:
                    System.out.println("Por favor, introduce 'Si' o 'No'.");
                    break;
            }
        }

        // Me he adelantado, ciclos. While ya esta explicado.
        // FOR
        // 1- Inicializacion
        // 2- Condicion
        // 3- Instruccion de incremento
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // Break sale del bucle.
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            if (i == 4) {
                break;
            }
        }

        // Continue reinicia el bucle saltandose las instrucciones siguientes
        for (int i = 10; i > 0; i--) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        }
    }

}
