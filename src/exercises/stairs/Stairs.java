package exercises.stairs;

/**
 * Created by cls on 03/03/15.
 */
public class Stairs {



    public static void main(String args[]) {
        wtf(3);
    }

    static void wtf(int s) {
        for (int i = 1; i <= s; i++) {
            int diff = (s % 2 == 0 ) ? 0 : 1;

            int k = i/2;
            while (k >= 1) {
                System.out.print("2");
                k /= 2; diff++;
            }
            if (s % 2 != 0 || i > 1) {
                whatever(s - diff);
            }
            System.out.println();
        }
    }
    private static void whatever(int s) {
        while (s > 0) {
            System.out.print(1);
            s--;
        }
    }

}
