# 🌲 MyBinarySearchTree (BST)

A fully functional Binary Search Tree (BST) implementation using `int` keys and `String` values. The tree auto-rebalances on each insert and delete to maintain efficiency.

---

## 🔧 Features

- `void insert(int key, String value)`  
  Inserts a key-value pair into the tree. Updates value if key already exists.

- `String get(int key)`  
  Retrieves the value associated with a key.

- `boolean contains(int key)`  
  Returns true if the key exists in the tree.

- `void remove(int key)`  
  Deletes a node by key (handles all 3 BST cases).

- `int size()`  
  Returns the number of nodes in the tree.

- `boolean isEmpty()`  
  Returns true if the tree is empty.

  - `clear()`
    Removes all elements from the tree.

- `int min()` / `int max()`  
  Returns the smallest/largest key in the tree.

- `void inorder()`  
  Prints key-value pairs in sorted (ascending) order.

- `void rebalance()`  
  Public method that rebalances the tree.  
  ⚠️ Called automatically on every insert/remove.

- `String toString()`  
  Returns a formatted in-order string like:  
  `[(1, A), (3, B), (5, C)]`

---

## 📌 Notes

- Automatically balances itself after every structural modification.
- Uses recursive logic for most operations.
- All operations are tested in `BSTTest.java`.

---

## 🧪 Future Enhancements

- Add height/balance-factor utilities
- Optional AVL or Red-Black Tree extension

---