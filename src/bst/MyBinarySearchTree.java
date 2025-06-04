package bst;

import java.util.ArrayList;
import java.util.List;

public class MyBinarySearchTree {
    private class Node {
        int key;
        String value;
        Node left, right;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size = 0;

    public void insert(int key, String value) {
        root = insertRecursive(root, key, value);
        rebalance(); // Auto-rebalance
    }

    private Node insertRecursive(Node node, int key, String value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key < node.key) {
            node.left = insertRecursive(node.left, key, value);
        } else if (key > node.key) {
            node.right = insertRecursive(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public boolean contains(int key) {
        return containsRecursive(root, key);
    }

    private boolean containsRecursive(Node node, int key) {
        if (node == null) return false;
        if (key == node.key) return true;
        return key < node.key
            ? containsRecursive(node.left, key)
            : containsRecursive(node.right, key);
    }

    public String get(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) return current.value;
            current = key < current.key ? current.left : current.right;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void inorder() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node node) {
        if (node == null) return;
        inorderRecursive(node.left);
        System.out.print("(" + node.key + ", " + node.value + ") ");
        inorderRecursive(node.right);
    }

    public int min() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.key;
    }

    public int max() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.key;
    }

    public void remove(int key) {
        root = removeRecursive(root, key);
        rebalance(); // Auto-rebalance
    }

    private Node removeRecursive(Node node, int key) {
        if (node == null) return null;

        if (key < node.key) {
            node.left = removeRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = removeRecursive(node.right, key);
        } else {
            size--;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node successor = findMin(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node.right = removeRecursive(node.right, successor.key);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Build balanced tree from in-order list
    public void rebalance() {
        List<Node> nodes = new ArrayList<>();
        collectInOrder(root, nodes);
        root = buildBalancedTree(nodes, 0, nodes.size() - 1);
    }

    private void collectInOrder(Node node, List<Node> list) {
        if (node == null) return;
        collectInOrder(node.left, list);
        list.add(new Node(node.key, node.value));
        collectInOrder(node.right, list);
    }

    private Node buildBalancedTree(List<Node> nodes, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);
        node.left = buildBalancedTree(nodes, start, mid - 1);
        node.right = buildBalancedTree(nodes, mid + 1, end);
        return node;
    }

    @Override
    public String toString() {
        List<String> pairs = new ArrayList<>();
        toStringRecursive(root, pairs);
        return "[" + String.join(", ", pairs) + "]";
    }

    private void toStringRecursive(Node node, List<String> list) {
        if (node == null) return;
        toStringRecursive(node.left, list);
        list.add("(" + node.key + ", " + node.value + ")");
        toStringRecursive(node.right, list);
    }
}