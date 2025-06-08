


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

    private int getHash(int key, int hashSize) {
        return Math.abs(key % hashSize);
    }

    public void resize() {

    }

    public boolean contains(int x) {

    }

    public boolean add(int x, String v) {

    }

    public boolean remove(int x) {

    }

    @Override
    public String toString() {

    }









}
