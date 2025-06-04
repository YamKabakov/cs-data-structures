package queue;

/**
 * A basic FIFO queue implementation using a singly linked list.
 */
public class MyQueue {
    private Node front;
    private Node rear;
    private int size;

    // Inner node class
    private static class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }

    // Adds a value to the end of the queue
    public void enqueue(String value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Removes and returns the front value
    public String dequeue() {
        if (isEmpty()) return null;
        String value = front.value;
        front = front.next;
        size--;
        if (front == null) rear = null;
        return value;
    }

    // Returns the front value without removing it
    public String peek() {
        return isEmpty() ? null : front.value;
    }

    // Returns true if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the number of elements in the queue
    public int size() {
        return size;
    }

    // Removes all elements from the queue
    public void clear() {
        front = rear = null;
        size = 0;
    }

    // Checks if the queue contains a specific value
    public boolean contains(String value) {
        Node current = front;
        while (current != null) {
            if (current.value.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    // Returns a string representation from front to rear
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = front;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}