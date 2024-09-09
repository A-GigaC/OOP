import org.example.HeapSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
