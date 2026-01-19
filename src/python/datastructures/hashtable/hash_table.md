# Hash Table

A hash table is a data structure that implements an associative array abstract data type, a structure that can map keys to values.

## Operations

| Operation | Average Case | Worst Case | Description |
|-----------|--------------|------------|-------------|
| set       | O(1)        | O(n)       | Add/Update key-value pair |
| get       | O(1)        | O(n)       | Get value by key |
| remove    | O(1)        | O(n)       | Remove key-value pair |
| keys      | O(n)        | O(n)       | Get all keys |
| values    | O(n)        | O(n)       | Get all values |

## Collision Handling

This implementation uses **separate chaining** to handle collisions, where each bucket contains a list of key-value pairs.

## Usage

```python
from hash_table import HashTable

ht = HashTable()
ht.set("name", "John")
ht.set("age", 30)
print(ht.get("name"))  # John
print(ht.keys())       # ['name', 'age']
```
