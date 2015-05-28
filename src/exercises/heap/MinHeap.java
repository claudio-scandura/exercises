package exercises.heap;

import java.util.Arrays;

/**
 * Created by cls on 08/03/15.
 */
public class MinHeap {

    int size;
    int[] array;

    public MinHeap() {
        array = new int[256];
    }

    public int top() {
        return size > 0 ? array[0] : -1;
    }

    public int enqueue(int element) {
        array[size] = element;
        bubbleUp(size);
        size++;
        return element;
    }

    private void bubbleUp(int index) {
        int parentIndex = (index % 2 == 0) ? (index / 2) - 1 : index / 2;
        if (index > 0 && array[index] < array[parentIndex]) {
            int tmp = array[index];
            array[index] = array[parentIndex];
            array[parentIndex] = tmp;
            bubbleUp(parentIndex);
        }
    }

    public int dequeue() {
        if (size == 0) return -1;
        int result = array[0];
        array[0] = array[--size];
        bubbleDown(0);
        return result;
    }

    private void bubbleDown(int index) {
        if (index < size) {
            int leftChild = (index + 1) * 2 - 1;
            int rightChild = 2 * (index + 1);
            int potentialSwapIndex;
            if (rightChild > size) potentialSwapIndex = leftChild;
            else potentialSwapIndex = array[leftChild] > array[rightChild] ? rightChild: leftChild;
            if (array[index] > array[potentialSwapIndex]) {
                swap(array, index, potentialSwapIndex);
                bubbleDown(potentialSwapIndex);
            }
        }
    }

    public static boolean isMaxHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int leftChildIndex = 2 * (i + 1) - 1;
            int rightChildIndex = 2 * (i + 1);
            if (leftChildIndex < array.length && rightChildIndex < array.length)
                if (array[i] < array[leftChildIndex] || array[i] < array[rightChildIndex]) return false;
        }
        return true;
    }

    public static void maxHeapify(int[] input, int i) {
        int left = 2 * (i + 1) - 1;
        int right = 2 * (i + 1);
        int maxIndex = i;
        if (left < input.length && input[left] > input[maxIndex])
            maxIndex = left;
        if (right < input.length && input[right] > input[maxIndex])
            maxIndex = right;
        if (maxIndex != i) {
            swap(input, i, maxIndex);
            maxHeapify(input, maxIndex);
        }
    }

    public static int[] bottomUpMaxHeap(int[] input) {
        for (int i = (input.length/2) - 1; i >= 0; i--)
            maxHeapify(input, i);
        return input;
    }

    public int[] toSortedArray() {
        int[] result = new int[size];
        int k = 0;
        int top = dequeue();
        while (top != -1) {
            result[k++] = top;
            top = dequeue();
        }
        return result;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
