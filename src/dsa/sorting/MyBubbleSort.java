package dsa.sorting;

public class MyBubbleSort {

    public static void main(String[] args) {

        int[] arrays = {1000, 58, 6, 9, 60};
        for (int arr : arrays) {
            System.out.println(arr);
        }

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - i - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
        System.out.println("After Sort!!!");
        for (int arr : arrays) {
            System.out.println(arr);
        }
    }
}
