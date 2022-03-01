package dsa;

public class Queue {
    int[] queue;
    int firstElement;
    int lastElement;

    public Queue(int len){
        queue = new int[len];
        firstElement = -1;
        lastElement = -1;
    }
}
