package dsa.sorting;

public class MySelectionSort {

    public static void main(String[] args) {

        int[] arrays = {90, 4, 89, 99, 18};

        for (int lastElement = arrays.length - 1; lastElement > 0; lastElement--) {
            int largest = 0;

            for (int i = 1; i <= lastElement; i++) {
                if (arrays[i] > arrays[largest]){
                    largest = i;
                }
            }
            swapElement(arrays, largest, lastElement);
        }

        for (int arr:arrays){
            System.out.println(arr);
        }
    }

    public static void swapElement(int[] arrays, int i, int j){
        if (arrays[i] == arrays[j]){
            return;
        }

        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
}
