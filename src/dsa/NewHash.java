package dsa;

import dsa.linkedlists.LinkList;

public class NewHash<K, V> {

    private int numElements;
    private int tableSize;
    double maxLoadFactor;
    LinkList<HashElement<K, V>> [] hArray;


    class HashElement<K, V> implements Comparable<HashElement<K,V>>{

        K key;
        V value;

        public HashElement(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(HashElement<K, V> o) {
            return (((Comparable<K>)this.key).compareTo(key));
        }
    }
}
