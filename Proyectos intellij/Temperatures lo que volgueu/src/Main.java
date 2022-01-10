import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    mostrarDatosMes();
                    break;
                case 2:
                    System.out.println("¡Hasta la próxima!");
                    return;
                default:
                    System.out.println("La opción introducida no es valida.");
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

        int contPrcp = 0;
        double totalPrcp = 0;
        int contTmpAvg = 0;
        double totalTmpAvg = 0;
        int contTmpMin = 0;
        double totalTmpMin = 0;
        int contTmpMax = 0;
        double totalTmpMax = 0;

        for (int i = 0; i < dias.length; i++) {
            String[] elementosSeparados = dias[i].split(",");

            if (elementosSeparados.length < 8) {
                continue;
            }

            LocalDate fecha = LocalDate.parse(elementosSeparados[3]);

            if (fecha.getMonthValue() != mes) {
                continue;
            }

            if (!Objects.equals(elementosSeparados[4], "")) {
                contPrcp++;
                totalPrcp += Double.parseDouble(elementosSeparados[4]);
            }

            if (!Objects.equals(elementosSeparados[5], "")) {
                contTmpAvg++;
                totalTmpAvg += Double.parseDouble(elementosSeparados[5]);
            }

            if (!Objects.equals(elementosSeparados[6], "")) {
                contTmpMax++;
                totalTmpMax += Double.parseDouble(elementosSeparados[6]);
            }

            if (!Objects.equals(elementosSeparados[7], "")) {
                contTmpMin++;
                totalTmpMin += Double.parseDouble(elementosSeparados[7]);
            }
        }

        double mediaPrcp = totalPrcp / contPrcp;
        double mediaTmpAvg = totalTmpAvg / contTmpAvg;
        double mediaTmpMax = totalTmpMax / contTmpMax;
        double mediaTmpMin = totalTmpMin / contTmpMin;

        System.out.printf("\nLa precipitación media del mes fue de %.2f galones\n", mediaPrcp);
        System.out.printf("La temperatura media del mes fue de %.2f farenheit\n", mediaTmpAvg);
        System.out.printf("La temperatura máxima media del mes fue %.2f farenheit\n", mediaTmpMax);
        System.out.printf("La temperatura mínima media del mes fue %.2f farenheit\n", mediaTmpMin);
    }
}
