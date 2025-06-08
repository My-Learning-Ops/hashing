
import java.util.ArrayList;
import java.util.Arrays;


// A generic implementation of a HashSet
public class HashSet<T> {
    public ArrayList<T>[] buckets;
    public int numOfBuckets = 10;
    public int size;
    public static final double AVG_BUCKET_SIZE = 3;

    // Constructs a hash set
    public HashSet() {
        buckets = new ArrayList[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }
        size = 0;
    }

    // Return the bucket to put the item in
    public int getHash(T x, int hashSize) {
        return Math.abs(x.hashCode() % hashSize);
    }

    // Check if the object exists in the hash set
    public boolean contains(T x) {
        int hash = getHash(x, numOfBuckets);
        ArrayList<T> currentBucket = buckets[hash];
        return currentBucket.contains(x);
    }

    // Resize
    public void resize() {
        int newBucketSize = numOfBuckets * 2;
        ArrayList<T>[] newBuckets = new ArrayList[newBucketSize];

        // Create the new buckets
        for (int i = 0; i < newBucketSize; i++) {
            newBuckets[i] = new ArrayList<T>();
        }

        // Copy elements over and use new hashes
        for (int i = 0; i < numOfBuckets; i++) {
            for (T y : buckets[i]) {
                int hash = getHash(y, newBucketSize);
                newBuckets[hash].add(y);
            }
        }
        // Set the new buckets and size
        buckets = newBuckets;
        numOfBuckets = newBucketSize;
    }

    // Inserts an item into the hash set and returns true if successful
    public boolean insert(T x) {
        int hash = Math.abs(getHash(x, numOfBuckets));
        ArrayList<T> currentBucket = buckets[hash];

        if (currentBucket.contains(x)) return false;
        currentBucket.add(x);

        // Resize if collision chances are high
        if ((float) size / numOfBuckets > AVG_BUCKET_SIZE) {
            resize();
        }
        size++;
        return true;
    }

    // Removes an element from the hash set
    public boolean remove(T x) {
        int hash = getHash(x, numOfBuckets);
        ArrayList<T> currentBucket = buckets[hash];
        return currentBucket.remove(x);
    }

    // Returns the number of buckets in the hash set
    public int getNumOfBuckets() {
        return numOfBuckets;
    }

    // Returns the number of empty buckets in the hash set
    public int getNumOfEmptyBuckets() {
        int emptyBuckets = 0;
        for (ArrayList bucket : buckets) 
            if (bucket.size() == 0) emptyBuckets++;
        return emptyBuckets;
    }

    // Returns the size of the hash set
    public int size() {
        return size;
    }



}
