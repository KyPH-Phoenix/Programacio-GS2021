package Exercici2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercici2Test {

    @Test
    public void testCercle() {
        Circle circle = new Circle();
        assertEquals("Cercle de radi: 1.0", circle.toString());
    }

    @Test
    public void testCilindre() {

    }
}