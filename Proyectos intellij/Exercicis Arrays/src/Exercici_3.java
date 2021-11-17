import java.util.Scanner;

public class Exercici_3 {
    public static void main(String[] args) {
        double[] coordenada1 = new double[2];
        double[] coordenada2 = new double[2];

        Scanner sc = new Scanner(System.in);

        System.out.print("Valor X de la primera coordenada: ");
        coordenada1[0] = Double.parseDouble(sc.nextLine());
        System.out.print("Valor Y de la primera coordenada: ");
        coordenada1[1] = Double.parseDouble(sc.nextLine());
        System.out.print("Valor X de la segunda coordenada: ");
        coordenada2[0] = Double.parseDouble(sc.nextLine());
        System.out.print("Valor Y de la segunda coordenada: ");
        coordenada2[1] = Double.parseDouble(sc.nextLine());

        double vectorX = Math.abs(coordenada1[0] - coordenada2[0]);
        double vectorY = Math.abs(coordenada1[1] - coordenada2[1]);
        double distEuclidiana = Math.hypot(vectorX, vectorY);

        System.out.println(distEuclidiana);
    }
}
