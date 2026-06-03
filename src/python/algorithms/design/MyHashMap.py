"""
MyHashMap - Design a HashMap without built-in hash table libraries.
LeetCode 706. Design HashMap
"""

class MyHashMap:
    def __init__(self):
        self.map = [-1] * 1000001

    def put(self, key: int, value: int) -> None:
        self.map[key] = value

    def get(self, key: int) -> int:
        return self.map[key]

    def remove(self, key: int) -> None:
        self.map[key] = -1

# Chaining with linked list
class MyHashMap1:
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.buckets = [None] * 10000

    def _hash(self, key):
        return key % len(self.buckets)

    def put(self, key, value):
        idx = self._hash(key)
        if not self.buckets[idx]:
            self.buckets[idx] = self.Node(key, value)
            return
        curr = self.buckets[idx]
        while curr:
            if curr.key == key:
                curr.value = value
                return
            if not curr.next:
                curr.next = self.Node(key, value)
                return
            curr = curr.next

    def get(self, key):
        idx = self._hash(key)
        curr = self.buckets[idx]
        while curr:
            if curr.key == key:
                return curr.value
            curr = curr.next
        return -1

    def remove(self, key):
        idx = self._hash(key)
        curr = self.buckets[idx]
        prev = None
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        if not curr:
            return
        if not prev:
            self.buckets[idx] = curr.next
        else:
            prev.next = curr.next

if __name__ == "__main__":
    print("Testing MyHashMap (Direct Addressing):")
    map = MyHashMap()
    map.put(1, 1)
    map.put(2, 2)
    print(("PASS" if map.get(1) == 1 else "FAIL"), "get(1) == 1")
    print(("PASS" if map.get(3) == -1 else "FAIL"), "get(3) == -1")
    map.put(2, 1)
    print(("PASS" if map.get(2) == 1 else "FAIL"), "get(2) == 1")
    map.remove(2)
    print(("PASS" if map.get(2) == -1 else "FAIL"), "get(2) == -1")

    print("\nTesting MyHashMap1 (Chaining):")
    map1 = MyHashMap1()
    map1.put(1, 1)
    map1.put(2, 2)
    print(("PASS" if map1.get(1) == 1 else "FAIL"), "get(1) == 1")
    print(("PASS" if map1.get(3) == -1 else "FAIL"), "get(3) == -1")
    map1.put(2, 1)
    print(("PASS" if map1.get(2) == 1 else "FAIL"), "get(2) == 1")
    map1.remove(2)
    print(("PASS" if map1.get(2) == -1 else "FAIL"), "get(2) == -1")
