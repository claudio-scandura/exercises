package exercises.lists;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void shouldAddElementToEmptyList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertEquals(new Integer(30), list.add(30));
        assertEquals(1, list.size);
        assertNotNull(list.head);
        assertEquals(new Integer(30), list.head.val);
        assertNull(list.head.next);
    }

    @Test
    public void shouldAddElementOnTopOfNonEmptyList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.head = new Node<Integer>(23, null);
        list.size++;

        assertEquals(new Integer(30), list.add(30));
        assertEquals(2, list.size);
        assertNotNull(list.head);
        assertEquals(new Integer(30), list.head.val);
        assertNotNull(list.head.next);
        assertEquals(new Integer(23), list.head.next.val);
        assertNull(list.head.next.next);
    }

    @Test
    public void shouldRemoveFirstOccurrenceOfElementInList() {
        LinkedList<Integer> list = LinkedList.createList(4, 4, 3);

        Integer removed = list.remove(4);

        assertNotNull(removed);
        assertEquals(new Integer(4), removed);
        assertEquals(2, list.size);
        assertEquals(new Integer(3), list.head.val);
        assertNotNull(list.head.next);
        assertEquals(new Integer(4), list.head.next.val);
        assertNull(list.head.next.next);
    }

    @Test
    public void shouldReturnNullIfElementToRemoveDoesNotExistInList() {
        LinkedList<Integer> list = LinkedList.createList(4, 4, 3);

        Integer removed = list.remove(5);

        assertNull(removed);
        assertEquals(3, list.size);
    }

    @Test
    public void shouldReturnNullIfListIsEmpty() {
        LinkedList<Integer> list = new LinkedList<Integer>();

        Integer removed = list.remove(5);

        assertNull(removed);
        assertEquals(0, list.size);
    }

    @Test
    public void shouldReturnAndRemoveOnlyElementOftheList() {
        LinkedList<Integer> list = LinkedList.createList(3);

        Integer removed = list.remove(3);

        assertNotNull(removed);
        assertEquals(new Integer(3), removed);
        assertEquals(0, list.size);
    }

    @Test
    public void shouldFindFirstOccurrenceOfElementInList() {
        LinkedList<Integer> list = LinkedList.createList(4, 4, 3);

        Node<Integer> found = list.find(4);

        assertNotNull(found);
        assertEquals(new Integer(4), found.val);
        assertEquals(new Integer(4), found.next.val);
    }

    @Test
    public void shouldReturnNullIfListIsEmptyWhenFindingElement() {
        LinkedList<Integer> list = new LinkedList();

        Node<Integer> found = list.find(4);

        assertNull(found);
    }


    @Test
    public void shouldReturnNullIfSearchedElementISnotInTheList() {
        LinkedList<Integer> list = LinkedList.createList(4, 4, 3);

        Node<Integer> found = list.find(23);

        assertNull(found);
    }

    @Test
    public void iteratorShouldConsumeAllElementsAndNotModifyList() {
        LinkedList<Integer> list = LinkedList.createList(4, 4, 3);

        Iterator<Node<Integer>> iterator = list.iterator();

        assertNotNull(iterator);
        assertTrue(iterator.hasNext());

        assertEquals(new Integer(3), iterator.next().val);
        assertTrue(iterator.hasNext());

        assertEquals(new Integer(4), iterator.next().val);
        assertTrue(iterator.hasNext());

        assertEquals(new Integer(4), iterator.next().val);
        assertFalse(iterator.hasNext());

        assertEquals(3, list.size);
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratingOnEmptyLsitShouldThrowException() {
        LinkedList<Integer> list = LinkedList.createList(4);

        Iterator<Node<Integer>> iterator = list.iterator();

        iterator.next();
        iterator.next();
    }
}