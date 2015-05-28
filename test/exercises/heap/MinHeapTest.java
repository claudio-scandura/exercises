package exercises.heap;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MinHeapTest {

    @Test
    public void enqueueShouldAddElementToEmptyHeap() {
        MinHeap heap = new MinHeap();

        assertEquals(3, heap.enqueue(3));

        assertEquals(3, heap.array[0]);
        assertEquals(1, heap.size);
    }

    @Test
    public void enqueueShouldAddLeftElementToNonEmptyHeapWithNoBubblingUpRequired() {
        MinHeap heap = new MinHeap();

        assertEquals(3, heap.enqueue(3));
        assertEquals(10, heap.enqueue(10));

        assertTrue(heap.array[1] == 10);
        assertEquals(2, heap.size);
    }


    @Test
    public void enqueueShouldAddRighElementToNonEmptyHeapWithNoBubblingUpRequired() {
        MinHeap heap = new MinHeap();

        assertEquals(3, heap.enqueue(3));
        assertEquals(10, heap.enqueue(10));
        assertEquals(9, heap.enqueue(9));

        assertEquals(9, heap.array[2]);
        assertEquals(3, heap.size);
    }

    @Test
    public void enqueueShouldAddElementAndBubbleItUp() {
        MinHeap heap = new MinHeap();

        assertEquals(3, heap.enqueue(3));
        assertEquals(10, heap.enqueue(10));
        assertEquals(9, heap.enqueue(9));
        assertEquals(4, heap.enqueue(4));

        assertEquals(4, heap.size);
        assertEquals(3, heap.array[0]);
        assertEquals(4, heap.array[1]);
        assertEquals(9, heap.array[2]);
        assertEquals(10, heap.array[3]);
    }

    @Test
    public void enqueueShouldAddElementAndBubbleItUpToTheRoot() {
        MinHeap heap = new MinHeap();

        assertEquals(3, heap.enqueue(3));
        assertEquals(10, heap.enqueue(10));
        assertEquals(9, heap.enqueue(9));
        assertEquals(2, heap.enqueue(2));

        assertEquals(4, heap.size);
        assertEquals(2, heap.array[0]);
        assertEquals(3, heap.array[1]);
        assertEquals(9, heap.array[2]);
        assertEquals(10, heap.array[3]);
    }

    @Test
    public void dequeueShouldReturnRootAndNeedNoBubblingDown() {
        MinHeap heap = new MinHeap();

        assertEquals(3, heap.enqueue(3));
        assertEquals(3, heap.enqueue(3));
        assertEquals(3, heap.enqueue(3));
        assertEquals(3, heap.enqueue(3));

        assertEquals(3, heap.dequeue());

        assertEquals(3, heap.size);
        assertEquals(3, heap.array[0]);
        assertEquals(3, heap.array[1]);
        assertEquals(3, heap.array[2]);
    }

    @Test
    public void dequeueShouldReturnRootAndBubbleDown() {
        MinHeap heap = new MinHeap();

        assertEquals(3, heap.enqueue(3));
        assertEquals(10, heap.enqueue(10));
        assertEquals(9, heap.enqueue(9));
        assertEquals(4, heap.enqueue(4));

        assertEquals(3, heap.dequeue());

        assertEquals(3, heap.size);
        assertEquals(4, heap.array[0]);
        assertEquals(10, heap.array[1]);
        assertEquals(9, heap.array[2]);
    }

    @Test
    public void toSortedArrayShouldReturnArraySortedInDescendingOrder() {
        MinHeap heap = new MinHeap();

        assertEquals(3, heap.enqueue(3));
        assertEquals(10, heap.enqueue(10));
        assertEquals(9, heap.enqueue(9));
        assertEquals(4, heap.enqueue(4));

        int[] expectedResult = {3, 4, 9, 10};
        assertArrayEquals(expectedResult, heap.toSortedArray());
    }

    @Test
    public void bottomUpHeapShouldConstructHeapFromSimpleArray() {
        int[] input = {7, 24, 4};
        int[] expected = {24, 7, 4};
        int[] result = MinHeap.bottomUpMaxHeap(input);
        assertTrue(MinHeap.isMaxHeap(result));
        assertArrayEquals(expected, MinHeap.bottomUpMaxHeap(input));
    }

    @Test
    public void bottomUpHeapShouldConstructHeapFromLongArray() {
        int[] input = {1, 2, 2, 3, 5, 5, 5, 6, 7, 23};
        int[] result = MinHeap.bottomUpMaxHeap(input);
        assertTrue(MinHeap.isMaxHeap(result));
    }

}