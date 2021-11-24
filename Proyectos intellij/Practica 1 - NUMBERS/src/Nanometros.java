public class Nanometros {
    public static void main(String[] args) {
        long nanometros = 9_223_372_036_854_775_807L;

        System.out.println(nanometros);

        double centimetros = nanometros / 10_000.0;

        System.out.println(centimetros);

        long metros = nanometros / 1_000_000;

        System.out.println(metros);

        long kilometros = metros / 1_000;

        System.out.println(kilometros);

        long unidadesAstronomicas = kilometros / 149_600_000;

        System.out.println(unidadesAstronomicas);

        double diametroPene = 2 * (11.66 / (2 * Math.PI));

        System.out.println(diametroPene);

        double proporcionPene = 15 / diametroPene;

        System.out.println(proporcionPene);

        double grosor = proporcionPene / centimetros;

        System.out.println(grosor);

        0.00000000000004381803061860919;

    }
}
