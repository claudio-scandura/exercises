package exercises.sumofmultiples;

import org.junit.Assert;
import org.junit.Test;

public class SumOfMultiplesTest {

    @Test
    public void findSumOfMultipleShouldReturn23() {
        Assert.assertEquals(233168, SumOfMultiples.findSumOfMultiplesInADumbWay(1000, 3, 5));
        Assert.assertEquals(233168, SumOfMultiples.findSumOfMultiplesInACleverWay(1000, 3, 5));
    }
}