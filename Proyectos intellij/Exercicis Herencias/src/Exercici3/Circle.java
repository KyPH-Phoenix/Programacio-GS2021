package Exercici3;

import java.util.Locale;

public class Circle extends Shape{
    private double radius = 1.0;
    private String color = "red";

    public double getRadius() { return radius; }

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter() { return 2 * Math.PI * this.radius; }

    @Override
    public String toString() {
        String resultado = "";
        String filledString = (this.isFilled()) ? "Si" : "No";

        resultado += "\nCirculo de radio " + this.radius;
        resultado += "\nCirculo de color " + this.getColor().toLowerCase().charAt(0) + this.getColor().substring(1);
        resultado += "\nEsta relleno: " + filledString;
        resultado += "\nArea del circulo: " + this.getArea();
        resultado += "\nPerimetro del circulo: " + this.getPerimeter();
        resultado += "\n" + this.getClass().getSimpleName() + " es una sublcase de " + this.getClass().getSuperclass().getSimpleName();

        return resultado;
    }
}
