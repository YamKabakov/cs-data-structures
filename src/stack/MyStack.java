package stack;

/**
 * A stack implementation using a singly linked list.
 * Supports typical LIFO operations: push, pop, peek, isEmpty, and size.
 */
public class MyStack {
    private Node top;     // Top of the stack
    private int size;     // Number of elements

    // Node structure for stack
    private static class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }

    // Push a value onto the stack
    public void push(String value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop the top value (and remove it)
    public String pop() {
        if (isEmpty()) return null;
        String value = top.value;
        top = top.next;
        size--;
        return value;
    }

    // Peek at the top value (without removing)
    public String peek() {
        return isEmpty() ? null : top.value;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the number of elements in the stack
    public int size() {
        return size;
    }

    // Return a string representation of the stack
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = top;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}