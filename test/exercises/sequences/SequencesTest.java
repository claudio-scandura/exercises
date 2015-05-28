package exercises.sequences;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class SequencesTest {

    @Test
    public void findSubSequenceShouldReturnEmptySetIfInputArrayIsEmpty() {
        Set<Integer[]> result =  Sequences.findSequencesOfConsecutiveNumbers(new int[0]);

        assertTrue(result.isEmpty());
    }


    @Test
    public void findSubSequenceShouldReturnSequencesOfSizeOneIfInputDoesNotContainConsecutiveNumbers() {
        int[] input = {23, 54, 98, 34};
        Set<Integer[]> result =  Sequences.findSequencesOfConsecutiveNumbers(input);

        Integer[] expected1 = {23};
        Integer[] expected2 = {54};
        Integer[] expected3 = {98};
        Integer[] expected4 = {34};

        assertEquals(4, result.size());
        checkSequenceExists(expected1, result);
        checkSequenceExists(expected2, result);
        checkSequenceExists(expected3, result);
        checkSequenceExists(expected4, result);
    }

    @Test
    public void findSubSequenceShouldReturnSequencesOfConsecutiveNumbersIfInputContainConsecutiveNumbers() {
        int[] input = {23, 54, 98, 24, 25, 34, 99};
        Set<Integer[]> result =  Sequences.findSequencesOfConsecutiveNumbers(input);

        Integer[] expected1 = {23, 24, 25};
        Integer[] expected2 = {54};
        Integer[] expected3 = {98, 99};
        Integer[] expected4 = {34};

        assertEquals(4, result.size());
        checkSequenceExists(expected1, result);
        checkSequenceExists(expected2, result);
        checkSequenceExists(expected3, result);
        checkSequenceExists(expected4, result);
    }

    private void checkSequenceExists(Integer[] expectedSequence, Set<Integer[]> resultSet) {
        for (Integer[] result: resultSet) {
            if (Arrays.equals(result, expectedSequence)) return;
        }
        fail("Sequence: " + Arrays.toString(expectedSequence) + " does not exist in " + resultSetToString(resultSet));
    }

    private String resultSetToString(Set<Integer[]> result) {
        String res = "";
        for (Integer[] array: result) res += Arrays.toString(array);
        return res;
    }

}