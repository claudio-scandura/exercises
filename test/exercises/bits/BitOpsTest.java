package exercises.bits;

import org.junit.Assert;
import org.junit.Test;

public class BitOpsTest {

    @Test
    public void shouldMultiplyByTwo() {
        int val = 'a';

        System.out.println(val + " " + getBits(val));
        int result = val << 1;
        System.out.println(result + " " + getBits(result));
        Assert.assertEquals(194, result);

    }

    @Test
    public void shouldDivideByTwo() {
        int val = 'a';

        int result = val >> 1;
        System.out.println(result + " " + getBits(result));
        Assert.assertEquals(48, result);
    }

    @Test
    public void shouldOverflowIfShiftedEnough(){
        int c = getDecimal("00000001");

        System.out.println(getBits(c));
        int result = c << 30;
        Assert.assertEquals((int) Math.pow(2, 30), result);
        System.out.println(result);
        result = c << 35;
        System.out.println("hello " +getBits(result));
    }


    @Test
    public void shouldConvertBitsToDecimal() {
        Assert.assertEquals(97, getDecimal("1100001"));
        Assert.assertEquals(194, getDecimal("11000010"));
    }

    public static String getBits(int val) {
        String result = "";
        while (val > 0) {
            result = val % 2 + result;
            val /= 2;
        }
        return result;
    }

    public static int getDecimal(String bits) {
        int power = 0;
        int result = 0;
        for (int i = bits.length() - 1; i >= 0; i--) {
            if (bits.charAt(i) == '1') {
                result += Math.pow(2, power);
            }
            power++;
        }
        return result;
    }

}
