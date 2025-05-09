package org.example;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] unsortedArray = {5, 1, 2, 9, -12, 12312, 0, -123213121, 5};
        System.out.println(Arrays.toString(unsortedArray));
        System.out.println(Arrays.toString(HeapSort.heapsort(unsortedArray)));
    }
}