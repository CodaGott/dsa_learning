package dsa.trees;

public class Node<E> {

    Node root;
    int currentSize;
    E data;
    Node<E> left;
    Node<E> right;

    public Node(E data) {
        this.data = data;
        left = right = null;
    }

    private void add(E obj, Node<E> node) {
        if (((Comparable<E>) obj).compareTo(node.data) > 0) {
            //Here we are to check if obj is bigger than data.
            //TODO : : : > > > and that's done here using the Comparable, if the obj
            // compare to data is greater than zero, then we know we are
            // adding to the right.
            if (node.right == null) {
                node.right = new Node<>(obj);
                return;
            }
            add(obj, node.right);
        }
        if (node.left == null) {
            node.left = new Node<>(obj);
            return;
        }
        add(obj, node.left);
    }

    public void add(E obj) {
        if (root == null) {
            root = new Node<E>(obj);
        } else {
            add(obj);
        }
        currentSize++;
    }

    public boolean contains(E obj){
        return contains(obj, root);
    }

    private boolean contains(E obj, Node<E> node){
        if (node == null){
            return false;
        }
        if (((Comparable<E>)obj).compareTo(node.data)==0){
            return true;
        }
        if (((Comparable<E>)obj).compareTo(node.data) > 0){
            return contains(obj, node.right);
        }
        return contains(obj, node.left);
    }

    public Node<E> leftBalanceRotation(Node<E> node){
        //todo :::set a temp-pointer to grandparents right child.
        // set grandparents right child = temp-pointer left child.
        // set temp-pointer left child to the grandparent.
        // use temp-pointer instead of grandparent.

        Node<E> tempPointer = node.right;
        node.right = tempPointer.left;
        tempPointer.left = node;
        return tempPointer;
    }

    public Node<E> rightBalanceRotation(Node<E> node){
        //todo :::set a temp-pointer to grandparents left child.
        // set grandparents lef child = temp-pointer right child.
        // set temp-pointer right child to the grandparent.
        // use temp-pointer instead of grandparent.
        Node<E> tempPointer = node.left;
        node.left = tempPointer.right;
        tempPointer.right = node;
        return tempPointer;
    }

    public Node<E> rightLeftRotate(Node<E> node){
        node.right = rightBalanceRotation(node.right);
        return leftBalanceRotation(node);
    }

    public Node<E> leftRotate(Node<E> node){
        node.left = leftBalanceRotation(node.left);
        return rightBalanceRotation(node);
    }
}