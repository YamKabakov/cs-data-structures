package linkedlist;

public class MyLinkedList<T> {
    private Node head;
    private int size;

    private class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(T value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T value) {
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

    public boolean remove(T value) {
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

    public boolean contains(T value) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

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

    public void add(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(value);
            return;
        }

        Node newNode = new Node(value);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            T value = head.value;
            head = head.next;
            size--;
            return value;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        T value = current.next.value;
        current.next = current.next.next;
        size--;
        return value;
    }

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

    public int indexOf(T value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value.equals(value)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}