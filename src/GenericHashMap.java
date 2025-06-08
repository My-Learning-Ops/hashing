
import java.util.ArrayList;

// A generic implementation of a hash map
public class GenericHashMap<K, V> {

    // Class representing a generic key value pair
    private static class Pair<K, V> {
        K key;
        V value;

        // Constructs a key value pair
        Pair(K k, V v) {
            key = k;
            value = v;
        }

        // Constructs a pair with only a key
        Pair(K k) {
            key = k;
        }

        // Checks if two pair objects are considered equals
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Pair)) return false;
            //  Wildcards to cast with unknown generic types
            Pair<?, ?> other = (Pair<?, ?>) obj;
            return key.equals(other.key);
        }

        // Returns the pairs hash code based on the key
        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public String toString() {
            return "Key: " + key + ", Value: " + value;
        }

        private ArrayList<Pair<K, V>>[] buckets;
        private int numOfBuckets = 20;
        private int size = 0;
        private static final double AVG_BUCKET_SIZE = 2;

        // Constructs the generic hash map
        public GenericHashMap() {
            buckets = new ArrayList[numOfBuckets];
            for (int i = 0; i < numOfBuckets; i++) {
                buckets[i] = new ArrayList<>();
            }
            size = 0;
        }

        // Gets the bucket index (hash) for a given key
        private int getHash(K key, int hashSize) {
            return Math.abs(key.hashCode() % hashSize);
        }

        // Resizes the hash map
        public void resize() {
            int newBucketSize = numOfBuckets * 2;
            ArrayList<Pair<K, V>>[] newBuckets = new ArrayList[newBucketSize];

            // Create the new buckets
            for (int i = 0; i < newBucketSize; i++) {
                newBuckets[i] = new ArrayList<>();
            }

            // Copy elements over and use new hashes
            for (int i = 0; i < numOfBuckets; i++) {
                for (Pair<K, V> pair : buckets[i]) {
                    int hash = getHash(pair.key, newBucketSize);
                    newBuckets[hash].add(pair);
                }
            }
            // Set the new buckets and size
            buckets = newBuckets;
            numOfBuckets = newBucketSize;
        }

        public boolean contains(K key) {

        }

        public boolean add(K key, V value) {

        }

        public boolean remove(K key) {

        }







    }

}