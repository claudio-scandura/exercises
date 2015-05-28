package exercises.fibonacci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void fibonacciShouldReturnOne() {
        assertEquals(1, Fibonacci.naive(1));
        assertEquals(1, Fibonacci.naive(2));
    }

    @Test
    public void fibonacciShouldReturnOneFourFour() {
        assertEquals(144, Fibonacci.naive(12));
    }

    @Test
    public void fibonacciShouldReturn() {
        assertEquals(1820529360, Fibonacci.iterative(60));
    }

    @Test
    public void lambdaTests() {
        int[] C={1, 0};
        assertEquals("C", true,
                isCircleSorted(C));
    }

    public static boolean isCircleSorted(int[] a) {
        int minIndex = 0;
        String s = "abracadabra bra";
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[minIndex]) minIndex = i;
        }

        for (int k = (minIndex + 1) % a.length; k != minIndex; k = (k + 1) % a.length) {

            int prev = (k == 0) ? a.length - 1 : k - 1;
            if (a[k] < a[prev]) return false;
        }
        return true;
    }

}