
import java.util.ArrayList;

public class HashMap {

    // Class to represent a key-value pair
    private static class Pair {
        int key;
        String value;

        // Constructs a key value pair
        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }

        // Constructs a pair with only a key
        public Pair(int key) {
            this.key = key;
        }

        // Checks if two objects are considered equal
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            return key == ((Pair) obj).key;
        }

        // Returns the 'hash code'
        @Override
        public int hashCode() {
            return key;
        }

        // To string method
        @Override
        public String toString() {
            return "Key: " + key + ", Value: " + value;
        }
    }

    public ArrayList<Pair>[] buckets;
    public int numOfBuckets = 20;
    public int size = 0;
    public static final double AVG_BUCKET_SIZE = 2;

    // Constructs the hash map
    public HashMap() {
        buckets = new ArrayList[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }
        size = 0;
    }

    // Gets the bucket index (hash) for a given key
    private int getHash(int key, int hashSize) {
        return Math.abs(key % hashSize);
    }

    // Resizes the hash map
    public void resize() {
        int newBucketSize = numOfBuckets * 2;
        ArrayList<Pair>[] newBuckets = new ArrayList[newBucketSize];
        // Create the new buckets
        for (int i = 0; i < newBucketSize; i++) {
            newBuckets[i] = new ArrayList<>();
        }

        // Copy elements over and use the new hashes
        for (int i = 0; i < numOfBuckets; i++) {
            for (Pair pair : buckets[i]) {
                int hash = getHash(pair.key, newBucketSize);
                newBuckets[hash].add(pair);
            }
        }
        buckets = newBuckets;
        numOfBuckets = newBucketSize;
    }

    // Check if the key exists in the hash map
    public boolean contains(int key) {
        int hash = getHash(key, numOfBuckets);
        ArrayList<Pair> currentBucket = buckets[hash];
        return currentBucket.contains(new Pair(key));
    }

    public boolean add(int key, String value) {
        int hash = Math.abs(getHash(key, numOfBuckets));
        ArrayList<Pair> currentBucket = buckets[hash];

        // Check if key already exists
        if (currentBucket.contains(new Pair(key))) return false;
        // If it dosent exist add new pair
        currentBucket.add(new Pair(key, value));
        size++;

        // Check if resize is needed
        if ((float) size / numOfBuckets > AVG_BUCKET_SIZE) {
            resize();
        }
        return true;
    }

    // Remove key from the hash map
    public boolean remove(int key) {
        int hash = getHash(key, numOfBuckets);
        ArrayList<Pair> currentBucket = buckets[hash];
        return currentBucket.remove(new Pair(key));
    }

    // Returns a string representation of the hash map
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buckets.length; i++) {
            sb.append((String.format("Bucket %d: ", i)));
            for (Pair pair : buckets[i]) {
                sb.append(pair.toString()).append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
