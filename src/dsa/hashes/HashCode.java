//package dsa.hashes;
//
//public class HashCode<K, V> {
//
//
//    public static void main(String[] args) {
//        hashCode("one");
//    }
//
//    public static int hashCode(String s){
//        int g = 31;
//        int hash = 0;
//        for (int i = 0; i < s.length(); i++) {
//            hash = g * hash + s.charAt(i);
//        }
//        System.out.println("Hash: " + hash);
//        return hash;
//    }
//
//
//    class HashElement<K, V> implements Comparable<HashElement<K, V>>{
//        @Override
//        public int compareTo(HashCode<K, V>.HashElement<K, V> o) {
//            return 0;
//        }
//    }
//}
