package Exercici2;

public class Cylinder extends Circle {
    private double heigth = 1.0;

    public Cylinder() {}

    public Cylinder(double radius, double heigth) {
        super(radius);
        this.heigth = heigth;
    }

    @Override
    public double getArea() {

        return 1;
    }
}
