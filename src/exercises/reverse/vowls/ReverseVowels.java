package exercises.reverse.vowls;

/**
 * Created by cls on 22/02/15.
 * Given a string S write a function that returns S where all the vowels have been reversed.
 * <p/>
 * i.e. S = "Hello World" => "Hollo Werld"
 */
public class ReverseVowels {

    /**
     * Simple and intuitive implementation.
     * Stores all the vowels into a string and uses them to rebuild the output accordingly
     */
    public static String reverse(String input) {
        String output = "";
        String vowels = "";

        for (char c : input.toCharArray())
            vowels += isVowel(c) ? c : "";

        for (int i = 0, j = vowels.length() - 1; i < input.length(); i++)
            output += isVowel(input.charAt(i)) ? vowels.charAt(j--) : input.charAt(i);

        return output;
    }

    /**
     * Reverses the vowels in a single loop.
     * Scans the string from the beginning and end towards the centre and swaps the vowels where needed
     */
    public static String reverseInOneLoop(String input) {
        char[] output = new char[input.length()];
        int leftIndex = 0, rightIndex = input.length() - 1;
        while (leftIndex <= rightIndex) {
            boolean leftIsVowel = isVowel(input.charAt(leftIndex));
            boolean rightIsVowel = isVowel(input.charAt(rightIndex));
            if (leftIsVowel && rightIsVowel) {
                output[leftIndex] = input.charAt(rightIndex);
                output[rightIndex--] = input.charAt(leftIndex++);
            } else if (leftIsVowel && !rightIsVowel) {
                output[rightIndex] = input.charAt(rightIndex--);
            } else if (!leftIsVowel && rightIsVowel) {
                output[leftIndex] = input.charAt(leftIndex++);
            } else {
                output[leftIndex] = input.charAt(leftIndex++);
                output[rightIndex] = input.charAt(rightIndex--);
            }
        }


        return new String(output);
    }

    public static String recursiveReverse(String input) {
        return recursiveReverse(input, 0, input.length() - 1);
    }

    /**
     * Recursive implementation.
     * Uses the same conditions applied in the reverseInOneLoop algorithm to recursively build the result
     */
    private static String recursiveReverse(String input, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) return "";

        char leftChar = input.charAt(leftIndex);
        char rightChar = input.charAt(rightIndex);
        boolean leftIsVowel = isVowel(leftChar);
        boolean rightIsVowel = isVowel(rightChar);

        if (leftIndex == rightIndex) return Character.toString(leftChar);

        if (leftIsVowel && rightIsVowel)
            return rightChar + recursiveReverse(input, leftIndex + 1, rightIndex - 1) + leftChar;

        if (leftIsVowel && !rightIsVowel)
            return recursiveReverse(input, leftIndex, rightIndex - 1) + rightChar;

        if (!leftIsVowel && rightIsVowel)
            return leftChar + recursiveReverse(input, leftIndex + 1, rightIndex);

        return leftChar + recursiveReverse(input, leftIndex + 1, rightIndex - 1) + rightChar;
    }

    private static boolean isVowel(char c) {
        char lowerCased = Character.toLowerCase(c);
        return lowerCased == 'a' || lowerCased == 'e' || lowerCased == 'i' || lowerCased == 'o' || lowerCased == 'u' || lowerCased == 'y';
    }
}
