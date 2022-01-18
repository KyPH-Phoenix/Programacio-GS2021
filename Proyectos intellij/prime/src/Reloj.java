public class Reloj {

    public static void main(String[] args) {
        int segundos = 55;
        int minutos = 59;
        int horas = 23;

        while (true) {
            boolean siguiente = false;

            while (horas < 24) {
                System.out.println(horas);
                while (!siguiente) {
                    while (segundos < 60) {
                        System.out.printf("%02d:%02d:%02d%n", horas, minutos, segundos);
                        segundos ++;

                        if (minutos == 59) {
                            siguiente = true;
                        }

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    segundos = 0;
                    if (minutos < 59) {
                        minutos++;
                    }
                }
                siguiente = false;
                minutos = 0;
                horas++;
            }
            horas = 0;
        }
    }
}
