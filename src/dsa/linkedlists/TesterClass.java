package dsa.linkedlists;

public class TesterClass {

    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<Integer>();
        int n = 10;

        for (int i = 0; i < n; i++) {
            list.addFirst(i);
        }
    }
}
