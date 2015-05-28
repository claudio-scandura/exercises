package exercises.sequences;

import java.util.*;

/**
 * Created by cls on 22/03/15.
 */
public class Sequences {

    public static Set<Integer[]> findSequencesOfConsecutiveNumbers(int[] input) {
        Set<Integer> flattenSequences = new TreeSet<>();
        for (int i : input) flattenSequences.add(i);
        Set<Integer[]> result = new HashSet<>();
        List<Integer> seq = new ArrayList<>();
        Integer previous = null;
        for (Integer i: flattenSequences) {
            if (previous != null && i != 1 + previous) {
                    result.add(seq.toArray(new Integer[seq.size()]));
                    seq.clear();
            }
            seq.add(i);
            previous = i;
        }
        if (!seq.isEmpty()) result.add(seq.toArray(new Integer[seq.size()]));
        return result;
    }
}
