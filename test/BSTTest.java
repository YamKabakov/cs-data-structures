import bst.MyBinarySearchTree;

public class BSTTest {
    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();

        // Check initial state
        System.out.println("Test 1 (isEmpty): " + tree.isEmpty());
        System.out.println("Test 2 (size): " + (tree.size() == 0));

        // Insert several key-value pairs
        tree.insert(5, "E");
        tree.insert(3, "C");
        tree.insert(7, "G");
        tree.insert(2, "B");
        tree.insert(4, "D");
        tree.insert(6, "F");
        tree.insert(1, "A");

        // Confirm expected structure and values
        System.out.println("Test 3 (toString contains 1): " + tree.toString().contains("(1, A)"));
        System.out.println("Test 4 (get 6): " + "F".equals(tree.get(6)));
        System.out.println("Test 5 (contains 4): " + tree.contains(4));
        System.out.println("Test 6 (contains 10): " + !tree.contains(10));
        System.out.println("Test 7 (min): " + (tree.min() == 1));
        System.out.println("Test 8 (max): " + (tree.max() == 7));

        // Remove nodes (2 children, leaf, 1 child)
        tree.remove(3);
        tree.remove(1);
        tree.remove(6);
        String afterRemovals = tree.toString();
        boolean no3 = !afterRemovals.contains("(3, C)");
        boolean no1 = !afterRemovals.contains("(1, A)");
        boolean no6 = !afterRemovals.contains("(6, F)");
        System.out.println("Test 9 (remove nodes): " + (no3 && no1 && no6));

        // Check size and not empty
        System.out.println("Test 10 (size): " + (tree.size() == 4));
        System.out.println("Test 11 (isEmpty): " + !tree.isEmpty());

        // Clear the rest
        tree.remove(2);
        tree.remove(4);
        tree.remove(5);
        tree.remove(7);
        System.out.println("Test 12 (final size): " + (tree.size() == 0));
        System.out.println("Test 13 (isEmpty): " + tree.isEmpty());
    }
}