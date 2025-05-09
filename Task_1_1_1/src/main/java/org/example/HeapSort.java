package org.example;

/* This class provides functionality to sorting int[] data via heapsort */
public class HeapSort {
    /* heapsort function enable to call outside the HeapSort class */
    public static int[] heapsort(int[] array) {
        int length = array.length;

        // Build a maxheap
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // Sift all elements
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }

        return array;
    }

    /* This function can be called only from HeapSort method */
    private static void heapify(int[] array, int length, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // Check left leaf
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        // Check right leaf
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        // If root is not largest
        if (largest != index) {
            // Обмен корня с наибольшим элементом
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;

            // Call for subtree
            heapify(array, length, largest);
        }
    }
}
