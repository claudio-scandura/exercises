package exercises.graphs;

import java.util.Arrays;

/**
 * Created by cls on 12/03/15.
 */
public class DisjointSets {

    int[] elements;

    public DisjointSets(int size) {
        elements = new int[size];
        Arrays.fill(elements, -1);
    }

    public int find(int i) {
        return (elements[i] == -1) ? i : find(elements[i]);
    }

    public void union(int i, int j) {
        int iParent = find(i);
        int jParent = find(j);
        elements[jParent] = iParent;
    }
}
