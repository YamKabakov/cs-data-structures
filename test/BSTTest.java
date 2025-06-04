import bst.MyBinarySearchTree;

public class BSTTest {
    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();

        // Insert some key-value pairs
        tree.insert(5, "E");
        tree.insert(3, "C");
        tree.insert(7, "G");
        tree.insert(2, "B");
        tree.insert(4, "D");
        tree.insert(6, "F");
        tree.insert(1, "A");

        System.out.println("Inorder after inserts:");
        tree.inorder(); // Should print sorted by key

        System.out.println("ToString: " + tree);

        System.out.println("Test 1 (size == 7): " + (tree.size() == 7));
        System.out.println("Test 2 (contains 4): " + tree.contains(4));
        System.out.println("Test 3 (get 6 == F): " + "F".equals(tree.get(6)));
        System.out.println("Test 4 (min == 1): " + (tree.min() == 1));
        System.out.println("Test 5 (max == 7): " + (tree.max() == 7));

        tree.remove(3); // node with two children
        tree.remove(1); // leaf
        tree.remove(6); // node with one child

        System.out.println("Inorder after removals:");
        tree.inorder();

        System.out.println("ToString after remove: " + tree);
        System.out.println("Test 6 (size == 4): " + (tree.size() == 4));
        System.out.println("Test 7 (contains 3 == false): " + (!tree.contains(3)));

        System.out.println("Test 8 (isEmpty == false): " + (!tree.isEmpty()));

        // Clear everything and check empty
        tree.remove(2);
        tree.remove(4);
        tree.remove(5);
        tree.remove(7);

        System.out.println("After clearing all:");
        System.out.println("Test 9 (isEmpty == true): " + tree.isEmpty());
        System.out.println("Test 10 (size == 0): " + (tree.size() == 0));
    }
}