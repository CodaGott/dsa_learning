package dsa.sorting;

public class BubbleSort {

    private static int[] unsortedArray = {1000,58,6,9,60};

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.sortArrays(unsortedArray);
        bubbleSort.printArray(unsortedArray);
    }

    public  void sortArrays(int[] arrs){
        for (int lastUnsortedIndex = arrs.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (arrs[i] > arrs[i+ 1]){
                    swap(arrs, i, i + 1);
                }
            }
        }
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
