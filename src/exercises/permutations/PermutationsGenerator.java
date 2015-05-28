package exercises.permutations;

import java.util.HashSet;
import java.util.Set;

/**
 * Generate all the permutations of a string
 */
public class PermutationsGenerator {


    public static Set<String> generatePermutations(String input) {
        Set<String> permutations = new HashSet<String>();
        recursivePermutations(input, "", permutations);
//        iterativePermutations(input, permutations);
        return permutations;

    }

    private static void recursivePermutations(String input, String partialResult, Set<String> permutations) {
        if (input.length() == 0) permutations.add(partialResult);
        for (int i = 0; i < input.length(); i++)
            recursivePermutations(input.substring(0, i) + input.substring(i + 1), partialResult + input.charAt(i), permutations);
    }

    private static void iterativePermutations(String input, Set<String> permutations) {
        String partialResult = "";

        for (int i = 0; i < input.length(); i++) {
            String inputMinusIthChar = input.substring(0, i) + input.substring(i + 1);
            partialResult += input.charAt(i);
            int k = 0;
            while (inputMinusIthChar.length() > 0) {
                partialResult += inputMinusIthChar.charAt(k);
                inputMinusIthChar = inputMinusIthChar.substring(0, k) + inputMinusIthChar.substring(k + 1);
                if (inputMinusIthChar.length() > 0)
                    k = (k +1) % inputMinusIthChar.length();
            }
            permutations.add(partialResult);
        }
    }

}

