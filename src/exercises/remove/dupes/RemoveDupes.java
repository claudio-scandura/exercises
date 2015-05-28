package exercises.remove.dupes;

/**
 * Created by cls on 23/02/15.
 */
public class RemoveDupes {

    //removes duplicate characters from array without using additional data structure a part from 1 or two variables
// Assumptions: string comes in as an array of characters
//              the first occurrence of a character C will remain in the string whilst the others will be replaced with a blank space
//              blank space will be ignored
    public static String removeDupes(char[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] == input[i])
                    input[j] = ' ';
            }
        }
        return new String(input);
    }
}
