package exercises.sumofmultiples;

/**
 * Find the sum of all the numbers from 1 to T that are multiple of k or g
 */
public class SumOfMultiples {

    public static int findSumOfMultiplesInADumbWay(int T, int k, int g) {
        int result = 0;
        for (int i = 1; i < T; i++) {
            if (i % k == 0 || i % g == 0) result += i;
        }
        return result;
    }

    public static int findSumOfMultiplesInACleverWay(int T, int k, int g) {
        int result = 0;
        boolean[] aux = new boolean[T];
        int multiple = k;
        while (multiple < T) {
            aux[multiple] = true;
            result += multiple;
            multiple += k;
        }
        multiple = g;
        while (multiple < T) {
            if (!aux[multiple]) result += multiple;
            multiple += g;
        }
        return result;
    }
}
