package exercises.largestpalindrome;

import org.junit.Assert;
import org.junit.Test;

public class LargestPalindromeTest {

    @Test
    public void shouldFindTheLargestPalindromMadeFromTheProductOfTwo2DigitsNumbers() {
        Assert.assertEquals(9009, LargestPalindrome.findLargestPalindrome(2));
    }

    @Test
    public void shouldFindTheLargestPalindromMadeFromTheProductOfTwo3DigitsNumbers() {
        Assert.assertEquals(90909, LargestPalindrome.findLargestPalindrome(3));
    }
}