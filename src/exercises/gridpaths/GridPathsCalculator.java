package exercises.gridpaths;

/**
 * Created by cls on 16/03/15.
 */
public class GridPathsCalculator {

    public static int calculatePaths(int n, int i, int j) {
        if (n <= 1) return 0;
        if (i == n - 1 && j == n - 1) return 1;
        int result = 0;
        if (i < n - 1) result += calculatePaths(n, i + 1, j);
        if (j < n - 1) result += calculatePaths(n, i, j + 1);
        return result;
    }
}
