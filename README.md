# MyLinkedList (Java)

This project implements a complete **singly linked list** in Java using `String` values. It includes both **core** and **advanced** features, making it suitable for CS students, interview preparation, and portfolio demonstration.

---

## ✅ Features Implemented

### Core Methods
- `addFirst(String value)` — Add to beginning
- `addLast(String value)` — Add to end
- `remove(String value)` — Remove by value
- `get(int index)` — Get value by index
- `contains(String value)` — Check if value exists
- `size()` — Number of elements
- `clear()` — Empty the list
- `isEmpty()` — Boolean check if empty

### Advanced Methods
- `add(int index, String value)` — Insert at index
- `removeAt(int index)` — Remove by index
- `indexOf(String value)` — Find index of value
- `reverse()` — Reverse the list in-place

---

## 🧪 Testing

All methods are tested using a basic `main()` method in:

```
test/LinkedListTest.java
```

Each test prints `true` or `false` to confirm correctness.

---

## 📂 Project Structure

```
cs-data-structures/
├── src/
│   └── linkedlist/
│       └── MyLinkedList.java
├── test/
│   └── LinkedListTest.java
├── .gitignore
├── README.md
```

---

## ▶️ How to Run

### Compile:
```bash
javac -d out src/linkedlist/MyLinkedList.java test/LinkedListTest.java
```

### Run:
```bash
java -cp out LinkedListTest
```

Expected output: a series of `true` results for each test.

---

## 📌 About

This project was built by a computer science student as part of a personal portfolio. It demonstrates both mastery of data structure fundamentals and the ability to write clean, testable, and well-structured Java code.

---

## 🧭 What's Next?

Future work may include:
- `DoublyLinkedList`
- `MyStack` and `MyQueue`
- `MyHashMap`
- Integration into a reusable Java library