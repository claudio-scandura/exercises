package exercises.trees;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SimpleTreeNodeTest {

    @Test
    public void shouldBuildTreeFromInOrderTraversalOneElementOnly() {
        int[] input = {23};
        SimpleTreeNode result = SimpleTreeNode.buildTreeFromInOrderTraversal(input);

        assertArrayEquals(input, result.inOrder());
    }

    @Test
    public void shouldBuildTreeFromInOrderTraversalTwoElements() {
        int[] input = {23, 42};
        SimpleTreeNode result = SimpleTreeNode.buildTreeFromInOrderTraversal(input);

        assertArrayEquals(input, result.inOrder());
    }

    @Test
    public void shouldBuildTreeFromInOrderTraversalThreeElements() {
        int[] input = {23, 42, 67};
        SimpleTreeNode result = SimpleTreeNode.buildTreeFromInOrderTraversal(input);

        assertArrayEquals(input, result.inOrder());
    }

    @Test
    public void shouldBuildTreeFromInOrderTraversalContainingMoreThanASubTree() {
        int[] input = {23, 42, 67, 45, 90, 118, 34};
        SimpleTreeNode result = SimpleTreeNode.buildTreeFromInOrderTraversal(input);

        assertArrayEquals(input, result.inOrder());
    }

    @Test
    public void shouldBuildTreeFromInOrderTraversalContainingLotsOfNodes() {
        int[] input = {23, 42, 67, 45, 90, 118, 34, 93, 65, 76, 99, 100, 11, 9};
        SimpleTreeNode result = SimpleTreeNode.buildTreeFromInOrderTraversal(input);

        assertArrayEquals(input, result.inOrder());
    }

    @Test
    public void shouldBuildTreeFromPreOrderTraversalOneElementOnly() {
        int[] input = {23};
        SimpleTreeNode result = SimpleTreeNode.buildTreeFromPreOrderTraversal(input);

        assertArrayEquals(input, result.preOrder());
    }

    @Test
    public void shouldBuildTreeFromPreOrderTraversalTwoElements() {
        int[] input = {23, 42};
        SimpleTreeNode result = SimpleTreeNode.buildTreeFromPreOrderTraversal(input);

        assertArrayEquals(input, result.preOrder());
    }

    @Test
    public void shouldBuildTreeFromPreOrderTraversalThreeElements() {
        int[] input = {23, 42, 67};
        SimpleTreeNode result = SimpleTreeNode.buildTreeFromPreOrderTraversal(input);

        assertArrayEquals(input, result.preOrder());
    }

    @Test
    public void shouldBuildTreeFromPreOrderTraversalContainingMoreThanASubTree() {
        int[] input = {23, 42, 67, 45, 90, 118, 34};
        SimpleTreeNode result = SimpleTreeNode.buildTreeFromPreOrderTraversal(input);

        assertArrayEquals(input, result.preOrder());
    }

    @Test
    public void shouldBuildTreeFromPreOrderTraversalContainingLotsOfNodes() {
        int[] input = {23, 42, 67, 45, 90, 118, 34, 93, 65, 76, 99, 100, 11, 9};
        SimpleTreeNode result = SimpleTreeNode.buildTreeFromPreOrderTraversal(input);

        assertArrayEquals(input, result.preOrder());
    }

    @Test
    public void buildListFromTreeShouldReturnSingleElement() {
        SimpleTreeNode node = new SimpleTreeNode(34);

        SimpleTreeNode list = node.buildList();
        while (list.left != null) list = list.left;
        assertEquals(34, list.key);
    }

    @Test
    public void buildListFromTreeShouldReturnTwoElements() {
        SimpleTreeNode node = new SimpleTreeNode(34);
        node.left = new SimpleTreeNode(24);

        SimpleTreeNode list = node.buildList();
        while (list.left != null) list = list.left;

        assertEquals(24, list.key);
        assertEquals(34, list.right.key);
        assertNull(list.left);

        assertEquals(list, list.right.left);
    }

    @Test
    public void buildListFromTreeShouldReturnThreeElements() {
        SimpleTreeNode node = new SimpleTreeNode(34);
        node.left = new SimpleTreeNode(24);
        node.right = new SimpleTreeNode(54);

        SimpleTreeNode list = node.buildList();
        while (list.left != null) list = list.left;

        assertEquals(24, list.key);
        assertEquals(34, list.right.key);
        assertEquals(54, list.right.right.key);
        assertNull(list.left);

        assertEquals(list, list.right.left);
        assertEquals(list.right, list.right.right.left);
    }

    @Test
    public void buildListFromTreeWithSubtreesShouldReturnAllElements() {
        SimpleTreeNode leftTree = new SimpleTreeNode(34);
        leftTree.left = new SimpleTreeNode(24);
        leftTree.right = new SimpleTreeNode(54);

        SimpleTreeNode rightTree = new SimpleTreeNode(84);
        rightTree.left = new SimpleTreeNode(74);
        rightTree.right = new SimpleTreeNode(94);

        SimpleTreeNode root = new SimpleTreeNode(64);
        root.left = leftTree;
        root.right = rightTree;

        SimpleTreeNode list = root.buildList();
        while (list.left != null) list = list.left;
        printList(list);

        assertEquals(24, list.key);
        assertEquals(34, list.right.key);
        assertEquals(54, list.right.right.key);
        list = list.right.right.right;

        assertEquals(64, list.key);
        assertEquals(74, list.right.key);
        assertEquals(84, list.right.right.key);
        assertEquals(94, list.right.right.right.key);
    }

    private void printList(SimpleTreeNode list) {
        SimpleTreeNode cursor = list;
        System.out.print("[");
        while (cursor != null) {
            System.out.print(cursor.key);
            cursor = cursor.right;
            if (cursor != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}