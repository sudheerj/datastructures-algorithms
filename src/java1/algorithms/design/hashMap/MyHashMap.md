# MyHashMap

## Problem
Design a HashMap without using any built-in hash table libraries.

Implement the `MyHashMap` class:
- `MyHashMap()` initializes the object.
- `void put(int key, int value)` inserts a (key, value) pair into the HashMap. If the key already exists, update the value.
- `int get(int key)` returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
- `void remove(int key)` removes the key and its corresponding value if the map contains the mapping for the key.

## Approaches

### 1. Direct Addressing (Bounded Array)
- Use a large array to directly map keys to values.
- Fast O(1) operations, but uses a lot of space if key range is large.

### 2. Chaining with Linked List
- Use an array of linked lists (buckets) to handle collisions.
- Each bucket stores key-value pairs with the same hash.
- O(1) average time for insert, get, and remove.

## Example
```java
MyHashMap map = new MyHashMap();
map.put(1, 1); // map = {1=1}
map.put(2, 2); // map = {1=1, 2=2}
System.out.println(map.get(1)); // returns 1
System.out.println(map.get(3)); // returns -1 (not found)
map.put(2, 1); // update the existing value
System.out.println(map.get(2)); // returns 1
map.remove(2); // remove the mapping for 2
System.out.println(map.get(2)); // returns -1 (not found)
```

## Complexity
- Direct Addressing: Time O(1), Space O(N) where N is the key range
- Chaining: Time O(1) average, Space O(M+K) where M is bucket count, K is number of keys

## See Also
- [LeetCode 706. Design HashMap](https://leetcode.com/problems/design-hashmap/)