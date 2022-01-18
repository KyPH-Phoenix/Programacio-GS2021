import com.sun.jdi.event.ExceptionEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    @DisplayName("Suma numeros positivos o negativos, enteros.")
    void add() {
        assertEquals(2, Calculator.add(1, 1));
        assertEquals(-2147483648, Calculator.add(2147483647, 1));
        assertEquals(-7, Calculator.add(3, -10));
    }

    @Test
    @DisplayName("Suma numeros positivos o negativos, decimales.")
    void addDouble() {
        assertEquals(2.15, Calculator.add(0.1, 2.05));
        assertEquals(4, Calculator.add(1.5, 2.5));
        assertEquals(5, Calculator.add(-7.5, 12.5));
        assertEquals(-2147483648, Calculator.add(2147483647, 1));

    }

    @Test
    @DisplayName("Resta numeros positivos o negativos, enteros.")
    void substract() {
        assertEquals(0, Calculator.substract(1, 1));
        assertEquals(2, Calculator.substract(1, -1));
        assertEquals(-2, Calculator.substract(-1, 1));
        assertEquals(5, Calculator.substract(7, 2));
        assertEquals(2147483647, Calculator.substract(-2147483648, 1));
    }

    @Test
    @DisplayName("Resta numeros positivos o negativos, enteros.")
    void substractDouble() {
        assertEquals(0.5, Calculator.substract(2, 1.5));
        assertEquals(-2147483649.0, Calculator.substract(-2147483648.0, 1.0));
        assertEquals(-5.36, 7.1, 12.46);
    }

    @Test
    @DisplayName("Multiplicacion numeros positivos o negativos, enteros.")
    void muliply() {
        assertEquals(1, Calculator.multiply(1, 1));
        assertEquals(16, Calculator.multiply(8, 2));
        assertEquals(0, Calculator.multiply(154, 0));
    }

    @Test
    @DisplayName("Multiplicacion numeros positivos o negativos, decimales.")
    void muliplyDouble() {
        assertEquals(1, Calculator.multiply(1.0, 1.0));
        assertEquals(5, Calculator.multiply(2.5, 2));
        assertEquals(0, Calculator.multiply(154.56, 0));
        assertEquals(12.875001000000001, Calculator.multiply(1.258, 10.2345));
    }


    @Test
    @DisplayName("Test per comprobar divisió de integers.")
    void divide() {
        assertEquals(1, Calculator.divide(2, 2));
        assertEquals(2, Calculator.divide(10, 5));
        assertEquals(1274328, Calculator.divide(2548656, 2));
        //assertEquals(ArithmeticException, Calculator.divide(0, 0));
    }

    @Test
    @DisplayName("Test per comprobar divisió de doubles.")
    void divideDouble() {
        assertEquals(2.3333333333333333, Calculator.divide(7.0, 3.0));
        assertEquals(1.48, Calculator.divide(3.7, 2.5));
        assertEquals(Double.POSITIVE_INFINITY, Calculator.divide(8.324, 0.0));
        assertEquals(Double.NEGATIVE_INFINITY, Calculator.divide(-8.324, 0.0));
        assertEquals(Double.NaN, Calculator.divide(0.0, 0.0));
    }

    @Test
    @DisplayName("Test per comprobar residu")
    void reminder() {
        assertEquals(1, Calculator.remainder(5, 2));
        assertEquals(3, Calculator.remainder(9, 6));
        assertEquals(2, Calculator.remainder(50, -8));
    }

    @Test
    @DisplayName("Test per comprobar potencies")
    void power() {
        assertEquals(4, Calculator.power(2, 2));
        assertEquals(1.971935064, Calculator.power(1.254, 3));
        assertEquals(4, Calculator.power(-2, 2));
    }
}