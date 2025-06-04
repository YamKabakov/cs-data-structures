package linkedlist;

public class MyLinkedList {
    private Node head;
    int size;

    private class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }

    // Add a value at the end of the list
    public void add(String value) {
        add(size, value);
    }

    // Add a value at a specific index
    public void add(int index, String value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node newNode = new Node(value);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    // Remove a value at a specific index
    public String removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node removed;
        if (index == 0) {
            removed = head;
            head = head.next;
        } else {
            Node prev = getNode(index - 1);
            removed = prev.next;
            prev.next = removed.next;
        }
        size--;
        return removed.value;
    }

    // Remove a value by content
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

    // Get value by index
    public String get(int index) {
        return getNode(index).value;
    }

    // Return index of a value
    public int indexOf(String value) {
        Node current = head;
        int i = 0;
        while (current != null) {
            if (current.value.equals(value)) return i;
            current = current.next;
            i++;
        }
        return -1;
    }

    // Reverse the list
    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Return size
    public int size() {
        return size;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    // Helper to get node at index
    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    // String representation
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}