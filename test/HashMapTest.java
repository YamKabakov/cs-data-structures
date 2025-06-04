import hashmap.MyHashMap;

public class HashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        // Test 1: put and get
        map.put("a", "apple");
        map.put("b", "banana");
        map.put("c", "cherry");
        System.out.println("Test 1 (get a == apple): " + "apple".equals(map.get("a")));

        // Test 2: overwrite key
        map.put("a", "apricot");
        System.out.println("Test 2 (overwrite a == apricot): " + "apricot".equals(map.get("a")));

        // Test 3: containsKey
        System.out.println("Test 3 (containsKey b): " + map.containsKey("b"));
        System.out.println("Test 3 (containsKey z): " + !map.containsKey("z"));

        // Test 4: remove
        String removed = map.remove("b");
        System.out.println("Test 4 (remove b == banana): " + "banana".equals(removed));
        System.out.println("Test 4 (containsKey b == false): " + !map.containsKey("b"));

        // Test 5: size
        System.out.println("Test 5 (size == 2): " + (map.size() == 2));

        // Test 6: isEmpty
        System.out.println("Test 6 (isEmpty == false): " + !map.isEmpty());

        // Test 7: clear manually
        map.remove("a");
        map.remove("c");
        System.out.println("Test 7 (isEmpty == true): " + map.isEmpty());
        System.out.println("Test 7 (size == 0): " + (map.size() == 0));

        // Test 8: resizing
        int initialCapacity = 16;
        int triggerResizeAt = (int)(initialCapacity * 0.75) + 1;

        for (int i = 0; i < triggerResizeAt + 5; i++) {
            map.put("key" + i, "value" + i);
        }

        boolean allPresent = true;
        for (int i = 0; i < triggerResizeAt + 5; i++) {
            String expected = "value" + i;
            String actual = map.get("key" + i);
            if (!expected.equals(actual)) {
                System.out.println("FAIL: key" + i + " expected " + expected + ", got " + actual);
                allPresent = false;
            }
        }

        System.out.println("Test 8 (Resize): " + allPresent);
        System.out.println("Test 8 (Size after resize): " + (map.size() == triggerResizeAt + 5));

        // Test 9: keySet and values
        String[] keys = map.keySet();
        String[] vals = map.values();

        boolean keyCheck = true;
        boolean valCheck = true;
        for (int i = 0; i < keys.length; i++) {
            if (!map.containsKey(keys[i])) keyCheck = false;
            if (map.get(keys[i]) == null) valCheck = false;
        }

        System.out.println("Test 9 (keySet all keys exist): " + keyCheck);
        System.out.println("Test 9 (values are not null): " + valCheck);
    }
}