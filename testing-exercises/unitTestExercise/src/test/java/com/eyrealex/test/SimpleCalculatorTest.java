package test.java.com.eyrealex.test;

import main.java.com.eyrealex.core.SimpleCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCalculatorTest {

    @Test
    void add_twoPlusTwo_returnFour() {

        var calculator = new SimpleCalculator();
        assertEquals(4, calculator.add(2, 2));

    }

    @Test
    void add_threePlusSeven_returnTen() {

        var calculator = new SimpleCalculator();
        assertEquals(10, calculator.add(3, 7));

    }

}