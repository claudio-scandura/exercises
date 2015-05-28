package exercises.sudoku;

import org.junit.Test;

import static org.junit.Assert.*;

public class SudokuTest {

    static int[] firstRow =     {9,5,3,2,1,4,7,6,8};
    static int[] secondRow =    {2,7,6,8,5,3,4,1,9};
    static int[] thirdRow =     {8,1,4,6,7,9,2,3,5};

    static int[] forthRow =     {7,4,8,5,3,1,6,9,2};
    static int[] fifthRow =     {6,9,1,7,4,2,5,8,3};
    static int[] sixthRow =     {5,3,2,9,6,8,1,7,4};

    static int[] seventhRow =   {1,6,9,4,8,5,3,2,7};
    static int[] eightRow =     {3,2,5,1,9,7,8,4,6};
    static int[] ninethRow =    {4,8,7,3,2,6,9,5,1};

    private static int[][] getValidSudokuBoard() {
        int[][] board = new int[9][9];
        board[0] = firstRow;
        board[1] = secondRow;
        board[2] = thirdRow;
        board[3] = forthRow;
        board[4] = fifthRow;
        board[5] = sixthRow;
        board[6] = seventhRow;
        board[7] = eightRow;
        board[8] = ninethRow;
        return board;
    }

    @Test
    public void verifySudokuShouldReturnFalseIfNumbersRepeatInBox() {
        int[][] board = getValidSudokuBoard();
        board[4][5] = 5;

        assertFalse(Sudoku.verifySudokuBoard(board));
    }

    @Test
    public void verifySudokuShouldReturnFalseIfNumbersRepeatInRow() {
        int[][] board = getValidSudokuBoard();
        board[3][7] = 8;

        assertFalse(Sudoku.verifySudokuBoard(board));
    }

    @Test
    public void verifySudokuShouldReturnFalseIfNumbersRepeatInColumn() {
        int[][] board = getValidSudokuBoard();
        board[0][8] = 6;

        assertFalse(Sudoku.verifySudokuBoard(board));
    }

    @Test
    public void verifySudokuShouldReturnTrueIfNumbersDoNotRepeatInBoxesColumnsAndRows() {
        int[][] board = getValidSudokuBoard();

        assertFalse(Sudoku.verifySudokuBoard(board));
    }
}