import hashmap.MyHashMap;
import java.util.Arrays;

public class HashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        // Check if the map is initially empty
        System.out.println("Test 1 (isEmpty): " + (map.isEmpty() == true));
        System.out.println("Test 2 (size): " + (map.size() == 0));

        // Add some key-value pairs
        map.put("foo", "bar");
        map.put("hello", "world");
        map.put("a", "1");

        // Check basic get and containsKey
        System.out.println("Test 3 (get foo): " + "bar".equals(map.get("foo")));
        System.out.println("Test 4 (get hello): " + "world".equals(map.get("hello")));
        System.out.println("Test 5 (contains hello): " + map.containsKey("hello"));
        System.out.println("Test 6 (contains nope): " + !map.containsKey("nope"));

        // Overwrite existing key
        map.put("foo", "baz");
        System.out.println("Test 7 (overwrite foo): " + "baz".equals(map.get("foo")));

        // Remove key and test again
        System.out.println("Test 8 (remove a): " + "1".equals(map.remove("a")));
        System.out.println("Test 9 (size): " + (map.size() == 2));
        System.out.println("Test 10 (remove a again): " + (map.remove("a") == null));

        // Test keySet and values output lengths
        String[] keys = map.keySet();
        String[] vals = map.values();
        System.out.println("Test 11 (keySet length): " + (keys.length == 2));
        System.out.println("Test 12 (values length): " + (vals.length == 2));

        // Check values array contains known value
        boolean hasWorld = Arrays.asList(vals).contains("world");
        System.out.println("Test 13 (values contain 'world'): " + hasWorld);

        // Add enough entries to trigger resize
        for (int i = 0; i < 50; i++) {
            map.put("k" + i, "v" + i);
        }

        // Validate post-resize behavior
        System.out.println("Test 14 (size after resize): " + (map.size() == 52));
        System.out.println("Test 15 (get k42): " + "v42".equals(map.get("k42")));
        System.out.println("Test 16 (contains k42): " + map.containsKey("k42"));
        System.out.println("Test 17 (isEmpty): " + !map.isEmpty());
    }
}