package dsa;

import dsa.linkedlists.GenericLinkedList;

public class Main {

    public static void main(String[] args) {

        GenericLinkedList<Integer> list = new GenericLinkedList<Integer>();

        int num = 10;

        for (int i = 0; i <= num; i++) {
            list.addFirst(i);
            System.out.println(list);
        }

    }
}


