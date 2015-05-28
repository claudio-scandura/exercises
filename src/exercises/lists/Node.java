package exercises.lists;

/**
 * Created by cls on 08/03/15.
 */
public class Node<T> {

    T val;

    Node<T> next;

    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }

    protected Node<T> find(T val) {
        if (this.val.equals(val)) return this;
        if (this.next == null) return null;
        return this.next.find(val);
    }
}
