import queue.MyQueue;

public class QueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Test 1: Enqueue
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Test 1 (enqueue + toString): " + queue.toString().equals("[A, B, C]"));

        // Test 2: Peek
        System.out.println("Test 2 (peek == A): " + queue.peek().equals("A"));

        // Test 3: Size
        System.out.println("Test 3 (size == 3): " + (queue.size() == 3));

        // Test 4: Contains
        System.out.println("Test 4 (contains B): " + queue.contains("B"));
        System.out.println("Test 5 (contains X): " + !queue.contains("X"));

        // Test 6: Dequeue
        String removed = queue.dequeue();
        System.out.println("Test 6 (dequeue == A): " + removed.equals("A"));
        System.out.println("Test 7 (toString after dequeue): " + queue.toString().equals("[B, C]"));

        // Test 8: isEmpty (should be false)
        System.out.println("Test 8 (isEmpty == false): " + !queue.isEmpty());

        // Test 9: Clear
        queue.clear();
        System.out.println("Test 9 (clear + isEmpty): " + queue.isEmpty());
        System.out.println("Test 10 (size == 0): " + (queue.size() == 0));
        System.out.println("Test 11 (toString after clear): " + queue.toString().equals("[]"));

        // Test 12: Dequeue empty
        System.out.println("Test 12 (dequeue on empty == null): " + (queue.dequeue() == null));

        // Test 13: Peek empty
        System.out.println("Test 13 (peek on empty == null): " + (queue.peek() == null));
    }
}