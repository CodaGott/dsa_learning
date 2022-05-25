package dsa.hashes;

import dsa.linkedlists.LinkList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Hash <K, V> implements HashI<K,V>{

    int numElement; //TODO Same as current size of elements in the DS.
    int tableSize;
    double maxLoadFactor;
    LinkList<HashElement<K, V>> [] hArray;

    public Hash(int tableSize) {
        numElement = 0;
        this.tableSize = tableSize;
        this.maxLoadFactor = 0.75;
        this.hArray = (LinkList<HashElement<K,V>>[]) new LinkList[tableSize];

        // TODO: This loop below is used to instantiate our hash array,
        //  so we don't have to do it anytime we add to out hashtable.
        for (int i = 0; i < tableSize; i++) {
            hArray[i] = new LinkList<HashElement<K, V>>();
        }

    }

    class HashElement<K,V> implements Comparable<HashElement<K,V>> {

       K key;
       V value;

        public HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public int compareTo(HashElement<K, V> o) {
            return (((Comparable<K>)this.key).compareTo(o.key));
        }
    }

    public boolean addElement(K key, V value){
        if (loadFactor() > maxLoadFactor){
            resizeTable(tableSize);
        }

        // Todo::: create hash element.
        HashElement<K, V> hashElement = new HashElement<>(key, value);
        // Todo::: Create a hashValue
        int hashValue = key.hashCode();
        // Todo::: make the hashValue a positive number
        hashValue = hashValue & 0x7FFFFFFF;
        // Todo::: mod the hashValue on the table size to
        //  get the index for the array we will use to add element to out linkedList.
        hashValue = hashValue % tableSize;
        // Todo::: add the element we created earlier
        hArray[hashValue].addFirst(hashElement);
        numElement++;
        return true;
    }

    public boolean removeItem(){

        int hashVal = hashCode();
        hashVal = hashVal & 0x7FFFFFFF;
        hashVal = hashVal % tableSize;

        hArray[hashVal].removeFirst();
        numElement--;
        return true;
    }

    private int resizeTable(int i) {
        return 2 * i;
    }

    private int loadFactor() {
        return tableSize / hArray.length;
    }

    public V getValue(K key){

        int hashVal = key.hashCode() & 0x7FFFFFFF % tableSize;
        for (HashElement<K, V> hashElement : hArray[hashVal]){
            if (((Comparable<K>)key).compareTo(hashElement.key)== 0){
                return hashElement.value;
            }
        }
        return null;
    }
}
