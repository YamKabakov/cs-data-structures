import bst.MyBinarySearchTree;

public class BSTTest {
    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();

        // Test 1: insert
        tree.insert("M");
        tree.insert("B");
        tree.insert("T");
        tree.insert("A");
        tree.insert("C");
        System.out.println("Test 1 (insert + toString): " + tree.toString().equals("[A, B, C, M, T]"));

        // Test 2: contains
        System.out.println("Test 2 (contains B): " + tree.contains("B"));
        System.out.println("Test 3 (contains Z): " + !tree.contains("Z"));

        // Test 4: remove leaf
        tree.remove("A");
        System.out.println("Test 4 (remove leaf A): " + tree.toString().equals("[B, C, M, T]"));

        // Test 5: remove node with one child
        tree.remove("B");
        System.out.println("Test 5 (remove node B): " + tree.toString().equals("[C, M, T]"));

        // Test 6: remove node with two children
        tree.insert("B");
        tree.insert("A");
        tree.remove("C");
        System.out.println("Test 6 (remove node with two children C): " + tree.toString().equals("[A, B, M, T]"));

        // Test 7: isEmpty
        System.out.println("Test 7 (isEmpty == false): " + !tree.isEmpty());

        // Test 8: clear
        tree.clear();
        System.out.println("Test 8 (clear + isEmpty): " + tree.isEmpty());
        System.out.println("Test 9 (toString after clear): " + tree.toString().equals("[]"));
    }
}