package exercises.search;

import org.junit.Assert;
import org.junit.Test;

public class BinarySerchTest {

    @Test
    public void shouldReturnNegativeIfArrayDoesNotContainNumber() {
        int[] input = null;
        int result = BinarySerch.search(input, 1, 0, 23);
        Assert.assertEquals(-1, result);
        result = BinarySerch.search(input, 1);
        Assert.assertEquals(-1, result);

        input = new int[1];
        input[0]=2;
        result = BinarySerch.search(input, 1, 0, input.length);
        Assert.assertEquals(-1, result);
        result = BinarySerch.search(input, 1);
        Assert.assertEquals(-1, result);

        input = new int[2];
        input[0]=2;
        input[1]=3;
        result = BinarySerch.search(input, 1, 0, input.length);
        Assert.assertEquals(-1, result);
        result = BinarySerch.search(input, 1);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void shouldReturnIndexOfNumbeInArrayIfFound() {
        int[] input = new int[2];
        input[0]=2;
        input[1]=3;
        int result = BinarySerch.search(input, 3, 0, input.length);
        Assert.assertEquals(1, result);
        result = BinarySerch.search(input, 3);
        Assert.assertEquals(1, result);


        input = new int[3];
        input[0]=2;
        input[1]=3;
        input[2]=24;
        result = BinarySerch.search(input, 2, 0, input.length);
        Assert.assertEquals(0, result);
        result = BinarySerch.search(input, 2);
        Assert.assertEquals(0, result);
    }

}