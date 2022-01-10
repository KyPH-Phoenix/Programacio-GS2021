import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    System.out.println("*Muesta los datos*");
                    mostrarDatosMes();
                    break;
                case 2:
                    System.out.println("¡Hasta la próxima!");
                    return;
                default:
                    System.out.println("La opción introducida no es valida.");
                    ;
            }
        }
    }

    static int menuPrincipal() {
        int opcion;

        System.out.println();
        System.out.println("--- MENÚ PRINCIPAL ---");
        System.out.println("    1. Datos del mes");
        System.out.println("    2. Salir");
        System.out.println();
        System.out.print("¿Qué desea hacer? ");

        opcion = Integer.parseInt(sc.nextLine());

        System.out.println();

        return opcion;
    }

    static void mostrarDatosMes() {
        System.out.print("¿De que mes quieres consultar los datos?");
        int mes = Integer.parseInt(sc.nextLine());

        String[] dias = Temps.data.split("\n");

        int contPrcp;
        double mediaPrcp;
        int contTmpAvg;
        double mediaTmpAvg;
        int contTmpMin;
        double mediaTmpMin;
        int contTmpMax;
        double mediaTmpMax;

        for (int i = 0; i < dias.length; i++) {
            String[] elementosSeparados = dias[i].split(",");
            LocalDate fecha = LocalDate.parse(elementosSeparados[3]);

            if (elementosSeparados.length < 8) {
                continue;
            }

            if (fecha.getMonthValue() != mes) {
                continue;
            }


        }
    }
}
