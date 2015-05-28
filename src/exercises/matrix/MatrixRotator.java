package exercises.matrix;


import java.util.HashMap;
import java.util.Map;

public class MatrixRotator {

    public static int[][] rotate(int[][] input) {
        int n = input.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][Math.abs(i - n  +1)] = input[i][j];
            }

        }
        return result;
    }

    public static void setZeros(int[][] input) {
        Map<Integer, Integer> indecesWithValueZero = new HashMap<Integer, Integer>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j< input[i].length; j++) {
                if (input[i][j] == 0) indecesWithValueZero.put(i, j);
            }
        }

        for (Map.Entry<Integer, Integer> indeces: indecesWithValueZero.entrySet()) {
            for (int k = 0; k < input[indeces.getKey()].length; k ++)
                input[indeces.getKey()][k] = 0;
            for (int k = 0; k < input.length; k ++)
                input[k][indeces.getValue()] = 0;
        }
    }
}
