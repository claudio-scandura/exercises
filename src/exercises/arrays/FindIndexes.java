package exercises.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * find indexes i, j, k in A such that A[k] = A[j] + A[i]
 */
public class FindIndexes {

    public static int[] findInefficently(int[] A) {
        Map<Integer, Integer> valuesToIndex = new HashMap<>();
        for (int i = 0; i < A.length; i++) valuesToIndex.put(A[i], i);
        for (int i = 0; i < A.length; i++) {
            int j = i+1;
            while (j < A.length) {
                Integer k = valuesToIndex.get(A[i] + A[j]);
                if (k != null) return new int[]{i, j, k};
                j++;
            }
        }
        return new int[]{-1, -1, -1};
    }

    public static int[] find(int[] A) {
        Map<Integer, Integer> valuesToIndex = new HashMap<>();
        for (int i = 0; i < A.length; i++) valuesToIndex.put(A[i], i);
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            int j = i - 1;
            int diff = A[i] - A[j];
            if (diff <= A[j]) {
                //lookup
               int index = Arrays.binarySearch(A, 0, j, diff);
               if (index >= 0)
                   return new int[]{valuesToIndex.get(A[index]), valuesToIndex.get(A[j]), valuesToIndex.get(A[i])};
            }

        }
        return new int[]{-1, -1, -1};
    }
}
