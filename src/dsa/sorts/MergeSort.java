package dsa.sorts;

public class MergeSort {
    int [] array, temp;

    public MergeSort(int[] array){
        this.array = array;
        temp = new int[array.length];
        split(0, array.length - 1);
    }

    private void split(int low, int high){
        if (low == high){
            return;
        }

        int mid = (high + low) / 2;
        split(low, mid);
        split(mid+1, high);
    }

    private void merge(int low, int mid, int high){
        int i = low, j = mid + 1, tempPosition = low;

        while (i <= mid && j <= high){
            if (array[i] <= array[j]){
                temp[tempPosition++] = array[i++];;
            }else {
                temp[tempPosition++] = array[j++];
            }
        }

        while (i <= mid){
            temp[tempPosition++] = array[i++];
        }
        while (j<=high){
            temp[tempPosition++] = array[j++];
        }

        for (tempPosition=low; tempPosition<= high; tempPosition++){
            array[tempPosition] = temp[tempPosition];
        }
    }
}
