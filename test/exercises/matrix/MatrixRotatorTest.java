package exercises.matrix;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixRotatorTest {

    @Test
    public void shouldRotateA3x3Matrix() {
        int[][] input = new int[3][3];
        input[0][0] = 1;
        input[0][1] = 2;
        input[0][2] = 3;

        input[1][0] = 4;
        input[1][1] = 5;
        input[1][2] = 6;

        input[2][0] = 7;
        input[2][1] = 8;
        input[2][2] = 9;

        int[][] expectedOutput = new int[3][3];
        expectedOutput[0][0] = 7;
        expectedOutput[0][1] = 4;
        expectedOutput[0][2] = 1;

        expectedOutput[1][0] = 8;
        expectedOutput[1][1] = 5;
        expectedOutput[1][2] = 2;

        expectedOutput[2][0] = 9;
        expectedOutput[2][1] = 6;
        expectedOutput[2][2] = 3;

        int[][] output = MatrixRotator.rotate(input);

        System.out.println(Arrays.toString(output[0]));
        System.out.println(Arrays.toString(output[1]));
        System.out.println(Arrays.toString(output[2]));

        assertArrayEquals(expectedOutput[0], output[0]);
        assertArrayEquals(expectedOutput[1], output[1]);
        assertArrayEquals(expectedOutput[2], output[2]);
    }

    @Test
    public void shouldSetZerosInAllColumnAndRow() {
        int[][] input = new int[3][3];
        input[0][0] = 1;
        input[0][1] = 2;
        input[0][2] = 3;

        input[1][0] = 4;
        input[1][1] = 0;
        input[1][2] = 6;

        input[2][0] = 7;
        input[2][1] = 8;
        input[2][2] = 9;

        int[][] expectedOutput = new int[3][3];
        expectedOutput[0][0] = 1;
        expectedOutput[0][1] = 0;
        expectedOutput[0][2] = 3;

        expectedOutput[1][0] = 0;
        expectedOutput[1][1] = 0;
        expectedOutput[1][2] = 0;

        expectedOutput[2][0] = 7;
        expectedOutput[2][1] = 0;
        expectedOutput[2][2] = 9;

        MatrixRotator.setZeros(input);

        System.out.println(Arrays.toString(input[0]));
        System.out.println(Arrays.toString(input[1]));
        System.out.println(Arrays.toString(input[2]));

        assertArrayEquals(expectedOutput[0], input[0]);
        assertArrayEquals(expectedOutput[1], input[1]);
        assertArrayEquals(expectedOutput[2], input[2]);
    }
}