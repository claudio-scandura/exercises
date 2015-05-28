package exercises.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindIndexesTest {

    @Test
    public void findIndexesShouldReturnThreeFiveAndZero() {
        int[] input = {12, 2, 23, 8, 3, 4};

        assertArrayEquals(new int[]{5, 3, 0}, FindIndexes.find(input));
    }

    @Test
    public void findIndexesShouldReturnOneTwoThree() {
        int[] input = {120, 2, 3, 5, 900, 23, 200, -45, 10000, 19696968, 349, -435, -19000};

        assertArrayEquals(new int[]{1, 2, 3}, FindIndexes.find(input));
    }

    @Test
    public void findIndexesShouldReturnMinusOnesIfTheIndexesDoNotExist() {
        int[] input = {-90, 50, 23, 8, 3, 4};

        assertArrayEquals(new int[]{-1, -1 ,-1}, FindIndexes.find(input));
    }


}