package dsa.sorting;

public class InsertionSort {
    static int [] intArray = {20, 3, 8, -11, 30, -99};
    public static void main(String[] args) {

        insertSort(intArray);
        print();
    }
    
    public static void insertSort(int[] arr){
        // The index is 1 because the algorithm assumes that the first element is already sorted.
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];

        int i;
        for (i = firstUnsortedIndex; i > 0 && arr[i - 1] > newElement; --i) {
            arr[i] = arr[i - 1];
        }
        arr[i] = newElement;
        }
    }

    public static void print(){
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }
    
}
