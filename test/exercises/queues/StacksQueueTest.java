package exercises.queues;

import org.junit.Test;

import static org.junit.Assert.*;

public class StacksQueueTest {

    @Test
    public void emptyQueueShouldHazeSizeZero() {
        StacksQueue queue = new StacksQueue();
        assertEquals(0, queue.size());
    }

    @Test
    public void enqueueAnElementShouldIncreaseSize() {
        StacksQueue queue = new StacksQueue();
        assertEquals(0, queue.size());

        queue.enqueue(1);
        assertEquals(1, queue.size());
    }

    @Test(expected = RuntimeException.class)
    public void dequeueElementFromEmptyQueueShouldThrowException() {
        StacksQueue queue = new StacksQueue();
        queue.dequeue();
    }

    @Test
    public void dequeueElementFromQueueOfSizeOneShouldRemoveAndReturnLoneElement() {
        StacksQueue queue = new StacksQueue();
        queue.enqueue(34);

        assertEquals(new Integer(34), queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void dequeueElementFromQueueOfSizeTwoShouldRemoveAndReturnElementWhichHasBeenInTheQueueTheLongest() {
        StacksQueue queue = new StacksQueue();
        queue.enqueue(34);
        queue.enqueue(43);

        assertEquals(new Integer(34), queue.dequeue());
        assertEquals(1, queue.size());
    }

}