import linkedlist.MyLinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Test 1: add(index, value)
        list.add(0, "A");
        list.add(1, "B");
        list.add(1, "C");
        System.out.println("Test 1 (add at index): " + list.toString().equals("[A, C, B]"));

        // Test 2: get(index)
        System.out.println("Test 2 (get index 1 == C): " + list.get(1).equals("C"));

        // Test 3: removeAt(index)
        System.out.println("Test 3 (removeAt index 1 == C): " + list.removeAt(1).equals("C"));
        System.out.println("Test 4 (toString after removeAt): " + list.toString().equals("[A, B]"));

        // Test 5: indexOf(value)
        System.out.println("Test 5 (indexOf B == 1): " + (list.indexOf("B") == 1));
        System.out.println("Test 6 (indexOf Z == -1): " + (list.indexOf("Z") == -1));

        // Test 7: isEmpty
        System.out.println("Test 7 (isEmpty == false): " + !list.isEmpty());

        // Test 8: reverse
        list.reverse();
        System.out.println("Test 8 (reverse): " + list.toString().equals("[B, A]"));

        // Test 9: size
        System.out.println("Test 9 (size == 2): " + (list.size() == 2));

        // Test 10: clear
        list.clear();
        System.out.println("Test 10 (clear + isEmpty): " + list.isEmpty());
        System.out.println("Test 11 (size == 0): " + (list.size() == 0));
        System.out.println("Test 12 (toString == []): " + list.toString().equals("[]"));
    }
}