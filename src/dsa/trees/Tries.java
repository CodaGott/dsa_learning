//package dsa.trees;
//
//public class Tries<E> {
//
//    int currentSize;
//    E root;
//
//    class Node<E> {
//        Node<E> left;
//        Node<E> right;
//        E data;
//
//        public Node(E data) {
//            this.data = data;
//            right = left = null;
//        }
//    }
//
//    private void add(E obj, Node<E> node) {
//            if (((Comparable<E>) obj).compareTo(node.data) > 0) {
//                //Here we are to check if obj is bigger than data.
//                //TODO : : : > > > and that's done here using the Comparable, if the obj
//                // compare to data is greater than zero, then we know we are
//                // adding to the right.
//                if (node.right == null) {
//                    node.right = new Node<>(obj);
//                    return;
//                }
//                add(obj, node.right);
//            }
//            if (node.left == null) {
//                node.left = new Node<>(obj);
//                return;
//            }
//            add(obj, node.left);
//        }
//
//    public void add(E obj) {
//            if (root == null) {
//                root = (E) new Node<>(obj);
//            } else {
//                add(obj);
//            }
//            currentSize++;
//        }
//}
