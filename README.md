# 📘 Data Structures in Java – Built from Scratch

This project contains clean, hand-coded implementations of core data structures using Java. The goal is to build deep understanding of how these structures work under the hood — without relying on Java's built-in collections.

🧠 Ideal for learning, practicing for interviews, or showcasing CS fundamentals in a portfolio.

---

## 🧱 Implemented Data Structures

| Structure              | Description                                                      | Link                 |
|------------------------|------------------------------------------------------------------|----------------------|
| Singly Linked List     | Custom implementation with insert/remove/search operations       | [`MyLinkedList`](src/linkedlist) |
| Hash Map               | Hash table with separate chaining and dynamic resizing           | [`MyHashMap`](src/hashmap)       |
| Binary Search Tree     | Balanced BST with auto-rebalancing on insert/remove              | [`MyBinarySearchTree`](src/bst)  |

Each structure includes:
- Full method support
- Manual test coverage in `/test/`
- Explanation in its own subfolder `README.md`

---

## 📁 Project Layout

```
cs-data-structures/
├── src/
│   ├── linkedlist/     # MyLinkedList.java + README
│   ├── hashmap/        # MyHashMap.java + README
│   └── bst/            # MyBinarySearchTree.java + README
├── test/               # Manual test files
├── out/                # Compiled output (.class files)
└── README.md           # Project overview (this file)
```

---

## 🛠️ How to Compile and Run

### Compile all source and test files:
```bash
javac -d out -cp src $(find src test -name "*.java")
```

### Run test classes:
```bash
java -cp out LinkedListTest
java -cp out HashMapTest
java -cp out BSTTest
```

---

## 🚀 Goals of This Project

- ✅ Master internal mechanics of data structures  
- ✅ Prepare for coding interviews and technical screenings  
- ✅ Build a strong GitHub portfolio with self-contained projects  
- ✅ Practice clean code, testing, and modularity

---

## 📌 What's Next?

This project will continue to grow with:

- [ ] MyStack (LIFO)
- [ ] MyQueue (FIFO)
- [ ] JUnit-based testing
- [ ] Optional AVL or Red-Black Tree versions

---

## 📬 Feedback

If you're a student, developer, or reviewer — feel free to fork, star, or submit issues. Collaboration is welcome!

---