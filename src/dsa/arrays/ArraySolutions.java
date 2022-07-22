package dsa.arrays;

import java.util.Arrays;

public class ArraySolutions {


    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6};
//
//        swap(arr, 2, 4);
//        System.out.println(Arrays.toString(arr));
//
//        arr = new int[]{1, 2, 3, 4, 5, 6};
//        reverseArray(arr);
//        System.out.println(Arrays.toString(arr));
//
        int[] sortedArr = {1, 1, 2, 3, 4, 4, 5, 6};

        removeDuplicateFromSortedArray(sortedArr);

//        System.out.println(Arrays.toString(sortedArr));
    }

    public static void removeDuplicateFromSortedArray(int[] sortedArr) {

        /**
         * Create a new array of same length with the original one.
         * Create a counter variable
         * Iterate through the sorted array
         * check if the previous element in the array is not equal to the next item.
         * copy the non-duplicate into the new array.
         * Copy back the unique items into the array
         * */

        int[] updatedArr = new int[sortedArr.length];
        int j = 0;

        for (int i = 0; i < sortedArr.length - 1; i++) {
            if (sortedArr[i] != sortedArr[i+1]){
                updatedArr[j++] = sortedArr[i];
            }
        }
        updatedArr[j++] = sortedArr[sortedArr.length - 1];

        for (int i = 1; i < j ; i++) {
            System.out.println(Arrays.toString(sortedArr));
            sortedArr[i] = updatedArr[i];
        }
        System.out.println("Updated " + Arrays.toString(updatedArr));
    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] arr, int firstNum, int secondNum) {
        int temp = arr[firstNum];
        arr[firstNum] = arr[secondNum];
        arr[secondNum] = temp;
    }





}
