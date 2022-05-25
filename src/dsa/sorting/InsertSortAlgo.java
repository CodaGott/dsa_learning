package dsa.sorting;

public class InsertSortAlgo {

    public static void main(String[] args) {
        int[] array = {8, 9, 76, 1, 55, -2};
        for (int element: array) {
            System.out.print(element);
        }
    }

    public static void insertSort(int[] arrs){
        for (int i = 1 ; i < arrs.length; i++) {
            int temp = arrs[i];
            int j = i - 1;

            while(j >= 0 && arrs[j] > temp){
                arrs[j + 1] = arrs[j];
                j--;
            }
            arrs[j + 1] = temp;
        }
    }
}
