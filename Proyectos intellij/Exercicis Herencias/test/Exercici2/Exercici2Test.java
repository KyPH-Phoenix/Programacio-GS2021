package Exercici2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercici2Test {

    @Test
    public void testCercle() {
        Circle circle;

        circle = new Circle();
        assertEquals("Cercle de radi: 1.0", circle.toString());
        assertEquals(3.14159,circle.getArea(),0.00001);

        circle = new Circle(5);
        assertEquals("Cercle de radi: 5.0", circle.toString());
        assertEquals(78.53981,circle.getArea(),0.00001);


        circle = new Circle(6.89);
        assertEquals("Cercle de radi: 6.89", circle.toString());
        assertEquals(149.13800,circle.getArea(),0.00001);
    }

    @Test
    public void testCilindre() {
        Cylinder cylinder;

        cylinder = new Cylinder();
    }
}