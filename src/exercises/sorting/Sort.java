package exercises.sorting;

import exercises.heap.MinHeap;

import java.util.*;

public class Sort {

    public static void main(String[] args) {
        int[] array = {3, 5, 2, 5, 2, 23, 5, 6, 7, 1};
        mergeSort(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = {3, 5, 2, 5, 2, 23, 5, 6, 7, 1};
        insertionSort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {3, 5, 2, 5, 2, 23, 5, 6, 7, 1};
        selectionSort(array3);
        System.out.println(Arrays.toString(array3));

        int[] array4 = {3, 5, 2, 5, 2, 23, 5, 6, 7, 1};
        quickSort(array4, 0, array4.length - 1);
        System.out.println(Arrays.toString(array4));

        int[] array5 = {3, 5, 2, 5, 2, 23, 5, 6, 7, 1};
        heapSort(array5);
        System.out.println(Arrays.toString(array5));


        int[] array6 = {3, 5, 2, 5, 2, 23, 5, 6, 7, 123, 234567};
        radixSort(array6);
        System.out.println(Arrays.toString(array6));

    }

    public static void printASCII(char c) {
        if (c < 255) {
            System.out.println(c);
            c += 1;
            printASCII(c);
        }
    }

    public static void insertionSort(int[] array) {
        int aux;
        for (int i = 0; i < array.length; i++) {
            int k = i - 1;
            aux = array[i];
            while (k >= 0 && aux < array[k]) array[k + 1] = array[k--];
            array[k + 1] = aux;
        }
    }

    public static void selectionSort(int[] array) {
        int indexMin;
        for (int i = 0; i < array.length - 1; i++) {
            indexMin = i;
            for (int k = i + 1; k < array.length; k++) {
                if (array[k] < array[indexMin]) indexMin = k;
            }

            if (indexMin != i) {
                swap(array, indexMin, i);
            }
        }
    }

    public static void mergeSort(int[] array) {
        if (array.length <= 1) return;
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int pos = 0, leftArrayIndex = 0, rightArrayIndex = 0;
        while (leftArrayIndex < left.length && rightArrayIndex < right.length) {
            if (right[rightArrayIndex] >= left[leftArrayIndex])
                result[pos++] = left[leftArrayIndex++];
            else result[pos++] = right[rightArrayIndex++];
        }
        while (leftArrayIndex < left.length) result[pos++] = left[leftArrayIndex++];
        while (rightArrayIndex < right.length) result[pos++] = right[rightArrayIndex++];

    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivotIndex = (high + low)/2;
        int pivotValue = array[pivotIndex];
        int storeIndex = low;
        swap(array, pivotIndex, high);
        for (int i = low; i < high; i++) {
            if (array[i] < pivotValue) {
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        swap(array, high, storeIndex);
        return storeIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int[] heapSort(int[] input) {
        //Bottom up max heap construction
        MinHeap.bottomUpMaxHeap(input);

        //reduction of heap to build sorted array in place
        for (int j = input.length - 1; j >= 0; j--) {
            swap(input, 0, j);
            siftDown(input, 0, j);
        }

        return input;
    }

    private static void siftDown(int[] input, int start, int heapSize) {
        int left = 2 * (start + 1) - 1;
        int right = 2 * (start + 1);
        int max = start;
        if (left < heapSize && input[left] > input[max]) max = left;
        if (right < heapSize && input[right] > input[max]) max = right;
        if (max != start) {
            swap(input, max, start);
            siftDown(input, max, heapSize);
        }

    }

    public static void radixSort(int[] input) {
        LinkedList<Integer>[] lists = new LinkedList[10];
        for (int k = 0; k < lists.length; k++) lists[k] = new LinkedList<>();

        int n = 1, m = 10;
        int numOfDigits = getMaxNumOfDigits(input);
        while (numOfDigits-- > 0) {
            for (int i = 0; i < input.length; i++) {
                int position = (input[i] % m) / n;
                lists[position].add(input[i]);
            }
            int k = 0;
            for (LinkedList<Integer> list: lists) {
                while (!list.isEmpty()) input[k++] = list.removeFirst();
            }
            n *= 10;
            m *= 10;
        }
    }

    private static int getMaxNumOfDigits(int[] input) {
        int max = Integer.MIN_VALUE;
        for (Integer i: input) if (i > max) max = i;
        int countOfDigits = 0;
        do countOfDigits++;
        while ((max /= 10) > 0);
        return countOfDigits;
    }

}
