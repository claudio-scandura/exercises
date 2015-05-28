package exercises.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeNodeTest {

    @Test
    public void addDuplicatesToTreeShouldDoNothing() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(4).add(4);
        assertEquals(1, tree.size);
        assertEquals(new Integer(4), tree.root.key);
        assertNull(tree.root.leftChild);
        assertNull(tree.root.rightChild);
    }

    @Test
    public void shouldDoLeftRotationOnSimpleTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(0).add(1).add(2);

        assertEquals(3, tree.size);
        assertTrue(tree.root.isBalanced());
        assertEquals(new Integer(1), tree.root.key);
        assertNull(tree.root.parent);
        assertEquals(new Integer(0), tree.root.leftChild.key);
        assertEquals(new Integer(2), tree.root.rightChild.key);
        assertTrue(tree.root.leftChild.isLeaf());
        assertTrue(tree.root.rightChild.isLeaf());
    }

    @Test
    public void shouldDoRightRotationOnSimpleTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(2).add(1).add(0);

        assertEquals(3, tree.size);
        assertTrue(tree.root.isBalanced());
        assertEquals(new Integer(1), tree.root.key);
        assertNull(tree.root.parent);
        assertEquals(new Integer(0), tree.root.leftChild.key);
        assertEquals(new Integer(2), tree.root.rightChild.key);
        assertTrue(tree.root.leftChild.isLeaf());
        assertTrue(tree.root.rightChild.isLeaf());
    }

    @Test
    public void shouldDoRightLeftRotationOnSimpleTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(5).add(10).add(7);

        assertEquals(3, tree.size);
        assertTrue(tree.root.isBalanced());
        assertEquals(new Integer(7), tree.root.key);
        assertNull(tree.root.parent);
        assertEquals(new Integer(5), tree.root.leftChild.key);
        assertEquals(new Integer(10), tree.root.rightChild.key);
        assertTrue(tree.root.leftChild.isLeaf());
        assertTrue(tree.root.rightChild.isLeaf());
    }

    @Test
    public void shouldDoLeftRightRotationOnSimpleTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(10).add(5).add(7);

        assertEquals(3, tree.size);
        assertTrue(tree.root.isBalanced());
        assertEquals(new Integer(7), tree.root.key);
        assertNull(tree.root.parent);
        assertEquals(new Integer(5), tree.root.leftChild.key);
        assertEquals(new Integer(10), tree.root.rightChild.key);
        assertTrue(tree.root.leftChild.isLeaf());
        assertTrue(tree.root.rightChild.isLeaf());
    }

    @Test
    public void shouldDoLeftRotationOnMoreComplexTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(10).add(5).add(90).add(150).add(200);

        assertEquals(5, tree.size);
        assertTrue(tree.root.isBalanced());
        assertEquals(new Integer(10), tree.root.key);
        assertNull(tree.root.parent);
        assertEquals(new Integer(5), tree.root.leftChild.key);
        assertEquals(new Integer(150), tree.root.rightChild.key);
        assertEquals(new Integer(90), tree.root.rightChild.leftChild.key);
        assertEquals(new Integer(200), tree.root.rightChild.rightChild.key);
    }

    @Test
    public void shouldDoRightRotationOnMoreComplexTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(-10).add(-5).add(-90).add(-150).add(-200);

        assertEquals(5, tree.size);
        assertTrue(tree.root.isBalanced());
        assertEquals(new Integer(-10), tree.root.key);
        assertNull(tree.root.parent);
        assertEquals(new Integer(-5), tree.root.rightChild.key);
        assertEquals(new Integer(-150), tree.root.leftChild.key);
        assertEquals(new Integer(-90), tree.root.leftChild.rightChild.key);
        assertEquals(new Integer(-200), tree.root.leftChild.leftChild.key);
    }

    @Test
    public void shouldDoRightLeftRotationOnMoreComplexTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(10).add(5).add(90).add(150).add(120);

        assertEquals(5, tree.size);
        assertTrue(tree.root.isBalanced());
        assertEquals(new Integer(10), tree.root.key);
        assertNull(tree.root.parent);
        assertEquals(new Integer(5), tree.root.leftChild.key);
        assertEquals(new Integer(120), tree.root.rightChild.key);
        assertEquals(new Integer(90), tree.root.rightChild.leftChild.key);
        assertEquals(new Integer(150), tree.root.rightChild.rightChild.key);
    }

    @Test
    public void shouldDoLeftRightRotationOnMoreComplexTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(-10).add(-5).add(-90).add(-150).add(-120);

        assertEquals(5, tree.size);
        assertTrue(tree.root.isBalanced());
        assertEquals(new Integer(-10), tree.root.key);
        assertNull(tree.root.parent);
        assertEquals(new Integer(-5), tree.root.rightChild.key);
        assertEquals(new Integer(-120), tree.root.leftChild.key);
        assertEquals(new Integer(-90), tree.root.leftChild.rightChild.key);
        assertEquals(new Integer(-150), tree.root.leftChild.leftChild.key);
    }

    @Test
    public void shouldKeepRandomComplexTreeBlanaced() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        for (int i = 1; i <= 100; tree.add((int) (Math.random() * i++)));

        assertTrue(tree.size <= 100);
        assertTrue(tree.root.isBalanced());
    }

    @Test
    public void removingLeafShouldLeaveTreeABST() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(90).add(50).add(150).add(10).add(200);

        assertTrue(tree.isBST());

        tree.remove(10);
        assertNull(tree.find(10));

        assertTrue(tree.isBST());

        assertTrue(tree.isBalanced());
    }

    @Test
    public void removingNodeWithLeftChildOnlyShouldLeaveTreeABST() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(90).add(50).add(150).add(10).add(200);

        assertTrue(tree.isBST());

        tree.remove(50);
        assertNull(tree.find(50));

        assertTrue(tree.isBST());

        assertTrue(tree.isBalanced());
    }


    @Test
    public void removingNodeWithRightChildOnlyShouldLeaveTreeABST() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(90).add(50).add(150).add(10).add(200);

        assertTrue(tree.isBST());

        tree.remove(150);
        assertNull(tree.find(150));

        assertTrue(tree.isBST());

        assertTrue(tree.isBalanced());
    }

    @Test
    public void removingNodeWithBothChildrenShouldLeaveTreeABST() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(90).add(50).add(150).add(10).add(60).add(200);

        assertTrue(tree.isBST());

        tree.remove(50);
        assertNull(tree.find(50));

        assertTrue(tree.isBST());

        assertTrue(tree.isBalanced());
    }

    @Test
    public void removingNodeWithBothChildrenShouldLeaveTreeABSTMoreComplex() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(90).add(50).add(150).add(10).add(60).add(120)
                .add(200).add(15).add(70).add(130).add(11);

        assertTrue(tree.isBST());

        tree.remove(50);
        assertNull(tree.find(50));

        assertTrue(tree.isBST());

        assertTrue(tree.isBalanced());
    }

    @Test
    public void removingRootWithBothChildrenShouldLeaveTreeABST() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(90).add(50).add(10).add(60).add(150).add(200);

        assertTrue(tree.isBST());

        tree.remove(90);
        assertNull(tree.find(90));

        assertTrue(tree.isBST());

        assertTrue(tree.isBalanced());
    }

    @Test
    public void removingRootWithOneChildOnlyShouldLeaveTreeABST() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(90).add(50);

        assertTrue(tree.isBST());

        tree.remove(90);
        assertNull(tree.find(90));

        assertTrue(tree.isBST());

        assertTrue(tree.isBalanced());
    }
}