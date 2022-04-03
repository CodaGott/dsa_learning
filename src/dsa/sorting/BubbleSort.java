package dsa.sorting;

public class BubbleSort {

    private static int[] unsortedArray = {1000,58,6,9,0, 1, 5,60};

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.sortArrays(unsortedArray);
        bubbleSort.printArray(unsortedArray);
    }

    public int[] sortArrays(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length -1; j++) {

                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public void printArray(int[] arrays){
        for (int array : arrays) {
            System.out.println(array);
        }
    }

    public static void swap(int [] arrays, int i, int j){
        if (i == j){
            return;
        }

        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
}
