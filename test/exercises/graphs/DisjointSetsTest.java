package exercises.graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class DisjointSetsTest {

    @Test
    public void findShouldReturnIndexIfItDoesNotBelongToAnotherSet() {
        DisjointSets ds = new DisjointSets(10);
        assertEquals(6, ds.find(6));
        assertEquals(9, ds.find(9));
        assertEquals(8, ds.find(8));
        assertEquals(5, ds.find(5));
        assertEquals(0, ds.find(0));
    }

    @Test
    public void findShouldReturnParentIfIndexWasAddedToOtherSet() {
        DisjointSets ds = new DisjointSets(10);
        ds.union(3, 7);

        assertEquals(3, ds.find(7));
        assertEquals(3, ds.find(3));
    }

}