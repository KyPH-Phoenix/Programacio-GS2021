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
                    diferenciaMes();
                    break;
                case 3:
                    temperaturaSemanal();
                    ;
                    break;
                case 4:
                    System.out.println("¡Hasta la próxima!");
                    return;
                default:
                    System.out.println("La opción introducida no es valida.");
            }

            System.out.print("\nPulsa ENTER para continuar");
            sc.nextLine();
            System.out.println("\n\n");
        }
    }

    static int menuPrincipal() {
        int opcion;

        // Preguntar la opción al usuario.
        System.out.println("\n\n--- MENÚ PRINCIPAL ---");
        System.out.println("    1. Datos del mes");
        System.out.println("    2. Diferencia de temperatura del mes");
        System.out.println("    3. Temperaturas semanales");
        System.out.println("    4. Salir");
        System.out.print("\n¿Qué desea hacer? ");

        opcion = Integer.parseInt(sc.nextLine());

        System.out.println();

        // Devuelve la opción.
        return opcion;
    }

    static void procesaDatos() {

        String[] dias = Temps.data.split("\n");

        mesures = new DadesDia[dias.length - 1];

        for (int i = 1; i < mesures.length; i++) {

            String[] diasSeparados = dias[i].split(",", -1);
            DadesDia dadesDia = new DadesDia();

            if (diasSeparados[i].length() < 8)
                continue;

            if (diasSeparados[3].length() > 0) {
                dadesDia.data = LocalDate.parse(diasSeparados[3]);
            }

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
    }

    static void diferenciaMes() {
        System.out.print("¿De que mes quieres consultar los datos? ");
        int mes = Integer.parseInt(sc.nextLine());

        int tmpMax = -1000;
        int tmpMin = 1000;

        for (int i = 0; i < mesures.length; i++) {
            if (mesures[i].data.getMonthValue() < mes) {
                continue;
            }

            if (mesures[i].data.getMonthValue() > mes) {
                break;
            }

            if (mesures[i].tmpAvgExists && mesures[i].tmpAvg < tmpMin) {
                tmpMin = mesures[i].tmpAvg;
            }

            if (mesures[i].tmpAvgExists && mesures[i].tmpAvg > tmpMax) {
                tmpMax = mesures[i].tmpAvg;
            }
        }

        System.out.printf("\nTemperatura mínima: %d\nTemperatura máxima: %d\nDiferencia: %d\n", tmpMin, tmpMax, tmpMax - tmpMin);
    }

    static void temperaturaSemanal() {
        LocalDate primerDia;
        LocalDate segundoDia;

        while (true) {
            System.out.print("Introduce el primer dia (mm-dd): ");
            primerDia = LocalDate.parse("2021-" + sc.nextLine());
            System.out.print("Introduce el segundo dia (mm-dd). Éste tiene que ser mayor que el primero: ");
            segundoDia = LocalDate.parse("2021-" + sc.nextLine());

            if (segundoDia.getMonthValue() > primerDia.getMonthValue()) {
                break;
            }

            if (segundoDia.getMonthValue() == primerDia.getMonthValue() && segundoDia.getDayOfMonth() > primerDia.getDayOfMonth()) {
                break;
            }

            System.out.println("\n\nNo has introducido una fecha válida, vuelve a intentar.\n\n");
        }

        int totalDias = segundoDia.getDayOfYear() - primerDia.getDayOfYear();
        int nSemanas = totalDias / 7;
        int semanasExtra = 0;

        System.out.println(primerDia.getDayOfWeek() + " " + segundoDia.getDayOfWeek());

        if (!Objects.equals(primerDia.getDayOfWeek().toString(), "MONDAY")) {
            semanasExtra++;
        }

        if (!Objects.equals(segundoDia.getDayOfWeek().toString(), "SUNDAY")) {
            semanasExtra++;
        }

        //double[] tmpAvgSemana = new double[nSemanas + semanasExtra];

        double contadorSemana = 0;
        double totalSemana = 0;
        int i = 0;
        int j = 0;

        while (i < nSemanas + semanasExtra) {
            if (mesures[j].data.getDayOfYear() < primerDia.getDayOfYear()) {
                j++;
                continue;
            }

            do {
                totalSemana += mesures[j].tmpAvg;
                contadorSemana++;
                j++;
            } while (!Objects.equals(mesures[j].data.getDayOfWeek().toString(), "MONDAY") && mesures[j].data.getDayOfYear() > segundoDia.getDayOfYear());

            System.out.printf("\nSemana %d: %.2f", i, totalSemana / contadorSemana);
            totalSemana = 0;
            contadorSemana = 0;

            i++;
        }
    }
}
