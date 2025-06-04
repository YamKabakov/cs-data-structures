import stack.MyStack;

public class StackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        // Test 1: push
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Test 1 (push + toString): " + stack.toString().equals("[C, B, A]"));

        // Test 2: peek
        System.out.println("Test 2 (peek == C): " + stack.peek().equals("C"));

        // Test 3: size
        System.out.println("Test 3 (size == 3): " + (stack.size() == 3));

        // Test 4: contains
        System.out.println("Test 4 (contains B): " + stack.contains("B"));
        System.out.println("Test 5 (contains Z): " + !stack.contains("Z"));

        // Test 6: pop
        System.out.println("Test 6 (pop == C): " + stack.pop().equals("C"));
        System.out.println("Test 7 (toString after pop): " + stack.toString().equals("[B, A]"));

        // Test 8: isEmpty (should be false)
        System.out.println("Test 8 (isEmpty == false): " + !stack.isEmpty());

        // Test 9: clear
        stack.clear();
        System.out.println("Test 9 (clear + isEmpty): " + stack.isEmpty());
        System.out.println("Test 10 (size == 0): " + (stack.size() == 0));
        System.out.println("Test 11 (toString == []): " + stack.toString().equals("[]"));

        // Test 12: pop empty
        System.out.println("Test 12 (pop on empty == null): " + (stack.pop() == null));

        // Test 13: peek empty
        System.out.println("Test 13 (peek on empty == null): " + (stack.peek() == null));
    }
}