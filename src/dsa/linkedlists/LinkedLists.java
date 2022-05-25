package dsa.linkedlists;

public class LinkedLists{
    private Node head;
    private Node tail;
    private int currentSize;

    public LinkedLists(){
        head = null;
        tail = null;
        currentSize = 0;
    }
    static class Node{
        Node next;
        int data;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedLists linkedLists = new LinkedLists();

        linkedLists.addFirst(3);
        linkedLists.addFirst(4);
        linkedLists.addFirst(9);
        linkedLists.addFirst(39);

        linkedLists.removeFirst();
        linkedLists.removeFirst();

//        linkedLists.addLast(4);
//        linkedLists.addLast(5);
//        linkedLists.addLast(433);



        for (int i = 0; i < linkedLists.currentSize; i++) {
            System.out.println("Values: " + linkedLists.head.data);
            linkedLists.head = linkedLists.head.next;
        }
    }

    public void addFirst(int value){
        // First create a new Node Object and pass it the incoming value...
        Node node = new Node(value);
        // Then we point our node to next to the head
        node.next = head;
        // then the head to the node...
        head = node;
        // then we increase the current size of our elements
        currentSize++;
    }

    public int removeFirst(){
       if (head == null){
           return -1;
       }
        int temp = head.data;
        if (head == tail){
           head = tail = null;
       }
        head = head.next;
        currentSize--;
        return temp;
    }

    public void addLast(int value){
        Node node = new Node(value);
        //TODO: Boundary 1. When we have an empty list, head is equal to null and tail is also equal to null.
        // to avoid null pointer exception, we make this check.
        // this makes sure we don't get null pointer exceptions.
        if (head == null){
            head = tail = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
        return;
    }
    // TODO: Another way of solving the above adding to the LAST.

    public void addLast2(int value){
        Node node = new Node(value);
        Node temp = head;
        if (head == null){
            head = node;
            currentSize++;
            return;
        }
        while (temp.next != null){
            temp = temp.next;
            temp.next = node;
            currentSize++;
        }
    }

    public int removeLast(){
        // TODO: How to delete the tail node aka the last node.
        //  You can't jump the middle of a singly linked list and delete it,
        //  the only way to be able to delete it is by going from the first item...
        //  When working with .
        if (head == null){
            return -1;
        }
        if (head == tail){
            return removeFirst();
        }
        Node current = head;
        Node previous = null;

        while(current != tail){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        currentSize--;
        return current.data;
    }
}
