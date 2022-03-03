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

    public void addToQueue(int element){
        if (lastElement == queue.length - 1){
            System.out.println("Queue is full");
        }

        if (firstElement == -1){
            firstElement = 0; lastElement = 0;
            queue[0] = element;
        }
        lastElement++;
        queue[lastElement] = element;
    }

    public int removeFromQueue(){
        if (firstElement == -1){
            System.out.println("Queue is empty");
            return -1;
        }
        if (firstElement == lastElement){
            int temp = queue[lastElement];
            firstElement = -1 ;
            lastElement = -1;
            return temp;
        }
        int deleteFromQueue = queue[firstElement];
        firstElement++;
        return deleteFromQueue;
    }
}
