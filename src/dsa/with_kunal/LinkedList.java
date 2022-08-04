package dsa.with_kunal;

public class LinkedList {
    public static void main(String[] args) {

    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public void addFirst(int val){
        Node node = new Node(val);

        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }
        size++;
    }

    public void addToLAst(int val){
        if (tail == null){
            addFirst(val);
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index){
        if (index == 0){
            addToLAst(val);
            return;
        }
        if (index == size){
            addToLAst(val);
            return;
        }

        Node temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;

        if (head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if (head == tail){
            return deleteFirst();
        }
        if (size == 0){
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public Node find(int valu){
        Node node = head;

        while (node != null){
            if (node.value == valu){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index){
        Node node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteByIndex(int index){
        if (index == 0){
            return deleteFirst();
        }
        if (index == size - 1){
            return deleteLast();
        }
        Node prev = get(index - 1);

        int val = prev.next.value;

        prev.next = prev.next.next;

        return val;
    }

    public void display(){
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }
}


class Main{
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.addFirst(47);
        ls.addFirst(6);
        ls.addFirst(4);
        ls.addFirst(9);

        ls.addToLAst(89);
        ls.insert(600, 4);


        ls.display();
        System.out.println();
        System.out.println(ls.deleteByIndex(3));
        ls.display();
    }
}
