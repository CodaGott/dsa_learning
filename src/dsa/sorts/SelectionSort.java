package dsa.sorts;

import java.util.Arrays;

public class SelectionSort {


    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 88, 3};
        selectSort(arr);
    }

    public static void selectSort(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            int largest = 0;

            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[largest]){
                    largest = j;
                }
            }
            swap(arr, largest, i);
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void swap(int[] arr, int firstElement, int lastElement){

        if (firstElement == lastElement){
            return;
        }
        int temp;

        temp = arr[firstElement];
        arr[firstElement] = arr[lastElement];
        arr[lastElement] = temp;
    }
}
