package bst;

public class MyBinarySearchTree {
    private static class Node {
        int key;
        String value;
        Node left, right;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    // Insert key-value into tree and rebalance
    public void insert(int key, String value) {
        root = insert(root, key, value);
        size++;
        root = rebalance(root); // automatic rebalance after modification
    }

    private Node insert(Node node, int key, String value) {
        if (node == null) return new Node(key, value);
        if (key < node.key) node.left = insert(node.left, key, value);
        else node.right = insert(node.right, key, value);
        return node;
    }

    // Get value by key
    public String get(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) return current.value;
            current = key < current.key ? current.left : current.right;
        }
        return null;
    }

    // Check if key exists
    public boolean contains(int key) {
        return get(key) != null;
    }

    // Return smallest key in tree
    public int min() {
        Node current = root;
        if (current == null) throw new IllegalStateException();
        while (current.left != null) current = current.left;
        return current.key;
    }

    // Return largest key in tree
    public int max() {
        Node current = root;
        if (current == null) throw new IllegalStateException();
        while (current.right != null) current = current.right;
        return current.key;
    }

    // Remove key from tree and rebalance
    public void remove(int key) {
        root = remove(root, key);
        size--;
        root = rebalance(root);
    }

    private Node remove(Node node, int key) {
        if (node == null) return null;

        if (key < node.key) {
            node.left = remove(node.left, key);
        } else if (key > node.key) {
            node.right = remove(node.right, key);
        } else {
            // Case: 0 or 1 child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Case: 2 children
            Node successor = findMin(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node.right = remove(node.right, successor.key);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Inorder traversal print
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print("(" + node.key + ", " + node.value + ") ");
        inorder(node.right);
    }

    // Return number of elements
    public int size() {
        return size;
    }

    // Return whether tree is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Rebalance tree using sorted array
    private Node rebalance(Node node) {
        if (node == null) return null;

        // Collect keys and values into array
        int n = countNodes(node);
        int[] keys = new int[n];
        String[] values = new String[n];
        fillInorder(node, keys, values, new int[]{0});

        // Build balanced BST
        return buildBalanced(keys, values, 0, n - 1);
    }

    private int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private void fillInorder(Node node, int[] keys, String[] values, int[] i) {
        if (node == null) return;
        fillInorder(node.left, keys, values, i);
        keys[i[0]] = node.key;
        values[i[0]] = node.value;
        i[0]++;
        fillInorder(node.right, keys, values, i);
    }

    private Node buildBalanced(int[] keys, String[] values, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        Node node = new Node(keys[mid], values[mid]);
        node.left = buildBalanced(keys, values, low, mid - 1);
        node.right = buildBalanced(keys, values, mid + 1, high);
        return node;
    }

    // String representation of tree in inorder
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        buildString(root, sb);
        if (sb.length() > 1) sb.setLength(sb.length() - 2); // remove trailing comma
        sb.append("]");
        return sb.toString();
    }

    private void buildString(Node node, StringBuilder sb) {
        if (node == null) return;
        buildString(node.left, sb);
        sb.append("(").append(node.key).append(", ").append(node.value).append("), ");
        buildString(node.right, sb);
    }
}