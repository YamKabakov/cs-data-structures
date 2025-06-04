# 📘 Data Structures in Java – Built from Scratch

This project contains clean, hand-coded implementations of core data structures using Java. The goal is to build deep understanding of how these structures work under the hood — without relying on Java's built-in collections.

🧠 Ideal for learning, practicing for interviews, or showcasing CS fundamentals in a portfolio.

---

## 🧱 Implemented Data Structures

| Structure     | Description                              | Link              |
|---------------|------------------------------------------|-------------------|
| Singly Linked List | Custom implementation with insert/remove/search operations | [`MyLinkedList`](src/linkedlist) |
| Hash Map      | String-to-String hash table using separate chaining and dynamic resizing | [`MyHashMap`](src/hashmap) |

Each structure includes:
- Full method support
- Basic unit tests in `/test/`
- Explanations in subfolder `README.md`

---

## 📁 Project Layout

```
cs-data-structures/
├── src/                # Source code
│   ├── linkedlist/     # MyLinkedList.java + README
│   └── hashmap/        # MyHashMap.java + README
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

### Run specific tests:
```bash
java -cp out LinkedListTest
java -cp out HashMapTest
```

No external libraries are required. Java 8+ is recommended.

---

## 🚀 Goals of This Project

- ✅ Strengthen understanding of data structures
- ✅ Prepare for coding interviews and technical tests
- ✅ Build a strong GitHub portfolio with real code
- ✅ Practice clean coding, documentation, and testing

---

## 📌 What's Next?

This project will continue to grow with additional modules, including:

- [ ] Stack and Queue
- [ ] Binary Search Tree (BST)
- [ ] Generic versions of each structure
- [ ] JUnit-based test coverage

---

## 📬 Feedback

If you're a student, developer, or reviewer — feel free to fork, star, or submit issues. Collaboration is welcome!

---