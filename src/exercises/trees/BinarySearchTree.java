package exercises.trees;

/**
 * Created by cls on 09/03/15.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    int size;
    BinarySearchTreeNode<T> root;

    public BinarySearchTree<T> add(T key) {
        if (root == null) {
            root = new BinarySearchTreeNode<T>(key);
            size++;
            return this;
        }
        if (!root.exists(key)) {
            BinarySearchTreeNode<T> newNode = root.addChild(key);
            root = newNode.balance();
            size++;
        }
        return this;
    }

    public T find(T key) {
        BinarySearchTreeNode<T> found = root.find(key);
        if (found != null) return found.key;
        return null;
    }

    public boolean isBST() {return root.isBST();}

    public void remove(T key) {
        root = root.remove(key);
    }

    public boolean isBalanced() { return root.isBalanced(); }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        for (int i = 0; i < 10; i++, tree.add((int) (100 * Math.random()))) ;

        System.out.println("Tree is balanced: " + tree.root.isBalanced());
        tree.root.inOrder();
        System.out.println();

        tree.root.preOrder();
        System.out.println();

        tree.root.postOrder();
        System.out.println();

        tree.root.levelOrder();
    }
}
