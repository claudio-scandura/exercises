package exercises.fibonacci;

import java.util.Map;

/**
 * Created by cls on 22/03/15.
 */
public class Fibonacci {

    public static long naive(int k) {
        if (k == 1 || k == 2) return 1;
        return naive(k - 1) + naive(k - 2);
    }

    public static long withAuxMem(int k, Map<Integer, Long> map) {
        if (k == 1 || k == 2) return 1;
        Long fibKminusOne = map.get(k - 1);
        Long fibKminusTwo = map.get(k - 2);
        if (fibKminusTwo == null) fibKminusTwo = withAuxMem(k - 2, map);
        if (fibKminusOne == null) fibKminusOne = withAuxMem(k - 1, map);
        return fibKminusOne + fibKminusTwo;
    }

    public static long iterative(int k) {
        int fibKminusOne = 1;
        int fibKminusTwo = 1;
        int fibk = 0;
        for (int j = 3; j <= k; j++) {
            fibk = fibKminusOne + fibKminusTwo;
            fibKminusTwo = fibKminusOne;
            fibKminusOne = fibk;
        }
        return fibk;
    }
}
