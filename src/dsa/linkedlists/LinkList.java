package dsa.linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO :: > > Linked-List with Generic Programing
public class LinkList<E>{

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;


    public LinkList(){
        head = null;
        tail = null;
        currentSize = 0;
    }

    public static void main(String[] args) {
        LinkList<Object> linkList = new LinkList<>();

        linkList.addFirst(1);
    }

    class IteratorHelper implements Iterator<E>{

        Node<E> tempPointer;

        public IteratorHelper() {
            tempPointer = head;
        }

        @Override
        public boolean hasNext() {
            return tempPointer != null;
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException("No Element to return");
            }
            E val = tempPointer.data;
            tempPointer = tempPointer.next;
            return val;
        }
    }


    class Node<E>{
        E data;
        Node<E> next;

        public Node(E obj){
            data = obj;
            next = null;
        }
    }

    public void addFirst(E obj){
        // This creates a node Obj.
        Node<E> node = new Node<E>(obj);

        // We assume that a node is here already and to add another node,
        // We assign the next node to be the head.
        node.next = head;
        // then we make the new node the head.
        head = node;

        System.out.println(node.data);
//        System.out.println("Head.data = " + head.data);
        // we increase the size.
        currentSize++;
    }

    public void addLast(E obj){
        Node<E> node = new Node<E>(obj);
        // This checks if the List is empty and assigns the first item to head
        // and tail.
        // if it's not empty the block will not execute so the code outside the block executes.
        if (head == null){
            head = tail = node;
            currentSize++;
            return;
        }
        // This is how you assign Items to the back of a linked list when it's not empty.
        tail.next = node;
        tail = node;
        System.out.println("Tail,data = " + tail.data);
        currentSize++;
    }

    public E removeFirst(){
        //TODO: NOTE ==> This is for checking if the list we are removing an
        // item from is currently empty.
        if (head == null){
            return null;
        }
        E temp = head.data;
        // TODO: Note ==> This is for checking if the list we are removing an
        //  from has only 1 item in it.
        if (head == tail){
            head = tail = null;
        }
        head  = head.next;
        currentSize--;
        return temp;
    }

    public E removeLast(){
        if (head == null){
            return null;
        }
        if (head == tail){
            return removeFirst();
        }
        Node<E> current = head, previous = null;

        while(current!= tail){
            previous = current;
            current = current.next;
        }

        previous.next = null;
        tail = previous;
        currentSize--;
        return current.data;
    }


    public void addToLast(E obj){
        Node<E> node = new Node<>(obj);

        if (head == tail){
            head = tail = null;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }

   public void add(E obj){
       Node<E> node = new Node<>(obj);

       node.next = head;
       head = node;
       currentSize++;
   }

   public E remove(E obj){
        Node<E> current = head, previous = null;

        while (current != null){
            // TODO::: We use Comparable to compare objects with data.
            if (((Comparable<E>)obj).compareTo(current.data)==0){
                // TODO Current is pointing to the same item as head, so if they're same, we remove first.
                if (current == head){
                    return removeFirst();
                }

                // TODO: If current is pointing to the same data as tail, we remove last.
                if (current == tail){
                    return removeLast();
                }
                currentSize--;
                previous.next = current.next;
                return current.data;
            }
            // TODO: This is how we iterate over the items, by setting previous to current
            //  and setting current to current.next.
            previous = current;
            current = current.next;
        }
        return null;
   }

    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (((Comparable<E>) obj).compareTo(current.data) == 0) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E peekFirst(){
        if (head == null){
            return null;
        }
        return head.data;
    }

    public E peekLAstWithTail(){
        if (tail == null){
            return null;
        }
        return tail.data;
    }

    public int getListSize(){
        return currentSize;
    }
}
