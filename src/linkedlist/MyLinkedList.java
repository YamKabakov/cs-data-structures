package linkedlist;

public class MyLinkedList {
    private Node head;
    private int size;

    private class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Add to the front of the list
    public void addFirst(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Add to the end of the list
    public void addLast(String value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Remove the first occurrence of a value
    public boolean remove(String value) {
        if (head == null) return false;

        if (head.value.equals(value)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.value.equals(value)) {
            current = current.next;
        }

        if (current.next == null) return false;

        current.next = current.next.next;
        size--;
        return true;
    }

    // Check if a value exists in the list
    public boolean contains(String value) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    // Get the value at a specific index (0-based)
    public String get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    // Return the number of elements in the list
    public int size() {
        return size;
    }

    // Clear the list
    public void clear() {
        head = null;
        size = 0;
    }

    // Print all elements
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Return a string version of the list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}