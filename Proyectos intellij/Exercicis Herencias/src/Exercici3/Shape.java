package Exercici3;

import java.util.Locale;

public class Shape {
    private String color = "red";
    private boolean filled = true;

    public Shape() {}

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        String filledString = (this.filled) ? "filled" : "not filled";

        return "\nShape with color " + this.color.toLowerCase().charAt(0) + this.color.substring(1)
        + " and " + filledString;
    }
}
