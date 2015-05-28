package exercises.lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by cls on 08/03/15.
 */
public class LinkedList<T> {
    Node<T> head;
    long size;

    public static <T> LinkedList<T> createList(T ...elements) {
        LinkedList<T> result = new LinkedList<>();
        for (T element: elements) result.add(element);
        return result;
    }

    public T add(T element) {
        Node<T> node = new Node<T>(element, null);
        node.next = head;
        head = node;
        size++;
        return element;
    }

    public T remove(T element) {
        Node<T> next = head, previous = head;
        while (next != null && !next.val.equals(element)) {
            next = next.next;
            if (previous != head) previous = previous.next;
        }
        if (next == null) return null;
        previous.next = next.next;
        size--;
        return next.val;
    }

    public Node<T> find(T element) {
        if (head != null) return head.find(element);
        return null;
    }

    public Iterator<Node<T>> iterator() {
        return new Iterator<Node<T>> () {

            Node<T> current = head;

            @Override
            public boolean hasNext() {
                 return current != null;
            }

            @Override
            public Node<T> next() {
                if (!hasNext()) throw new NoSuchElementException();
                Node<T> result = current;
                current = current.next;
               return  result;
            }

            @Override
            public void remove() {
                if (current != null) {
                    LinkedList.this.remove(current.val);
                }
            }

        };
    }

}
