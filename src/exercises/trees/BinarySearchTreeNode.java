package exercises.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cls on 09/03/15.
 */
public class BinarySearchTreeNode<T extends Comparable<T>> {
    T key;
    BinarySearchTreeNode<T> parent;
    BinarySearchTreeNode<T> leftChild;
    BinarySearchTreeNode<T> rightChild;

    public BinarySearchTreeNode(T key, BinarySearchTreeNode<T> parent) {
        this.key = key;
        this.parent = parent;
    }


    public BinarySearchTreeNode(T key) {
        this.key = key;
    }

    boolean isRoot() {
        return this.parent == null;
    }

    boolean isBST() {
        if (leftChild != null && rightChild != null) {
            return key.compareTo(leftChild.key) > 0 && key.compareTo(rightChild.key) < 0
                    && leftChild.isBST() && rightChild.isBST();
        }
        if (leftChild != null) {
            return key.compareTo(leftChild.key) > 0 && leftChild.isBST();
        }
        if (rightChild != null) {
            return key.compareTo(rightChild.key) < 0 && rightChild.isBST();
        }
        return true;
    }

    boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    boolean isLeftChild() {
        return !isRoot() && this.equals(parent.leftChild);
    }

    boolean isRightChild() {
        return !isRoot() && this.equals(parent.rightChild);
    }

    boolean hasBothChildren() { return hasLeftChild() && hasRightChild(); }
    boolean hasLeftChild() { return leftChild != null; }
    boolean hasRightChild() { return rightChild != null; }

    public boolean isBalanced() {
        return Math.abs(leftHeight() - rightHeight()) <= 1;
    }

    public BinarySearchTreeNode<T> balance() {
        int leftHeight = leftHeight();
        int rightHeight = rightHeight();
        BinarySearchTreeNode<T> subRoot = this;
        if (leftHeight + 1 < rightHeight) {
            //right subtree unbalanced
            if (rightChild.rightChild == null) {
                rightChild.rotateRight();
                subRoot = rotateLeft();
            } else subRoot = rotateLeft();
        } else if (rightHeight + 1 < leftHeight) {
            //left subtree unbalanced
            if (leftChild.leftChild == null) {
                leftChild.rotateLeft();
                subRoot = rotateRight();
            }
            else subRoot = rotateRight();
        }
        if (subRoot.parent == null) return subRoot;
        return subRoot.parent.balance();
    }

    private BinarySearchTreeNode<T> rotateLeft() {
        BinarySearchTreeNode<T> newRoot = this.rightChild;
        BinarySearchTreeNode<T> thisParent = this.parent;
        if (this.isLeftChild()) {
            this.parent.leftChild = newRoot;
        } else if (this.isRightChild()) {
            this.parent.rightChild = newRoot;
        }

        newRoot.parent = thisParent;
        this.parent= newRoot;

        this.rightChild = newRoot.leftChild;
        newRoot.leftChild = this;
        return newRoot;
    }

    private BinarySearchTreeNode<T> rotateRight() {
        BinarySearchTreeNode<T> newRoot = this.leftChild;
        BinarySearchTreeNode<T> thisParent = this.parent;
        if (this.isLeftChild()) {
            this.parent.leftChild = newRoot;
        } else if (this.isRightChild()) {
            this.parent.rightChild = newRoot;
        }

        newRoot.parent = thisParent;
        this.parent= newRoot;

        this.leftChild = newRoot.rightChild;
        newRoot.rightChild = this;
        return newRoot;
    }

    public int leftHeight() {
       return (leftChild == null) ? 0 : 1 + leftChild.height();
    }

    public int rightHeight() {
        return (rightChild == null) ? 0 : 1 + rightChild.height();
    }

    public int height() {
        return Math.max(leftHeight(), rightHeight());
    }

    public boolean exists(T key) { return find(key) != null; }

    public BinarySearchTreeNode<T> find(T key) {
        if (this.key.compareTo(key) == 0) return this;
        if (this.key.compareTo(key) < 0 && this.rightChild != null) return rightChild.find(key);
        if (this.key.compareTo(key) > 0 && this.leftChild != null) return leftChild.find(key);
        return null;
    }

    private List<BinarySearchTreeNode<T>> getNodesAtLevel(int level) {
        List<BinarySearchTreeNode<T>> result = new ArrayList<BinarySearchTreeNode<T>>();
        if (level == 1) {
            result.add(this);
            return result;
        }
        if (leftChild != null) {
            result.addAll(leftChild.getNodesAtLevel(level - 1));
        }
        if (rightChild != null) {
            result.addAll(rightChild.getNodesAtLevel(level - 1));
        }
        return result;
    }

    public void levelOrder() {
        int i = 1;
        List<BinarySearchTreeNode<T>> nodesAtLevelI;
        do {
            nodesAtLevelI = this.getNodesAtLevel(i++);
            for (BinarySearchTreeNode<T> node : nodesAtLevelI) {
                System.out.println(node.key);
            }
        }
        while (!nodesAtLevelI.isEmpty());
    }

    public void inOrder() {
        if (leftChild != null) leftChild.inOrder();
        System.out.println(this.key);
        if (rightChild != null) rightChild.inOrder();
    }

    public void preOrder() {
        System.out.println(this.key);
        if (leftChild != null) leftChild.preOrder();
        if (rightChild != null) rightChild.preOrder();
    }

    public void postOrder() {
        if (leftChild != null) leftChild.postOrder();
        if (rightChild != null) rightChild.postOrder();
        System.out.println(this.key);
    }

    public BinarySearchTreeNode<T> addChild(T key) {
        if (this.key.compareTo(key) < 0) {
            if (rightChild != null) {
                return rightChild.addChild(key);
            }
            rightChild = new BinarySearchTreeNode<T>(key, this);
            return rightChild;
        } else if (this.key.compareTo(key) > 0){
            if (leftChild != null) {
                return leftChild.addChild(key);
            }
            leftChild = new BinarySearchTreeNode<T>(key, this);
            return leftChild;
        } else return this;
    }

    public BinarySearchTreeNode<T> remove(T key) {
        BinarySearchTreeNode<T> toRemove = find(key), parent = toRemove.parent;
        if (toRemove.hasBothChildren()) {
            BinarySearchTreeNode<T> largest = toRemove.leftChild;
            while (!largest.isLeaf()) largest = largest.rightChild;
            toRemove.key = largest.key;
            if (largest.parent == toRemove) {
                toRemove.leftChild = null;
            } else {
                largest.parent.rightChild = largest.leftChild;
                if (largest.leftChild != null) {
                    largest.leftChild.parent = largest.parent;
                }
            }
            if (toRemove.isRoot()) parent = toRemove;
        }
        else if (toRemove.hasLeftChild()) {
            if (toRemove.isRoot()) {
                parent = toRemove.leftChild;
                parent.parent = null;
            } else {
                parent.leftChild = toRemove.leftChild;
                toRemove.leftChild.parent = parent;
            }
        }

        else if (toRemove.hasRightChild()) {
            if (toRemove.isRoot()) {
                parent = toRemove.rightChild;
                parent.parent = null;
            } else {
                parent.rightChild = toRemove.rightChild;
                toRemove.rightChild.parent = parent;
            }
        }
        else {
            if (toRemove.isLeftChild()) parent.leftChild = null;
            if (toRemove.isRightChild()) parent.rightChild = null;
        }
        return parent.balance();
    }
}
