package exercises.sorting;

import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

public class SortPerfTest {

    private static int INPUT_SIZE = 1000000;

    @Test
    public void runPerfTest() {
        Random random = new Random(new Date().getTime());
        int[] input = initRandomArray(random);
        int[] toSort = new int[INPUT_SIZE];
        long start, end;

        System.arraycopy(input, 0, toSort, 0, INPUT_SIZE);
        //selection sort
        start = System.currentTimeMillis();
        //Sort.selectionSort(toSort);
        end = System.currentTimeMillis();
//        assertTrue(isSorted(toSort));
        long selectionSortTime = end - start;
        System.arraycopy(input, 0, toSort, 0, INPUT_SIZE);
        System.out.println("Selection sort time: " + (double) selectionSortTime / 1000 +"s");

        //insertion sort
        start = System.currentTimeMillis();
//        Sort.insertionSort(toSort);
        end = System.currentTimeMillis();
//        assertTrue(isSorted(toSort));
        long insertionSortTime = end - start;
        System.arraycopy(input, 0, toSort, 0, INPUT_SIZE);
        System.out.println("Insertion sort time: " + (double) insertionSortTime / 1000 +"s");

        //quick sort
        start = System.currentTimeMillis();
        Sort.quickSort(toSort, 0, INPUT_SIZE - 1);
        end = System.currentTimeMillis();
        assertTrue(isSorted(toSort));
        long quickSortTime = end - start;
        System.arraycopy(input, 0, toSort, 0, INPUT_SIZE);
        System.out.println("Quick sort time: " + (double) quickSortTime / 1000 +"s");

        //merge sort
        start = System.currentTimeMillis();
        Sort.mergeSort(toSort);
        end = System.currentTimeMillis();
        assertTrue(isSorted(toSort));
        long mergeSortTime = end - start;
        System.arraycopy(input, 0, toSort, 0, INPUT_SIZE);
        System.out.println("Merge sort time: " + (double) mergeSortTime / 1000 +"s");

        //heap sort
        start = System.currentTimeMillis();
        Sort.heapSort(toSort);
        end = System.currentTimeMillis();
        assertTrue(isSorted(toSort));
        long heapSortTime = end - start;
        System.arraycopy(input, 0, toSort, 0, INPUT_SIZE);
        System.out.println("Heap sort time: " + (double) heapSortTime / 1000 +"s");

        //radix sort
        start = System.currentTimeMillis();
        Sort.radixSort(toSort);
        end = System.currentTimeMillis();
        assertTrue(isSorted(toSort));
        long radixSortTime = end - start;
        System.arraycopy(input, 0, toSort, 0, INPUT_SIZE);
        System.out.println("Radix sort time: " + (double) radixSortTime / 1000 +"s");
    }

    private static int[] initRandomArray(Random generator) {
        int[] result = new int[INPUT_SIZE];
        for (int j = 0; j < INPUT_SIZE; j++) result[j] = (int) (Math.random() * INPUT_SIZE);//Math.abs(generator.nextInt());
        return result;
    }

    private static boolean isSorted(int[] input) {
        for (int i = 0; i < input.length - 1; i++)
            if (input[i] > input[i + 1]) {
                System.err.println("input[" + i + "] = " + input[i] + " was bigger than input[" + (i + 1) + "] = " + input[i + 1]);
                return false;
            }
        return true;
    }
}