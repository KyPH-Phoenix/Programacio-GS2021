package Exercici2;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public double getRadius() { return radius; }

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public String toString() {
        return "\nCirculo de radio: " + this.radius + "\nArea del circulo: " + this.getArea();
    }
}
