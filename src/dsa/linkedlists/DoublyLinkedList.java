package dsa.linkedlists;

public class DoublyLinkedList<E> {

    Node<E> head;
    Node<E> tail;
    int currentSize;

    public DoublyLinkedList() {
        this.head = null;
        this.currentSize = 0;
        this.tail = null;
    }

    class Node<E>{
        Node<E> next;
        Node<E> previous;
        E data;

        public Node(E data) {
            this.data = data;
        }
    }

    public E removeLast(){

        if (tail == null){
            return null;
        }
        E temp = tail.data;
//        Node<E> nodeBeforeLast = tail.previous;
        tail.previous.next = null;
        tail = tail.previous;
        currentSize--;
        return temp;
    }

    public void addFirst(E obj){
        Node<E> node = new Node<>(obj);
        node.next = head;
        head.previous = node;
        head = node;
    }

    public void addToTheMiddle(E obj){
        Node<E> node = new Node<>(obj);
        node.previous = node;
        node.next = node;
        currentSize++;
    }
}
