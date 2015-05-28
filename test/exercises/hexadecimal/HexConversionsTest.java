package exercises.hexadecimal;

import org.junit.Test;

import static org.junit.Assert.*;

public class HexConversionsTest {

    @Test
    public void shouldConvertToHexFromDecimal() {
        assertEquals("F", HexConversions.decimalToHex(15));

        assertEquals(Integer.toHexString(32).toUpperCase(), HexConversions.decimalToHex(32));
        assertEquals(Integer.toHexString(123).toUpperCase(), HexConversions.decimalToHex(123));
        assertEquals(Integer.toHexString(564729).toUpperCase(), HexConversions.decimalToHex(564729));
    }

    @Test
    public void shouldConvertToDecimalFromHex() {
        assertEquals(10, HexConversions.hexToDecimal("A"));
        assertEquals(997957, HexConversions.hexToDecimal("F3A45"));
        assertEquals(2735, HexConversions.hexToDecimal("AAF"));
    }

}