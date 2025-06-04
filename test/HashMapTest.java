import hashmap.MyHashMap;

public class HashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        // Test 1: put
        map.put("A", "Apple");
        map.put("B", "Banana");
        map.put("C", "Cherry");
        System.out.println("Test 1 (put + size == 3): " + (map.size() == 3));

        // Test 2: get
        System.out.println("Test 2 (get A == Apple): " + map.get("A").equals("Apple"));

        // Test 3: containsKey
        System.out.println("Test 3 (containsKey B == true): " + map.containsKey("B"));
        System.out.println("Test 4 (containsKey Z == false): " + !map.containsKey("Z"));

        // Test 5: remove
        System.out.println("Test 5 (remove B == Banana): " + map.remove("B").equals("Banana"));
        System.out.println("Test 6 (size after remove == 2): " + (map.size() == 2));

        // Test 7: resize
        for (int i = 0; i < 20; i++) map.put("K" + i, "V" + i);
        System.out.println("Test 7 (resize triggered, size > 16): " + (map.size() > 16));

        // Test 8: keySet
        String[] keys = map.keySet();
        boolean found = false;
        for (String key : keys) {
            if (key.equals("A")) found = true;
        }
        System.out.println("Test 8 (keySet contains A): " + found);

        // Test 9: values
        String[] vals = map.values();
        boolean hasValue = false;
        for (String v : vals) {
            if (v.equals("Apple")) hasValue = true;
        }
        System.out.println("Test 9 (values contains Apple): " + hasValue);
    }
}