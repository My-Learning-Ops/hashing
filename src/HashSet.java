
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

    public void resiz





}
