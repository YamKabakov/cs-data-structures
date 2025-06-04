import stack.MyStack;

public class StackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        // Initial state
        System.out.println("Test 1 (isEmpty): " + (stack.isEmpty() == true));
        System.out.println("Test 2 (size): " + (stack.size() == 0));

        // Push values
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Test 3 (toString): " + stack.toString().equals("[C, B, A]"));
        System.out.println("Test 4 (size): " + (stack.size() == 3));
        System.out.println("Test 5 (isEmpty): " + (stack.isEmpty() == false));

        // Peek at top
        System.out.println("Test 6 (peek): " + "C".equals(stack.peek()));
        System.out.println("Test 7 (size after peek): " + (stack.size() == 3));

        // Pop elements
        System.out.println("Test 8 (pop): " + "C".equals(stack.pop()));
        System.out.println("Test 9 (after pop): " + stack.toString().equals("[B, A]"));
        System.out.println("Test 10 (peek): " + "B".equals(stack.peek()));

        // Clear stack
        stack.pop();
        stack.pop();
        System.out.println("Test 11 (empty after pops): " + stack.isEmpty());
        System.out.println("Test 12 (pop on empty): " + (stack.pop() == null));
        System.out.println("Test 13 (peek on empty): " + (stack.peek() == null));
    }
}