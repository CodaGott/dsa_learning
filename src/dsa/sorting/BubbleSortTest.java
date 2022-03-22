package dsa.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    BubbleSort bubbleSort = new BubbleSort();


    @Test
    void testItemIsSorted(){
        int[] unsortedArray = {1000,58,6,9,60};
        bubbleSort.sortArrays(unsortedArray);
        int sortedPosition = unsortedArray[0];
        assertEquals(sortedPosition, 6);
    }
}