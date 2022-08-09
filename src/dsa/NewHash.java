package dsa;

import dsa.linkedlists.LinkList;

import java.util.NoSuchElementException;

public class NewHash<K, V> {

    private int numElements;
    private int tableSize;
    private double maxLoadFactor;
    private LinkList<HashElement<K, V>> [] hArray;

    public NewHash(int tableSize){
        this.tableSize = tableSize;
        hArray = (LinkList<HashElement<K,V>>[]) new LinkList[tableSize];

        maxLoadFactor = 0.75;
        numElements = 0;

        for (int i = 0; i < tableSize; i++) {
            hArray[i] = new LinkList<HashElement<K, V>>();
        }
    }


    class HashElement<K, V> implements Comparable<HashElement<K,V>>{

        K key;
        V value;

        public HashElement(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(HashElement<K, V> o) {
            return (((Comparable<K>)o.key).compareTo(this.key));
        }
    }

    public boolean add(K key, V value){

        // Resize the array
        if (loadFactor() > maxLoadFactor){
            resize(tableSize * 2);
        }

        // Create a new object to add
        HashElement<K, V> hashElement = new HashElement<>(key, value);

        //index
        int hashVal = key.hashCode();
        hashVal = hashVal & 0x7fffffff;
        hashVal = hashVal % tableSize;

        // add to LinkedList
        hArray[hashVal].add(hashElement);
        numElements++;
        return true;
    }

    public boolean remove(){
        int hashVal = hashCode();
        hashVal = hashVal & 0x7fffffff;
        hashVal = hashVal % tableSize;

        hArray[hashVal].removeFirst();
        numElements--;
        return true;
    }

    public V getValue(K key){
        int hashValue = key.hashCode();

        hashValue = hashValue & 0x7fffffff;
        hashValue %= tableSize;

        for (HashElement<K, V> hashElement : hArray[hashValue]){
            if (((Comparable<K>)key).compareTo(hashElement.key) == 0){
                return hashElement.value;
            }
        }
        return null;
    }

}
