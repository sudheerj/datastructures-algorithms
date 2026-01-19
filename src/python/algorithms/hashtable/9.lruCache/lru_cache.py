"""
LRU Cache

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Time Complexity: O(1) for get and put
Space Complexity: O(capacity)
"""

from collections import OrderedDict


class LRUCache:
    """
    LRU Cache using OrderedDict.
    """
    
    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = OrderedDict()

    def get(self, key):
        if key not in self.cache:
            return -1
        
        # Move to end (most recently used)
        self.cache.move_to_end(key)
        return self.cache[key]

    def put(self, key, value):
        if key in self.cache:
            self.cache.move_to_end(key)
        self.cache[key] = value
        
        if len(self.cache) > self.capacity:
            self.cache.popitem(last=False)  # Remove least recently used


class LRUCacheManual:
    """
    LRU Cache using doubly linked list and hash map.
    """
    
    class Node:
        def __init__(self, key=0, value=0):
            self.key = key
            self.value = value
            self.prev = None
            self.next = None
    
    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = {}
        
        # Dummy head and tail
        self.head = self.Node()
        self.tail = self.Node()
        self.head.next = self.tail
        self.tail.prev = self.head
    
    def _remove(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev
    
    def _add_to_end(self, node):
        node.prev = self.tail.prev
        node.next = self.tail
        self.tail.prev.next = node
        self.tail.prev = node
    
    def get(self, key):
        if key not in self.cache:
            return -1
        
        node = self.cache[key]
        self._remove(node)
        self._add_to_end(node)
        return node.value
    
    def put(self, key, value):
        if key in self.cache:
            self._remove(self.cache[key])
        
        node = self.Node(key, value)
        self._add_to_end(node)
        self.cache[key] = node
        
        if len(self.cache) > self.capacity:
            lru = self.head.next
            self._remove(lru)
            del self.cache[lru.key]


# Test case
if __name__ == "__main__":
    cache = LRUCache(2)
    
    cache.put(1, 1)
    cache.put(2, 2)
    print(f"get(1): {cache.get(1)}")  # 1
    
    cache.put(3, 3)  # Evicts key 2
    print(f"get(2): {cache.get(2)}")  # -1
    
    cache.put(4, 4)  # Evicts key 1
    print(f"get(1): {cache.get(1)}")  # -1
    print(f"get(3): {cache.get(3)}")  # 3
    print(f"get(4): {cache.get(4)}")  # 4
