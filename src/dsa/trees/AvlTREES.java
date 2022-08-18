package dsa.trees;

public class AvlTREES<T> {

    Node root;
    int currentSize;

    public AvlTREES(){
        root = null;
        currentSize = 0;
    }

    public void add (T obj){
        Node<T> node = new Node<>(obj);

        if (root == null){
            root = node;
            currentSize++;
            return;
        }
        add(root, node);
    }

    public void add (Node<T> parent, Node<T> newNode){
        if (((Comparable<T>)newNode.data).compareTo(parent.data) > 0){
            if (parent.rightChild == null){
                parent.rightChild = newNode;
                newNode.parent = parent;
                currentSize++;
            }else {
                add(parent.rightChild, newNode);
            }
        }else {
            if (parent.leftChild == null){
                parent.leftChild = newNode;
                currentSize++;
            }else {
                add(parent.leftChild, newNode);
            }
        }
        checkBalance(newNode);
    }

    public void checkBalance(Node<T> node){
        Node leftNode = node.leftChild;
        Node rightNode = node.rightChild;

        if (
                (height(node.leftChild) - height(node.rightChild) > 1)
            || (height(node.leftChild) - height(node.rightChild) < 1)) {
            reBalance(node);
        }
        if (node.parent == null){
            return;
        }
        checkBalance(node.parent);
    }

    public void reBalance(Node<T> node){
        if (height(node.leftChild) - height(node.rightChild) > 1){
            if (height(node.leftChild.leftChild) > height(node.leftChild.rightChild)){
                node = rightBalanceRotation(node);
            }else {
                node = leftBalanceRotation(node);
            }
        }else if (height(node.rightChild.leftChild) > height(node.rightChild.rightChild)){
            node = rightBalanceRotation(node);
        }
        if (node.parent == null){
            root = node;
        }
    }

    private int height(Node<T> node) {
        return node.height + 1;
    }

    public Node<T> rightLeftRotate(Node<T> node){
        node.rightChild = rightBalanceRotation(node.rightChild);
        return leftBalanceRotation(node);
    }

    public Node<T> leftRotate(Node<T> node){
        node.leftChild = leftBalanceRotation(node.leftChild);
        return rightBalanceRotation(node);
    }

    public Node<T> rightBalanceRotation(Node<T> node){
        //todo :::set a temp-pointer to grandparents left child.
        // set grandparents lef child = temp-pointer right child.
        // set temp-pointer right child to the grandparent.
        // use temp-pointer instead of grandparent.
        Node<T> tempPointer = node.leftChild;
        node.leftChild = tempPointer.rightChild;
        tempPointer.rightChild = node;
        return tempPointer;
    }

    public Node<T> leftBalanceRotation(Node<T> node){
        //todo :::set a temp-pointer to grandparents right child.
        // set grandparents right child = temp-pointer left child.
        // set temp-pointer left child to the grandparent.
        // use temp-pointer instead of grandparent.

        Node<T> tempPointer = node.rightChild;
        node.rightChild = tempPointer.leftChild;
        tempPointer.leftChild = node;
        return tempPointer;
    }

    class Node<T>{
        T data;
        Node<T> leftChild;
        Node<T> rightChild;
        Node<T> parent;
        int height;

        public Node(T data) {
            height = 0;
            this.data = data;
            parent = leftChild = rightChild = null;
        }
    }
}
