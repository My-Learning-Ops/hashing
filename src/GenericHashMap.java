
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







    }

}