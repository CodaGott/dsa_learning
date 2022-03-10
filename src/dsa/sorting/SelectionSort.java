package dsa.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arrays = {90, 4, 89, 99, 18};

        for (int lastUnsortedIndex = arrays.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){

            int largestElement = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if(arrays[i] > arrays[largestElement]){
                    largestElement = i;
                }
            }
            swapElements(arrays, largestElement, lastUnsortedIndex);
        }

        for (int array : arrays) {
            System.out.println(array);
        }
    }

    public static void swapElements(int[] arrays, int i, int j){
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
}
