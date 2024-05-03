package ece325.lec.assignment5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSalary {
    @Test
    void testValidPay() {
        // Test valid pay calculation
        assertEquals(55.0, Salary.pay(100.0, 50.0, 10), 0.001);
    }

    @Test
    void testMinimumBonus() {
        // Test pay calculation with zero bonus
        assertEquals(50.0, Salary.pay(100.0, 50.0, 0), 0.001);
    }

    @Test
    void testMaxBaseSalary() {
        // Test pay calculation with maximum base salary
        assertEquals(866.25, Salary.pay(1000.0, 175.0, 5), 0.001);
    }

    @Test
    void testMinimumBaseSalary() {
        // Test pay calculation with minimum base salary
        assertEquals(0.0, Salary.pay(0.0, 0.0, 10), 0.001);
    }

    @Test
    void testMaximumSnacksAmount() {
        // Test pay calculation with maximum snacksAmount
        assertEquals(0.0, Salary.pay(100.0, 100.0, 5), 0.001);
    }

    @Test
    void testInvalidBonus() {
        // Test invalid bonus percentage
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(100.0, 50.0, -5));
    }

    @Test
    void testInvalidSnacksAmount() {
        // Test snacks amount exceeding base salary
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(100.0, 150.0, 5));
    }

    @Test
    void testInvalidBaseSalary() {
        // Test base salary exceeding maximum limit
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(1100.0, 50.0, 5));
    }

    @Test
    void testMaxIntegerBonus() {
        // Test maximum value of integer as bonus percentage
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(100.0, 50.0, Integer.MAX_VALUE));
    }

    @Test
    void testMaxDoubleSnacksAmount() {
        // Test maximum value of Double as snacksAmount
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(1000.0, Double.MAX_VALUE, 5));
    }

    @Test
    void testMaxDoubleSalary() {
        // Test maximum value of Double as base salary
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(Double.MAX_VALUE, 50.0, 5));
    }

    @Test
    void testNullBaseSalary() {
        // Test if the base salary parameter is null
        assertThrows(NullPointerException.class, () -> Salary.pay(null, 50.0, 5));
    }

    @Test
    void testNullSnacksAmount() {
        // Test if the snacksAmount parameter is null
        assertThrows(NullPointerException.class, () -> Salary.pay(500.0, null, 10));
    }

    @Test
    void testNullBonus() {
        // Test if the bonus parameter is null
        assertThrows(NullPointerException.class, () -> Salary.pay(1000.0, 50.0, null));
    }

    @Test
    void testAllNullParameters() {
        // Test if all the parameters are null
        assertThrows(NullPointerException.class, () -> Salary.pay(null, null, null));
    }
}