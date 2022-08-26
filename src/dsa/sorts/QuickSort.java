package dsa.sorts;

public class QuickSort<E> {
    E[] array;

    public E[] sort(E [] array){
        this.array = array;
        quickSort(0, array.length - 1);

        return array;
    }

    private void quickSort(int from, int to) {
        if (from >= to){
            return;
        }

        E value = array[to];
        int counter = from;

        for (int i = from; i < to; i++) {
            if (((Comparable<E>)array[i]).compareTo(value) <= 0){
                swap(i, counter);
                counter++;
            }
        }
        swap(counter, to);
        quickSort(from, counter-1);
        quickSort(counter+1, to);
    }


    public void swap(int from, int to){
        E temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

}
