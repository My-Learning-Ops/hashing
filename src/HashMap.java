


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









}
