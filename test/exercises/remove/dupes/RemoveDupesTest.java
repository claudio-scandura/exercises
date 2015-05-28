package exercises.remove.dupes;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cls on 23/02/15.
 */
public class RemoveDupesTest {

    @Test
    public void shouldRemoveDuplicateCharactersInRandomString() {
        String input = "abbcadc";
        String result = RemoveDupes.removeDupes(input.toCharArray());
        Assert.assertEquals("ab c d ", result);
    }

    @Test
    public void shouldRemoveDuplicateCharactersIgnoringWhiteSpaces() {
        String input = "abbc dc";
        String result = RemoveDupes.removeDupes(input.toCharArray());
        Assert.assertEquals("ab c d ", result);
    }

    @Test
    public void shouldDoNothingIfStringIsEmpty() {
        String input = "";
        String result = RemoveDupes.removeDupes(input.toCharArray());
        Assert.assertEquals("", result);
    }
}
