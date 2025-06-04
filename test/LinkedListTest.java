import linkedlist.MyLinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Check initial state
        System.out.println("Test 1 (isEmpty): " + list.isEmpty());
        System.out.println("Test 2 (size): " + (list.size() == 0));

        // Add elements at the end
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("Test 3 (toString): " + list.toString().equals("[A, B, C]"));

        // Add at specific index
        list.add(1, "X");
        System.out.println("Test 4 (add at index): " + list.toString().equals("[A, X, B, C]"));

        // Get value by index
        System.out.println("Test 5 (get 2): " + "B".equals(list.get(2)));

        // Index lookup
        System.out.println("Test 6 (indexOf B): " + (list.indexOf("B") == 2));
        System.out.println("Test 7 (indexOf Z): " + (list.indexOf("Z") == -1));

        // Remove by index
        System.out.println("Test 8 (removeAt 1): " + "X".equals(list.removeAt(1)));
        System.out.println("Test 9 (after remove): " + list.toString().equals("[A, B, C]"));

        // Remove by value
        System.out.println("Test 10 (remove B): " + list.remove("B"));
        System.out.println("Test 11 (remove Z): " + !list.remove("Z"));
        System.out.println("Test 12 (after remove): " + list.toString().equals("[A, C]"));

        // Reverse the list
        list.reverse();
        System.out.println("Test 13 (reverse): " + list.toString().equals("[C, A]"));

        // Final size and empty check
        System.out.println("Test 14 (size): " + (list.size() == 2));
        System.out.println("Test 15 (isEmpty): " + !list.isEmpty());
    }
}