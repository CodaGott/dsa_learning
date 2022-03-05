package dsa;

public class Queue {
    int[] queue;
    int firstElement;
    int lastElement;

    public static void main(String[] args) {
        Queue queue = new Queue(4);

        queue.addToQueue(3);
        queue.addToQueue(4);
        queue.addToQueue(5);
        queue.addToQueue(6);
        queue.printQueue();
    }

    public Queue(int len){
        queue = new int[len];
        firstElement = -1;
        lastElement = -1;
    }

    public void addToQueue(int element){
        if (lastElement == queue.length - 1){
            System.out.println("Queue is full");
        }
        else {
            if (firstElement == -1)
                firstElement = 0;
                lastElement++;
            queue[lastElement] = element;
        }
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

    public void printQueue(){
        for (int queues : queue){
            System.out.println("Queue element: " + queues);
        }
    }
}
