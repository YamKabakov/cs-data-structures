package hashmap;

public class MyHashMap {
    private static class Node {
        String key;
        String value;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private int size;
    private static final double LOAD_FACTOR = 0.75;

    public MyHashMap() {
        buckets = new Node[16]; // default capacity
    }

    // Hash function to get index in bucket array
    private int getIndex(String key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // Add or update key-value pair
    public void put(String key, String value) {
        int index = getIndex(key);
        Node current = buckets[index];

        // Update existing key
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Insert new node at head
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;

        // Resize if needed
        if ((double) size / buckets.length > LOAD_FACTOR) {
            resize();
        }
    }

    // Retrieve value by key
    public String get(String key) {
        int index = getIndex(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;
    }

    // Check if key exists
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    // Remove key from map
    public String remove(String key) {
        int index = getIndex(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    // Return all keys as array
    public String[] keySet() {
        String[] keys = new String[size];
        int i = 0;
        for (Node bucket : buckets) {
            Node current = bucket;
            while (current != null) {
                keys[i++] = current.key;
                current = current.next;
            }
        }
        return keys;
    }

    // Return all values as array
    public String[] values() {
        String[] vals = new String[size];
        int i = 0;
        for (Node bucket : buckets) {
            Node current = bucket;
            while (current != null) {
                vals[i++] = current.value;
                current = current.next;
            }
        }
        return vals;
    }

    // Return number of key-value pairs
    public int size() {
        return size;
    }

    // Return whether map is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Resize the bucket array and rehash all keys
    private void resize() {
        Node[] oldBuckets = buckets;
        buckets = new Node[oldBuckets.length * 2];
        size = 0;

        for (Node bucket : oldBuckets) {
            Node current = bucket;
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }
}