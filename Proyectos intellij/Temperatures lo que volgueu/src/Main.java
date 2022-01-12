import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static DadesDia[] mesures;

    public static void main(String[] args) {
        procesaDatos();

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

    static void procesaDatos() {

        String[] dias = Temps.data.split("\n");

        mesures = new DadesDia[dias.length - 1];

        for (int i = 1; i < mesures.length; i++) {

            String[] diasSeparados = dias[i].split(",", -1);
            DadesDia dadesDia = new DadesDia();

            dadesDia.data = LocalDate.parse(diasSeparados[3]);

            if (diasSeparados[4].length() > 0) {
                dadesDia.precip = Double.parseDouble(diasSeparados[4]);
                dadesDia.precipExists = true;
            }

            if (diasSeparados[5].length() > 0) {
                dadesDia.tmpAvg = Integer.parseInt(diasSeparados[5]);
                dadesDia.tmpAvgExists = true;
            }

            if (diasSeparados[6].length() > 0) {
                dadesDia.tmpMax = Integer.parseInt(diasSeparados[6]);
                dadesDia.tmpMaxExists = true;
            }

            if (diasSeparados[7].length() > 0) {
                dadesDia.tmpMin = Integer.parseInt(diasSeparados[7]);
                dadesDia.tmpMinExists = true;
            }

            mesures[i - 1] = dadesDia;
        }
    }

    static int menuPrincipal() {
        int opcion;

        // Preguntar la opción al usuario.
        System.out.println();
        System.out.println("--- MENÚ PRINCIPAL ---");
        System.out.println("    1. Datos del mes");
        System.out.println("    2. Salir");
        System.out.println();
        System.out.print("¿Qué desea hacer? ");

        opcion = Integer.parseInt(sc.nextLine());

        System.out.println();

        // Devuelve la opción.
        return opcion;
    }

    static void mostrarDatosMes() {
        System.out.print("¿De que mes quieres consultar los datos? ");
        int mes = Integer.parseInt(sc.nextLine());

        int contPrecip = 0;
        double totalPrecip = 0;
        int contTmpAvg = 0;
        double totalTmpAvg = 0;
        int contTmpMin = 0;
        double totalTmpMin = 0;
        int contTmpMax = 0;
        double totalTmpMax = 0;

        for (int i = 0; i < mesures.length; i++) {
            if (mesures[i].data.getMonthValue() < mes) {
                continue;
            }
            if (mesures[i].data.getMonthValue() > mes) {
                break;
            }

            if (mesures[i].precipExists) {
                contPrecip++;
                totalPrecip += mesures[i].precip;
            }

            if (mesures[i].tmpAvgExists) {
                contTmpAvg++;
                totalTmpAvg += mesures[i].tmpAvg;
            }

            if (mesures[i].tmpMaxExists) {
                contTmpMax++;
                totalTmpMax += mesures[i].tmpMax;
            }

            if (mesures[i].tmpMinExists) {
                contTmpMin++;
                totalTmpMin += mesures[i].tmpMin;
            }
        }

        System.out.printf("\nLa precipitación media del mes fue de %.2f galones\n", totalPrecip / contPrecip);
        System.out.printf("La temperatura media del mes fue de %.2f farenheit\n", totalTmpAvg / contTmpAvg);
        System.out.printf("La temperatura máxima media del mes fue %.2f farenheit\n", totalTmpMax / contTmpMax);
        System.out.printf("La temperatura mínima media del mes fue %.2f farenheit\n", totalTmpMin / contTmpMin);

        System.out.println("\nPulsa ENTER para continuar: ");
        sc.nextLine();
        System.out.println("\n\n");
    }
}
