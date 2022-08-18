package dsa.trees;

public class RedBlackTree <K, V> implements RedBlackI<K, V>{

    Node<K, V> root;
    int currentSize;

    public void add(K key, V value){
        Node<K, V> node = new Node<>(key, value);
        if (root == null){
            root = node;
            root.black = true;
            currentSize++;
            return;
        }
        add(key, value);
        currentSize++;
    }

    private void add(Node<K, V> parent, Node<K, V> newNode){
        if (((Comparable<K>)newNode.key).compareTo(parent.key) > 0){
            if (parent.rightChild == null){
                parent.rightChild = newNode;
                newNode.parent = parent;
                newNode.isLeftChild = false;
                return;
            }
            add(parent.rightChild, newNode);
            return;
        }
        if (parent.leftChild == null){
            parent.leftChild = newNode;
            newNode.parent = parent;
            newNode.isLeftChild = true;
            return;
        }
        add(parent.leftChild, newNode);
        checkColor(newNode);
    }

    public void checkColor(Node<K, V> node) {
        if (node == root){
            return;
        }
        if (!node.black && !node.parent.black){
            correctTree(node);
        }
        checkColor(node.parent);
    }

    public void correctTree(Node<K, V> node) {
        if (node.parent.isLeftChild){
            // aunt is node parent.parent.right
            if (node.parent.parent == null
                    || node.parent.parent.rightChild.black){

                rotate(node);
                return;
            }
            if (node.parent.parent.rightChild != null){
                node.parent.parent.rightChild.black = true;
            }
            node.parent.parent.black = false;
            node.parent.black = true;
            return;
        }
        // aunt is node parent.parent.left
        if (node.parent.parent == null
                || node.parent.parent.leftChild.black){

            rotate(node);
            return;
        }
        if (node.parent.parent.leftChild != null){
            node.parent.parent.leftChild.black = true;
        }
        node.parent.parent.black = false;
        node.parent.black = true;
        return;
    }

    public void rotate(Node<K,V> node) {
        if (node.isLeftChild){
            if (node.parent.isLeftChild){
                rightRotate(node.parent.parent);
                node.black = false;
                node.parent.black = true;
                if (node.parent.rightChild != null){
                    node.parent.rightChild.black = false;
                }
                return;
            }
            rightLeftRotate(node.parent.parent);
            node.black = true;
            node.rightChild.black = false;
            node.leftChild.black = false;
            return;
        }

        if (!node.isLeftChild){
            if (!node.parent.isLeftChild){
                leftRotate(node.parent.parent);
                node.black = false;
                node.parent.black = true;
                if (node.parent.leftChild != null){
                    node.parent.leftChild.black = false;
                }
                return;
            }
            leftRightRotate(node.parent.parent);
            node.black = true;
            node.rightChild.black = false;
            node.leftChild.black = false;
            return;
        }
    }

    private void rightLeftRotate(Node<K,V> node) {
        rightRotate(node);
        leftRotate(node);
    }

    private void rightRotate(Node<K,V> node) {
        Node<K, V> temp = node.rightChild;
        node.leftChild = temp.rightChild;
        if (node.leftChild != null){
            node.leftChild.parent = node;
            node.isLeftChild = false;
        }
        if (node.parent == null){
            //we are the root node
            root = temp;
            temp.parent = null;
        }else {
            // if we are not the root node
            temp = node.parent;
            if (!node.isLeftChild){
                temp.isLeftChild = false;
                temp.parent.rightChild = temp;
            }else {
                temp.rightChild.isLeftChild = false;
                temp.parent.leftChild = temp;
            }
            temp.rightChild = node;
            node.isLeftChild = false;
            node.parent = temp;
        }
    }

    private void leftRightRotate(Node<K,V> node) {
        leftRotate(node);
        rightRotate(node);

    }

    private void leftRotate(Node<K,V> node) {
        Node<K, V> temp = node.rightChild;
        node.rightChild = temp.leftChild;
        if (node.rightChild != null){
            node.rightChild.parent = node;
            node.rightChild.isLeftChild = false;
        }
        if (node.parent == null){
            //we are the root node
            root = temp;
            temp.parent = null;
        }else {
            // if we are not the root node
            temp = node.parent;
            if (node.isLeftChild){
                temp.isLeftChild = true;
                temp.parent.leftChild = temp;
            }else {
                temp.isLeftChild = false;
                temp.parent.rightChild = temp;
            }
            temp.leftChild = node;
            node.isLeftChild = true;
            node.parent = temp;
        }
    }


    class Node<K, V>{
        K key;
        V value;
        Node<K, V> leftChild, rightChild, parent;
        boolean isLeftChild, black;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            leftChild = rightChild = parent = null;
            black = false;
            isLeftChild = false;
        }
    }
}
