package exercises.reverse.vowls;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cls on 22/02/15.
 */
public class ReverseVowelsTest {

    @Test
    public void shouldDoNothingIfStringIsEmpty() {
        Assert.assertEquals("Simple reverse", "", ReverseVowels.reverse(""));
        Assert.assertEquals("Simple reverse", "  ", ReverseVowels.reverse("  "));

        Assert.assertEquals("Reverse in one loop", "", ReverseVowels.reverseInOneLoop(""));
        Assert.assertEquals("Reverse in one loop", "  ", ReverseVowels.reverseInOneLoop("  "));

        Assert.assertEquals("Recursive reverse", "", ReverseVowels.recursiveReverse(""));
        Assert.assertEquals("Recursive reverse", "  ", ReverseVowels.recursiveReverse("  "));
    }

    @Test
    public void shouldDoNothingIfStringDoesNotContainVowels() {
        Assert.assertEquals("Simple reverse", "strwthnvwls", ReverseVowels.reverse("strwthnvwls"));
        Assert.assertEquals("Simple reverse", "str wth n vwls", ReverseVowels.reverse("str wth n vwls"));

        Assert.assertEquals("Reverse in one loop", "strwthnvwls", ReverseVowels.reverseInOneLoop("strwthnvwls"));
        Assert.assertEquals("Reverse in one loop", "str wth n vwls", ReverseVowels.reverseInOneLoop("str wth n vwls"));

        Assert.assertEquals("Recursive reverse", "strwthnvwls", ReverseVowels.recursiveReverse("strwthnvwls"));
        Assert.assertEquals("Recursive reverse", "str wth n vwls", ReverseVowels.recursiveReverse("str wth n vwls"));
    }

    @Test
    public void shouldDoNothingIfStringContainsOneVowlOnly() {
        Assert.assertEquals("Simple reverse", "strwathnvwls", ReverseVowels.reverse("strwathnvwls"));
        Assert.assertEquals("Simple reverse", "str wath n vwls", ReverseVowels.reverse("str wath n vwls"));

        Assert.assertEquals("Reverse in one loop", "strwathnvwls", ReverseVowels.reverseInOneLoop("strwathnvwls"));
        Assert.assertEquals("Reverse in one loop", "str wath n vwls", ReverseVowels.reverseInOneLoop("str wath n vwls"));

        Assert.assertEquals("Recursive reverse", "strwathnvwls", ReverseVowels.recursiveReverse("strwathnvwls"));
        Assert.assertEquals("Recursive reverse", "str wath n vwls", ReverseVowels.recursiveReverse("str wath n vwls"));
    }

    @Test
    public void shouldSwapTwoVowelsInAString() {
        Assert.assertEquals("Simple reverse", "stro wat hin vwls", ReverseVowels.reverse("stri wat hon vwls"));

        Assert.assertEquals("Reverse in one loop", "stro wat hin vwls", ReverseVowels.reverseInOneLoop("stri wat hon vwls"));

        Assert.assertEquals("Recursive reverse", "stro wat hin vwls", ReverseVowels.recursiveReverse("stri wat hon vwls"));
    }

    @Test
    public void shouldSwapFourVowelsInAString() {
        Assert.assertEquals("Simple reverse", "stre wot han vwils", ReverseVowels.reverse("stri wat hon vwels"));

        Assert.assertEquals("Reverse in one loop", "stre wot han vwils", ReverseVowels.reverseInOneLoop("stri wat hon vwels"));

        Assert.assertEquals("Recursive reverse", "stre wot han vwils", ReverseVowels.recursiveReverse("stri wat hon vwels"));
    }

    @Test
    public void shouldReverseThreeVowelsInAString() {
        Assert.assertEquals("Simple reverse", "strawithnvwls", ReverseVowels.reverse("striwathnvwls"));

        Assert.assertEquals("Reverse in one loop", "strawithnvwls", ReverseVowels.reverseInOneLoop("striwathnvwls"));

        Assert.assertEquals("Recursive reverse", "strawithnvwls", ReverseVowels.recursiveReverse("striwathnvwls"));
    }

    @Test
    public void shouldReverseWholeStringIfItContainsVowelsOnly() {
        Assert.assertEquals("Simple reverse", "uoiea", ReverseVowels.reverse("aeiou"));
        Assert.assertEquals("Simple reverse", "uoieua", ReverseVowels.reverse("aueiou"));

        Assert.assertEquals("Reverse in one loop", "uoiea", ReverseVowels.reverseInOneLoop("aeiou"));
        Assert.assertEquals("Recursive reverse", "uoieua", ReverseVowels.recursiveReverse("aueiou"));

        Assert.assertEquals("Reverse in one loop", "uoiea", ReverseVowels.reverseInOneLoop("aeiou"));
        Assert.assertEquals("Recursive reverse", "uoieua", ReverseVowels.recursiveReverse("aueiou"));
    }

    @Test
    public void shouldReverseVowelsInRandomString() {
        String input = "  This Is a complEtely random string ";
        //i I a o E e y a o i => i o a y e E o a I i
        String expectedOutput = "  This os a cympletElo randIm string ";

        Assert.assertEquals("Simple reverse", expectedOutput, ReverseVowels.reverse(input));

        Assert.assertEquals("Reverse in one loop", expectedOutput, ReverseVowels.reverseInOneLoop(input));

        Assert.assertEquals("Recursive reverse", expectedOutput, ReverseVowels.recursiveReverse(input));
    }

    @Test
    public void shouldReverseIfTwoVowlesAndOneIsInTheMiddle() {
        String input = "gaekb";
        String expectedOutput = "geakb";

        Assert.assertEquals("Simple reverse", expectedOutput, ReverseVowels.reverse(input));

        Assert.assertEquals("Reverse in one loop", expectedOutput, ReverseVowels.reverseInOneLoop(input));

        Assert.assertEquals("Recursive reverse", expectedOutput, ReverseVowels.recursiveReverse(input));
    }

}
