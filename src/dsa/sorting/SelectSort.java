package dsa.sorting;

public class SelectSort {

    public static void main(String[] args) {
        int[] arrays = {3, 89, 110, 2, 78, 5, 1};


        selectionSort(arrays);

        for(int arr : arrays){
            System.out.println(arr);
        }
    }

    private static void selectionSort(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[min] > arrays[j]){
                    min = j;
                }
            }
            int temp = arrays[i];
            arrays[i] = arrays[min];
            arrays[min] = temp;
        }
    }

}
