import linkedlist.MyLinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        // Test 1: addFirst / addLast
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");
        System.out.println("Test 1 (addFirst/addLast): " + list.toString().equals("A -> B -> C -> null"));

        // Test 2: add at index
        list.add(1, "X"); // should be A -> X -> B -> C
        System.out.println("Test 2 (add at index 1): " + list.toString().equals("A -> X -> B -> C -> null"));

        // Test 3: get
        System.out.println("Test 3 (get index 2 == B): " + list.get(2).equals("B"));

        // Test 4: indexOf
        System.out.println("Test 4 (indexOf C == 3): " + (list.indexOf("C") == 3));

        // Test 5: remove
        list.remove("X");
        System.out.println("Test 5 (remove X): " + !list.contains("X"));

        // Test 6: removeAt
        String removed = list.removeAt(0); // removes A
        System.out.println("Test 6 (removeAt 0 == A): " + removed.equals("A") + ", List: " + list);

        // Test 7: reverse
        list.reverse(); // should reverse B -> C to C -> B
        System.out.println("Test 7 (reverse): " + list.toString().equals("C -> B -> null"));

        // Test 8: contains
        System.out.println("Test 8 (contains B): " + list.contains("B"));
        System.out.println("Test 8 (contains Z): " + !list.contains("Z"));

        // Test 9: size and isEmpty
        System.out.println("Test 9 (size == 2): " + (list.size() == 2));
        System.out.println("Test 9 (isEmpty == false): " + !list.isEmpty());

        // Test 10: clear
        list.clear();
        System.out.println("Test 10 (clear, isEmpty == true): " + list.isEmpty());
        System.out.println("Test 10 (clear, size == 0): " + (list.size() == 0));
        System.out.println("Test 10 (print): " + list.toString().equals("null"));
    }
}