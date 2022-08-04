package dsa.linkedlists;

public class GenericDoublyLinkedList<E> {

    private Node tail;
    private Node head;
    private int size;


    class Node<E>{
        Node<E> preivous;
        Node<E> next;
        E data;

        public Node(E data) {
            preivous = null;
            next = null;
            this.data = data;
        }
    }

    public void addFirstToDoublyList(E object){
        Node<E> node = new Node<>(object);

        node.next = head;
        node.preivous = null;
        if (head.preivous != null) {
            head.preivous = node;
        }
        head = node;
    }

    public void display(){
        Node node = head;

        while (node != null){
            System.out.println(node.data + " -> ");
        }
    }
}
