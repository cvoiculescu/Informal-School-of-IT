package org.voiculescu.siit.temawk6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {

    @Test
    public void testGetMax() {
        Calculator c = new Calculator(1, 3, 5);
        assertEquals(5, c.getMax());
    }

    @Test
    public void testGetMaxAllNull() {
        Calculator c = new Calculator();
        assertNull(c.getMax());
    }

    @Test
    public void testGetMaxOneNull() {
        Calculator c = new Calculator(null, 3, 5);
        assertEquals(5, c.getMax());
    }

    @Test
    public void testGetMinOneNull() {
        Calculator c = new Calculator(null, 3, 5);
        assertEquals(3, c.getMin());
    }

    @Test
    public void testGetMinAllNull() {
        Calculator c = new Calculator();
        assertNull(c.getMin());
    }

    @Test
    public void testGetMin() {
        Calculator c = new Calculator(-3, -7, 8);
        assertEquals(-7, c.getMin());
    }

    @Test
    public void testGetSum() {
        Calculator c = new Calculator(1, 2, 3);
        assertEquals(6, c.getSum());
    }

    @Test
    public void testGetSumWithANull() {
        Calculator c = new Calculator(null, 2, 3);
        assertEquals(5, c.getSum());
    }

    @Test
    public void testGetSumWithAllNull() {
        Calculator c = new Calculator();
        assertNull(c.getSum());
    }

    @Test
    public void testGetAvg() {
        Calculator c = new Calculator(1, 2, 3);
        assertEquals(2.0, c.getAvg());
    }

    @Test
    public void testGetAvgWithAllNull() {
        Calculator c = new Calculator();
        assertNull(c.getAvg());
    }

    @Test
    public void testGetAvgWithOneNull() {
        Calculator c = new Calculator(null, 3, 5);
        assertEquals(4, c.getAvg());
    }

    @Test
    public void testAreAllPositive() {
        Calculator c = new Calculator(2, 3, 5);
        assertTrue(c.areAllPositive());
    }

    @Test
    public void testAreAllPositiveWithANegative() {
        Calculator c = new Calculator(2, -3, 5);
        assertFalse(c.areAllPositive());
    }

    @Test
    public void testAreAllPositiveWithANull() {
        Calculator c = new Calculator(null, -3, 5);
        assertFalse(c.areAllPositive());
    }

    @Test
    public void testIsAEvenWithAnEven() {
        Calculator c = new Calculator();
        c.setA(2);
        assertTrue(c.isAEven());
    }

    @Test
    public void testIsAEvenWithAnOdd() {
        Calculator c = new Calculator();
        c.setA(3);
        assertFalse(c.isAEven());
    }

    @Test
    public void testIsAEvenWithANull() {
        Calculator c = new Calculator();
        assertFalse(c.isAEven());
    }

    @Test
    public void testGetA() {
        Calculator c = new Calculator();
        assertNull(c.getA());
    }

    @Test
    public void testGetB() {
        Calculator c = new Calculator();
        assertNull(c.getB());
    }

    @Test
    public void testGetC() {
        Calculator c = new Calculator();
        assertNull(c.getC());
    }

    @Test
    public void testSetA() {
        Calculator c = new Calculator();
        c.setA(1);
        assertEquals(1, c.getA());
    }

    @Test
    public void testSetB() {
        Calculator c = new Calculator();
        c.setB(1);
        assertEquals(1, c.getB());
    }

    @Test
    public void testSetC() {
        Calculator c = new Calculator();
        c.setC(1);
        assertEquals(1, c.getC());
    }
}