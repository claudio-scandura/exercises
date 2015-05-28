package exercises.hexadecimal;

/**
 * Created by cls on 14/03/15.
 */
public class HexConversions {

    public static String decimalToHex(int n) {
        String result = "";
        while (n > 0) {
            result  = mapNumToHex(n%16) + result;
            n /= 16;
        }
        return result;
    }

    private static String mapNumToHex(int k) {
        if (k <= 9) return Integer.toString(k);
        switch (k) {
            case 10 : return "A";
            case 11 : return "B";
            case 12 : return "C";
            case 13 : return "D";
            case 14 : return "E";
            case 15 : return "F";
            default : throw new IllegalArgumentException("number to map to hex must be in interval [0, 15].");
        }
    }

    public static int hexToDecimal(String hex) {
        int result = 0, k = 0;
        for (int i = hex.length() - 1; i >= 0; i--) {
            int ithValue = mapHexToNum(hex.charAt(i));
            result += ithValue * Math.pow(16, k++);
        }
        return result;
    }

    private static int mapHexToNum(char hex) {
        int result = Character.getNumericValue(hex);
        if (result != -1) return result;
        switch (hex) {
            case 'A': return 10;
            case 'B': return 11;
            case 'C': return 12;
            case 'D': return 13;
            case 'E': return 14;
            case 'F': return 15;
            default : throw new IllegalArgumentException("hex is not a valid hexadecimal number");
        }
    }
}
