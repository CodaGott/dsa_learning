package dsa.trees;

public class BinaryHeap <E>{
    int lastPosition;
    int size;
    E []array = (E[]) new Object[size];

    public BinaryHeap(int size) {
        array = (E[]) new Object[size];
    }

    public void add(E obj){
        array [++lastPosition] = obj;
        trickleUp(lastPosition);
    }

    public void swap(int from, int to){
        E tem = array[from];
        array[from] = array[to];
        array[to] = tem;
    }

    public void trickleUp(int lastPosition){
        if (lastPosition == 0){
            return;
        }
        int parent = (int) Math.floor((lastPosition - 1)/2);
        if (((Comparable<E>) array[lastPosition]).compareTo(array[parent]) > 0){
            swap(lastPosition, parent);
        }
    }

    public E remove(){
        E temp = array[0];
        swap(0, lastPosition--);
        trickleDown(0);
        return temp;
    }

    private void trickleDown(int parent) {
        int leftChild = 2 * parent + 1;
        int rightChild = 2 * parent + 2;

        if (leftChild == lastPosition && (((Comparable<E>)array[parent]).compareTo(array[leftChild])< 0)){
            swap(parent, leftChild);
            return;
        }

        if (rightChild == lastPosition && (((Comparable<E>)array[parent]).compareTo(array[rightChild])< 0)){
            swap(parent, rightChild);
            return;
        }
        if (leftChild >= lastPosition || rightChild >= lastPosition){
            return;
        }

        if (((Comparable<E>)array[leftChild]).compareTo(array[rightChild]) > 0 && (((Comparable<E>)array[parent]).compareTo(array[leftChild]) < 0)){
            swap(parent, leftChild);
            trickleDown(leftChild);
        }

        else if (((Comparable<E>)array[parent]).compareTo(array[rightChild]) < 0){
            swap(parent, rightChild);
            trickleDown(rightChild);
        }
    }
}
