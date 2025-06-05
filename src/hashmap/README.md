# 🧠 MyHashMap (Hash Table with Separate Chaining)

A custom hash map implementation that stores `String` keys and values using separate chaining to resolve collisions.

---

## 🔧 Features

- `void put(String key, String value)`  
  Insert or update a key-value pair.

- `String get(String key)`  
  Retrieve the value for a given key, or `null` if not found.

- `boolean containsKey(String key)`  
  Check if a key exists.

- `String remove(String key)`  
  Remove a key and return its value.

- `int size()`  
  Return the number of key-value pairs in the map.

- `boolean isEmpty()`  
  Returns `true` if the map contains no entries.

- `String[] keySet()`  
  Returns an array of all keys in the map.

- `String[] values()`  
  Returns an array of all values in the map.

- `void resize()`  
  Automatically called when the load factor exceeds 0.75. Doubles the capacity and rehashes entries.

---

## 📌 Notes

- Collision handling is done using **separate chaining** (linked lists in buckets).
- The hash map resizes itself automatically to maintain performance.
- All operations are tested in `HashMapTest.java`.

---