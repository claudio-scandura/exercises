package exercises.permutations;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class PermutationsGeneratorTest {

    @Test
    public void shouldReturnOnePermutationIfInputHasSize1() {
        Set<String> result = PermutationsGenerator.generatePermutations("a");
        Assert.assertEquals(1, result.size());
        Set<String> expectedResult = new HashSet<String>();
        expectedResult.add("a");
        containsAllPermutations(expectedResult, result);
    }

    @Test
    public void shouldReturnTwoPermutationIfInputHasSize2() {
        Set<String> result = PermutationsGenerator.generatePermutations("ab");
        Assert.assertEquals(2, result.size());

        Set<String> expectedResult = new HashSet<String>();
        expectedResult.add("ab");
        expectedResult.add("ba");
        containsAllPermutations(expectedResult, result);
    }

    @Ignore
    public void shouldReturn2TwoPermutationIfInputHasSize2() {
        Set<String> result = PermutationsGenerator.generatePermutations("if I have a quite long sentence");
    }

    @Test
    public void shouldReturnSixPermutationIfInputHasSize3() {
        Set<String> result = PermutationsGenerator.generatePermutations("sun");
        Assert.assertEquals(6, result.size());

        Set<String> expectedResult = new HashSet<String>();
        expectedResult.add("sun");
        expectedResult.add("usn");
        expectedResult.add("uns");
        expectedResult.add("snu");
        expectedResult.add("nus");
        expectedResult.add("nsu");
        containsAllPermutations(expectedResult, result);
    }

    private static void containsAllPermutations(Set<String> expected, Set<String> actual) {
        for (String permutation: expected) {
            if (!actual.contains(permutation)) Assert.fail("["+ permutation + "] was not found");
        }
    }
}