import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    @DisplayName("Suma numeros positivos o negativos, enteros o decimales.")
    void add() {
        assertEquals(2, Calculator.add(1, 1));
        assertEquals(-2147483648, Calculator.add(2147483647, 1));
        assertEquals(-7, Calculator.add(3, -10));
    }
    @Test
    void addDouble() {
        assertEquals(2.15, Calculator.add(0.1, 2.05));
        assertEquals(4, Calculator.add(1.5, 2.5));
        assertEquals(5, Calculator.add(-7.5,12.5));
    }

    @Test
    void substract() {

    }
}