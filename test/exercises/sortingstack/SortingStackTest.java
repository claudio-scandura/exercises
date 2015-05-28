package exercises.sortingstack;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class SortingStackTest {

    @Test
    public void sortEmptyStackShouldDoNothing() {
        Stack<Integer> input = new Stack<Integer>();
        SortingStack.sortStack(input);

        assertTrue(input.isEmpty());
    }


    @Test
    public void sortStackOfSizeOneShouldDoNothing() {
        Stack<Integer> input = new Stack<Integer>();
        input.push(23);

        SortingStack.sortStack(input);

        assertEquals(new Integer(23), input.pop());
        assertTrue(input.isEmpty());
    }

    @Test
    public void sortStackShouldWorkForStackOfSizeTwo() {
        Stack<Integer> input = new Stack<Integer>();
        input.push(23);
        input.push(33);

        SortingStack.sortStack(input);

        assertEquals(new Integer(23), input.pop());
        assertEquals(new Integer(33), input.pop());
        assertTrue(input.isEmpty());
    }

    @Test
    public void sortStackShouldWorkForStackOfSizeGreaterThanTwo() {
        Stack<Integer> input = new Stack<Integer>();
        input.push(23);
        input.push(33);
        input.push(15);
        input.push(16);
        input.push(90);

        SortingStack.sortStack(input);

        assertEquals(new Integer(15), input.pop());
        assertEquals(new Integer(16), input.pop());
        assertEquals(new Integer(23), input.pop());
        assertEquals(new Integer(33), input.pop());
        assertEquals(new Integer(90), input.pop());
        assertTrue(input.isEmpty());
    }
}