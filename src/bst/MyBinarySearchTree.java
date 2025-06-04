package bst;

/**
 * A balanced binary search tree that stores String values.
 * It rebalances after every insertion or removal.
 */
public class MyBinarySearchTree {
    private Node root;
    private int size;

    private static class Node {
        String value;
        Node left, right;

        Node(String value) {
            this.value = value;
        }
    }

    // Public insert method
    public void insert(String value) {
        root = insert(root, value);
        size++;
        root = rebalance(root);
    }

    // Recursive insert
    private Node insert(Node node, String value) {
        if (node == null) return new Node(value);
        if (value.compareTo(node.value) < 0) node.left = insert(node.left, value);
        else node.right = insert(node.right, value);
        return node;
    }

    // Public remove method
    public void remove(String value) {
        if (contains(value)) {
            root = remove(root, value);
            size--;
            root = rebalance(root);
        }
    }

    // Recursive remove
    private Node remove(Node node, String value) {
        if (node == null) return null;
        int cmp = value.compareTo(node.value);
        if (cmp < 0) node.left = remove(node.left, value);
        else if (cmp > 0) node.right = remove(node.right, value);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node min = findMin(node.right);
            node.value = min.value;
            node.right = remove(node.right, min.value);
        }
        return node;
    }

    // Find minimum node
    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Check if a value exists in the tree
    public boolean contains(String value) {
        return contains(root, value);
    }

    private boolean contains(Node node, String value) {
        if (node == null) return false;
        int cmp = value.compareTo(node.value);
        if (cmp == 0) return true;
        else if (cmp < 0) return contains(node.left, value);
        else return contains(node.right, value);
    }

    // Clear the tree
    public void clear() {
        root = null;
        size = 0;
    }

    // Check if tree is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return number of nodes
    public int size() {
        return size;
    }

    // Rebalance using sorted array
    private Node rebalance(Node node) {
        String[] values = toArray(node);
        return buildBalancedTree(values, 0, values.length - 1);
    }

    // Convert to sorted array
    private String[] toArray(Node node) {
        String[] result = new String[size];
        fillInOrder(node, result, new int[]{0});
        return result;
    }

    private void fillInOrder(Node node, String[] array, int[] index) {
        if (node == null) return;
        fillInOrder(node.left, array, index);
        array[index[0]++] = node.value;
        fillInOrder(node.right, array, index);
    }

    // Build balanced tree from sorted array
    private Node buildBalancedTree(String[] values, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(values[mid]);
        node.left = buildBalancedTree(values, start, mid - 1);
        node.right = buildBalancedTree(values, mid + 1, end);
        return node;
    }

    // String representation in sorted order
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        inOrderString(root, sb);
        if (sb.length() > 1) sb.setLength(sb.length() - 2); // Remove last comma
        sb.append("]");
        return sb.toString();
    }

    private void inOrderString(Node node, StringBuilder sb) {
        if (node == null) return;
        inOrderString(node.left, sb);
        sb.append(node.value).append(", ");
        inOrderString(node.right, sb);
    }
}