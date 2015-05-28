package exercises.search;

/**
 * Created by cls on 25/02/15.
 */
public class BinarySerch {


    public static int search(int[] in, int item, int begin, int end) {
        if (begin > end || in == null) return -1;
        int mid = (end - begin)/2;
        if (in[mid] == item) return mid;
        if (in[mid] < item) return search(in, item, mid + 1, end);
        return search(in, item, begin, mid -1);
    }

    public static int search(int[] in, int item) {
        if (in == null) return -1;
        int begin = 0, end = in.length, mid = (end - begin)/2;
        while (mid > 0) {
            if (in[mid] == item) return mid;
            if (in[mid] < item) mid = (end - ++mid)/2;
            else mid = (--mid - begin)/2;
        }
        if (in[mid] == item) return mid;
        return -1;
    }
}
