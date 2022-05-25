package dsa.linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public SinglyList() {
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
    }

    class Node<E>{
        E data;
        Node<E> next;

        public Node(E obj) {
            data = obj;
            this.next = null;
        }
    }


    public void addFirst(E obj){
        Node<E> node = new Node<>(obj);

        node.next = head;
        head = node;
        currentSize++;
    }

    public void addLast(E obj){
        Node<E> node = new Node<>(obj);

        if (head == tail){
            head = tail = node;
            currentSize++;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }

    public E removeFirst(){
        if (head == null){
            return null;
        }
        E temp = head.data;

        if (head == tail){
            head = tail = null;
        }
        head = head.next;
        currentSize--;
        return temp;
    }

    public E removeLast(){
        Node<E> currentPosition = head;
        Node<E> previousHead = null;

        if (head == null){
            return null;
        }
        if (head == tail){
            return removeFirst();
        }

        while (tail != currentPosition){
            previousHead = currentPosition;
            currentPosition = currentPosition.next;
        }
        previousHead.next = null;
        tail = previousHead;
        currentSize--;
        return currentPosition.data;
    }

    public E remove(E obj){
        Node<E> previous = null, current = head;

        while (current != null){
            if (((Comparable<E>)obj).compareTo(current.data)== 0){
                if (current == head){
                    return removeFirst();
                }
                if (current == tail){
                    return removeLast();
                }
                currentSize--;
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public E peekFirst(){
        if (head == null){
            return null;
        }
        return head.data;
    }

    public E peekLast(){
        if (tail == null){
            return null;
        }
        return tail.data;
    }


    class IteratorHelper implements Iterator<E>{

        Node<E> tempPointer;

        public IteratorHelper(){
            tempPointer = head;
        }

        @Override
        public boolean hasNext() {
            return tempPointer != null;
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException("No more elements in the list");
            }
            E val = tempPointer.data;
            tempPointer = tempPointer.next;
            return val;
        }
    }
}
