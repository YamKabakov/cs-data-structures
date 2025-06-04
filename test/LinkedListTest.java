import linkedlist.MyLinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Test 1: Add elements
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");
        System.out.println("Test 1 (print list): " + list.toString().equals("A -> B -> C -> null"));

        // Test 2: Size
        System.out.println("Test 2 (size == 3): " + (list.size() == 3));

        // Test 3: Contains existing value
        System.out.println("Test 3 (contains B): " + list.contains("B"));

        // Test 4: Remove value
        list.remove("B");
        System.out.println("Test 4 (removed B, contains B == false): " + !list.contains("B"));

        // Test 5: Get value by index
        System.out.println("Test 5 (get index 1 == C): " + list.get(1).equals("C"));

        // Test 6: Clear list
        list.clear();
        System.out.println("Test 6 (cleared, size == 0): " + (list.size() == 0));

        // Optional: Print list visually
        System.out.println("Final list: " + list.toString());
    }
}