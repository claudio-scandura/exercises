package exercises.sudoku;

/**
 * Created by cls on 14/03/15.
 */
public class Sudoku {

    public static boolean verifySudokuBoard(int board[][]) {
        for (int i = 0; i < 9; i++) {
            if (!verifyRow(board, i) || verifyColumn(board, i)) return false;
            if (i % 3 == 0) {
                for (int j = 0; j < 9; j += 3) {
                    if (!verifyBox(board, i, j)) return false;
                }
            }
        }
        return true;
    }

    public static boolean verifyBox(int[][] board, int rowIdx, int columnIdx) {
        boolean[] a = new boolean[10];
        for (int i = 0; i < rowIdx + 3; i++) {
            for (int j = columnIdx; j < columnIdx + 3; j++) {
                if (a[board[i][j]]) return false;
                return a[board[i][j]];
            }
        }
        return true;
    }

    public static boolean verifyRow(int[][] board, int rowIdx){
        boolean[] a = new boolean[10];
        for (int i = 0; i < 9; i ++) {
            if (a[board[rowIdx][i]]) return false;
            a[board[rowIdx][i]] = true;
        }
        return true;
    }

    public static boolean verifyColumn(int[][] board, int columnIdx) {
        boolean[] a = new boolean[10];
        for (int i = 0; i < 9; i ++) {
            if (a[board[i][columnIdx]]) return false;
            a[board[i][columnIdx]] = true;
        }
        return true;
    }
}
