package dsa.linkedlists;

public class GenericLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public GenericLinkedList(){
        head = null;
        tail = null;
        currentSize = 0;
    }


    class Node<E>{
        Node next;
        E data;

        public Node(E obj){
            data = obj;
            next = null;
        }
    }


    public void addFirst(E obj){
        Node<E> node = new Node<>(obj);

        node.next = head;

        head = node;

        currentSize++;
    }

    // TODO this gives O(n) complexity
    public void addLast (E obj){

        Node<E> tmp = head;
        Node<E> node = new Node<>(obj);

        if (currentSize == 0 || head == null){
            head=node;
            currentSize++;
            return;
//            addFirst(obj);
        }
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = node;
        currentSize++;
    }

    // Todo:: this gives constant time complexity.
    public void addLast2(E obj){
        Node<E> node = new Node<>(obj);

        if (head == null){
            head = tail = node;
            currentSize++;
            return;
        }

        tail.next = node;
        tail = node;
        currentSize++;
    }

    public E removeFirst(){
        if (head == null){
//            throw new NoSuchElementException("No data to return");
            return null;
        }
        E tmp = head.data;

        if (head == tail){
            head = tail = null;
        }else {
            head = head.next;
            currentSize--;
        }

        return tmp;
    }

    public E removeLast(){
        if (head == null){
            return null;
        }
        if (head == tail){
            return removeFirst();
        }
        Node<E> current = head, previous = null;

        while (current != tail){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        currentSize--;
        return current.data;
    }

    public E remove(E obj){
        Node<E> current = head, previous = null;

        while (current != null){
            if (((Comparable<E>) obj).compareTo(current.data) == 0){
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


    public Boolean contains(E obj){
        Node<E> current = head;
        while (current != null){
            if (((Comparable<E>)obj).compareTo(current.data)==0){
                return true;
            }
            current = current.next;
        }
        return false;
    }


}
