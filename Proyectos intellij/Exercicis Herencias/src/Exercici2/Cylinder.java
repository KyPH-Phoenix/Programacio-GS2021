package Exercici2;

public class Cylinder extends Circle {
    private double heigth = 1.0;

    public double getHeigth() {
        return heigth;
    }

    public Cylinder() {
    }

    public Cylinder(double radius, double heigth) {
        super(radius);
        this.heigth = heigth;
    }

    @Override
    public double getArea() {
        double radius = this.getRadius();

        return 2 * Math.PI * radius * (radius + this.heigth);
    }

    @Override
    public String toString() {
        String resultado = "\nCilindro de altura " + this.heigth + " y radio " + this.getRadius();
        resultado += "\nArea del cilindro: " + this.getArea();
        resultado += "\nCylinder es una subclase de: " + this.getClass().getSuperclass().getSimpleName();
        return resultado;
    }
}
