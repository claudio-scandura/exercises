package exercises.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cls on 21/03/15.
 */
public class SimpleTreeNode {

    int key;
    SimpleTreeNode left;
    SimpleTreeNode right;

//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof SimpleTreeNode)) return false;
//        SimpleTreeNode other = (SimpleTreeNode) obj;
//        if (!checkChildrenForEquality(other)) return false;
//
//        boolean keyEquals = this.key == other.key;
//        boolean leftEquals = (this.left == null && other.left == null) || (this.left.equals(other.left));
//        boolean rightEquals = (this.right == null && other.right == null) || (this.right.equals(other.right));
//        return keyEquals && leftEquals && rightEquals;
//    }

    private boolean checkChildrenForEquality(SimpleTreeNode other) {
        if (other.left == null && this.left != null) return false;
        if (other.left != null && this.left == null) return false;
        if (other.right == null && this.right != null) return false;
        if (other.right != null && this.right == null) return false;
        return true;
    }

    public SimpleTreeNode() {
    }

    public SimpleTreeNode(int keyValue) {
        this.key = keyValue;
    }

    public int[] preOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        preOrderVisit(list);
        int[] result = new int[list.size()];
        int j = 0;
        for (Integer i : list) result[j++] = i;
        return result;
    }

    public int[] inOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderVisit(list);
        int[] result = new int[list.size()];
        int j = 0;
        for (Integer i : list) result[j++] = i;
        return result;
    }


    private void preOrderVisit(List<Integer> accumulator) {
        accumulator.add(this.key);
        if (left != null) left.preOrderVisit(accumulator);
        if (right != null) right.preOrderVisit(accumulator);

    }

    private void inOrderVisit(List<Integer> accumulator) {
        if (left != null) left.inOrderVisit(accumulator);
        accumulator.add(this.key);
        if (right != null) right.inOrderVisit(accumulator);

    }

    public static SimpleTreeNode buildTreeFromInOrderTraversal(int[] input) {
        return buildTreeFromInOrderTraversal(input, 0, input.length - 1);
    }


    private static SimpleTreeNode buildTreeFromInOrderTraversal(int[] input, int low, int high) {
        if (low > high) return null;
        if (low == high) {
            return new SimpleTreeNode(input[low]);
        }
        int mid = (high + low) / 2;
        SimpleTreeNode root = new SimpleTreeNode(input[mid]);
        root.left = buildTreeFromInOrderTraversal(input, low, mid - 1);
        root.right = buildTreeFromInOrderTraversal(input, mid + 1, high);
        return root;
    }

    public static SimpleTreeNode buildTreeFromPreOrderTraversal(int[] input) {
        return buildTreeFromPreOrderTraversal(input, 0, input.length - 1);
    }

    private static SimpleTreeNode buildTreeFromPreOrderTraversal(int[] input, int base, int end) {
        if (base > end) return null;
        if (base == end) return new SimpleTreeNode(input[base]);
        int mid = (base + end) / 2;
        SimpleTreeNode root = new SimpleTreeNode(input[base]);
        root.left = buildTreeFromPreOrderTraversal(input, base + 1, mid);
        root.right = buildTreeFromPreOrderTraversal(input, mid + 1, end);
        return root;
    }

    public SimpleTreeNode buildList() {
        SimpleTreeNode predecessors = null, successors = null;
        if (left != null) {
            predecessors = left.buildList();
            while (predecessors.right != null) predecessors = predecessors.right;
            predecessors.right = this;
        }
        if (right != null) {
            successors = right.buildList();
            while (successors.left != null) successors = successors.left;
            successors.left = this;
        }
        left = predecessors;
        right = successors;
        return this;
    }
}
