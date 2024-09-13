import org.example.HeapSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class HeapsortTest {

    @Test
    void sortedData() {
        int[] sortedArray = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(sortedArray, HeapSort.heapsort(sortedArray));
    }

    @Test
    void reverseSortedData() {
        int[] reverseSortedArray = {5, 4, 3, 2, 1};
        int[] correctResult = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(correctResult, HeapSort.heapsort(reverseSortedArray));
    }

    @Test
    void unorderedData() {
        int[] array = {4, 6, 2, 1, 9, 123, -543, 0, 3};
        int[] correctResult = {-543, 0, 1, 2, 3, 4, 6, 9, 123};
        Assertions.assertArrayEquals(correctResult, HeapSort.heapsort(array));
    }

    @Test
    void voidArray() {
        int[] voidArray = {};
        Assertions.assertArrayEquals(voidArray, HeapSort.heapsort(voidArray));
    }

    @Test
    void nLogN() {
        int[] m0 = {};
        int[] m1 = {-1};
        int[] m2 = {2, -1};
        int[] m3 = {2, -1, 0};
        int[] m4 = {2, -1, 0, 1};
        int[] m5 = {2, -1, 0, 1, 2};


        int[] m500 = getRandomIntArray(500);
        int[] m1000 = getRandomIntArray(1000);
        int[] m5000 = getRandomIntArray(5000);
        int[] m10000 = getRandomIntArray(10000);
        int[] m100000 = getRandomIntArray(100000);
        int[] m1000000 = getRandomIntArray(1000000);

        getTime(m0);
        getTime(m1);
        getTime(m2);
        getTime(m3);
        getTime(m4);
        getTime(m5);


        double t500 = (double)getTime(m500);
        double t1000 = (double)getTime(m1000);
        double t5000 = (double)getTime(m5000);
        double t10000 = (double)getTime(m10000);
        double t100000 = (double)getTime(m100000);
        double t1000000 = (double)getTime(m1000000);

        System.out.println(t500);
        System.out.println(500*(Math.log(500) / Math.log(2)));
        System.out.println(t1000);
        System.out.println(1000*(Math.log(1000) / Math.log(2)));

        
        Assertions.assertTrue((t500 - 500*(Math.log(500) / Math.log(2))) < 0.0001);
        Assertions.assertTrue((t1000 - 1000*(Math.log(1000) / Math.log(2))) < 0.0001);
        Assertions.assertTrue((t5000 - 5000*(Math.log(5000) / Math.log(2))) < 0.0001);
        Assertions.assertTrue((t10000 - 10000*(Math.log(10000) / Math.log(2))) < 0.0001);
        Assertions.assertTrue((t100000 - 100000*(Math.log(100000) / Math.log(2))) < 0.0001);
        Assertions.assertTrue((t1000000 - 1000000*(Math.log(1000000) / Math.log(2))) < 0.0001);
    }

    private static long getTime(int[] array) {
        long t0s = System.currentTimeMillis();
        HeapSort.heapsort(array);
        long t0f = System.currentTimeMillis();

        return t0f - t0s;
    }

    private static int[] getRandomIntArray(int n) {
        Random rd = new Random();
        int[] array = new int[n];
        int min = -1000000000;
        int max = 1000000000;

        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(max-min+1) + min;
        }
        return array;
    }
}
