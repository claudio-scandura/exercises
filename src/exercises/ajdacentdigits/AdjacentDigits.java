package exercises.ajdacentdigits;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;

/**
 * Created by cls on 01/03/15.
 */
public class AdjacentDigits {

   public static int[] findAdjacentDigitsWithHighestProduct(int digitsAmount, String input) {
       Long max = 0L, productAccumulator;
       int[] result = null;
       for (int i = 0; i + digitsAmount < input.length(); i++) {
           int[] substringAsIntegers = parseDigits(input.substring(i, i + digitsAmount));
           productAccumulator = 1L;
           for (int k = 0; k < digitsAmount; productAccumulator *= substringAsIntegers[k++]);
           if (productAccumulator > max) {
               max = productAccumulator;
               result = substringAsIntegers;
           }
       }
       return result;
   }

    public static int[] findAdjacentDigitsWithHighestProductOptimised(int digitsAmount, String input) {
        Long productAccumulator = 1L, max =0L;
        int[] result = new int[digitsAmount];
        int resultLeftIndex = 0;
        int[] inputAsIntegers = parseDigits(input);

        boolean reductionNeeded = true;
        for (int i = 0; i + digitsAmount < inputAsIntegers.length; i++) {
            int tmp = 1;
            for (int k = i; k < digitsAmount + i; k++) {
                tmp *= inputAsIntegers[k];
            }

            if (reductionNeeded) {
                for (int k = i; k < digitsAmount + i; k++) {
                    productAccumulator *= inputAsIntegers[k];
                }
            } else {
                productAccumulator *= inputAsIntegers[i + digitsAmount - 1];
            }

            if (productAccumulator.compareTo(max) > 0) {
                max = productAccumulator;
                resultLeftIndex = i;
            }

            if (productAccumulator > 0 && inputAsIntegers[i] > 0) {
                productAccumulator /= inputAsIntegers[i];
                reductionNeeded = false;
            } else {
                productAccumulator = 1L;
                reductionNeeded = true;
            }

        }
        System.arraycopy(inputAsIntegers, resultLeftIndex, result, 0, digitsAmount);
        return result;
    }

    private static int[] parseDigits(String input) {
        int[] result = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            result[i] = Integer.parseInt(Character.toString(input.charAt(i)));
        }
        return result;
    }
}
