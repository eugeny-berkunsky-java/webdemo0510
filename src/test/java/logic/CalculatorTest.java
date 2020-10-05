package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final double EPS = 1e-6;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testCalculateSteps() {
        int expected = 751;
        int result = calculator.calculateSteps(0, 3, 0.004);
        assertEquals(expected, result, "Calculate steps error");
    }

    @Test
    void testF() {
        double x1 = 0.5;
        double expected1 = 1;
        double result1 = calculator.f(x1);
        assertEquals(expected1, result1, EPS, "le failed");
        double x2 = 2.0;
        double expected2 = -0.240462;
        double result2 = calculator.f(x2);
        assertEquals(expected2, result2, EPS,  "gt failed");
        double x3 = 1.1;
        double expected3 = -0.057663;
        double result3 = calculator.f(x3);
        assertEquals(expected3, result3, EPS, "mid failed");
    }

    @Test
    void testFillArrayX() {
        double start = 0.0;
        double finish = 3.0;
        double step = 0.004;

        double expected1 = 0.7;
        double expected2 = 1.4;
        double expected3 = 3.0;

        double[] x = calculator.fillArrayX(start, finish, step);
        assertEquals(expected1, x[175], EPS, "x1 error");
        assertEquals(expected2, x[350], EPS, "x2 error");
        assertEquals(expected3, x[750], EPS, "x3 error");
    }

    @Test
    void testFillArrayY() {
        double[] x = calculator.fillArrayX(0,3,0.004);
        double expected1 = 1.0;
        double expected2 = -0.329742;
        double expected3 = 0.214243;
        double[] y = calculator.fillArrayY(x);
        assertEquals(expected1, y[175], EPS, "y1 error " + x[175]);
        assertEquals(expected2, y[350], EPS, "y2 error " + x[350]);
        assertEquals(expected3, y[750], EPS, "y3 error");
    }

    @Test
    void testSumArray() {
        double[] arr = {1.5, 2.8, -1.4, -1.1, 12.2};
        double expected = 14.0;
        double result = calculator.sumArray(arr);
        assertEquals(expected, result, EPS, "sumArray error");
    }

    @Test
    void testAvgArray() {
        double[] arr = {1.5, 2.8, -1.4, -1.1, 12.2};
        double expected = 2.8;
        double result = calculator.avgArray(arr);
        assertEquals(expected, result, EPS, "sumArray error");
    }
}