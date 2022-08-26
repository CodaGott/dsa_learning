package dsa.sorts;

import java.util.Arrays;

public class SortsAlgo {


    public static void main(String[] args) {
        int[] arr = {10, 7, 800, 9, 88, 3};
        insertionSort(arr);
    }

    public static void sortIt(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int smallestInTheList = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallestInTheList] > arr[j]){
                    smallestInTheList = j;
                }
            }
            swap(arr, i, smallestInTheList);
        }
        System.out.println("Sorted: "+Arrays.toString(arr));

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

    public static void insertionSort(int[] arrays){
        for (int i = 1 ; i < arrays.length ; i++) {
            int j, v = arrays[i];

            for (j= i - 1; j >=0 ; j--) {
                if (arrays[j] <= v){
                    break;
                }
                arrays[j+1] = arrays[j];
            }
            arrays[j + 1] = v;
        }
        System.out.println("Sorted: "+Arrays.toString(arrays));
    }
}
