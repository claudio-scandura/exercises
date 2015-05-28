package exercises.largestpalindrome;

import java.util.Arrays;

/**
 * Created by cls on 01/03/15.
 */
public class LargestPalindrome {

    public static int findLargestPalindrome(int numOfDigits) {
        int x = getLargestInt(numOfDigits);
        int y = x;
        int product;
        do {
            product = x * y;
            y--;
        } while (!isPalindrome(product) && y >= 0);
        System.out.println(x+ " " + y+1);
        return product;
    }

    private static int getLargestInt(int numOfDigits) {
        char[] nines = new char[numOfDigits];
        Arrays.fill(nines, '9');
        return Integer.parseInt(new String(nines));
    }

    private static boolean isPalindrome(int number) {
        String numberAsAString = Integer.toString(number);
        for (int j = 0, k = numberAsAString.length() - 1; j <= k; j++, k--) {
            if (numberAsAString.charAt(j) != numberAsAString.charAt(k))
                return false;
        }
        return true;
    }

}
