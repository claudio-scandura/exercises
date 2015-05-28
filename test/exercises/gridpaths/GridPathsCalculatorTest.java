package exercises.gridpaths;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridPathsCalculatorTest {

    @Test
    public void oneA1By1GridZeroPathsShouldBePossible() {
        assertEquals(0, GridPathsCalculator.calculatePaths(1, 0, 0));
    }

    @Test
    public void oneA2By2GridTwoPathsShouldBePossible() {
        assertEquals(2, GridPathsCalculator.calculatePaths(2, 0, 0));
    }

    @Test
    public void oneA3By3GridSixPathShouldBePossible() {
        assertEquals(6, GridPathsCalculator.calculatePaths(3, 0, 0));
    }

    @Test
    public void oneA4By4GridTwentyPathShouldBePossible() {
        assertEquals(20, GridPathsCalculator.calculatePaths(4, 0, 0));
    }


    @Test
    public void oneA5By5GridSeventyPathShouldBePossible() {
        assertEquals(70, GridPathsCalculator.calculatePaths(5, 0, 0));
    }
}