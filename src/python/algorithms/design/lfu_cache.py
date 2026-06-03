class LFUNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.freq = 1

class LFUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.min_freq = 0
        self.key_to_node = {}
        self.freq_to_nodes = {}

    def get(self, key: int) -> int:
        if key not in self.key_to_node:
            return -1
        node = self.key_to_node[key]
        self._increase_freq(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return
        if key in self.key_to_node:
            node = self.key_to_node[key]
            node.value = value
            self._increase_freq(node)
            return
        if len(self.key_to_node) == self.capacity:
            self._evict()
        node = LFUNode(key, value)
        self.key_to_node[key] = node
        self.freq_to_nodes.setdefault(1, []).append(node)
        self.min_freq = 1

    def _evict(self):
        nodes = self.freq_to_nodes[self.min_freq]
        evict_node = nodes.pop(0)
        if not nodes:
            del self.freq_to_nodes[self.min_freq]
        del self.key_to_node[evict_node.key]

    def _increase_freq(self, node):
        freq = node.freq
        self.freq_to_nodes[freq].remove(node)
        if not self.freq_to_nodes[freq]:
            del self.freq_to_nodes[freq]
            if self.min_freq == freq:
                self.min_freq += 1
        node.freq += 1
        self.freq_to_nodes.setdefault(node.freq, []).append(node)

if __name__ == "__main__":
    # Test 1
    cache = LFUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    r1 = cache.get(1)
    cache.put(3, 3)
    r2 = cache.get(2)
    r3 = cache.get(3)
    cache.put(4, 4)
    r4 = cache.get(1)
    r5 = cache.get(3)
    r6 = cache.get(4)
    print("Test 1 |", "PASS" if (r1==1 and r2==-1 and r3==3 and r4==-1 and r5==3 and r6==4) else "FAIL")
    # Test 2
    cache2 = LFUCache(2)
    cache2.put(1, 1)
    cache2.put(2, 2)
    cache2.get(1)
    cache2.put(2, 20)
    cache2.put(3, 3)
    t2r1 = cache2.get(2)
    t2r2 = cache2.get(1)
    t2r3 = cache2.get(3)
    print("Test 2 |", "PASS" if (t2r1==-1 and t2r2==1 and t2r3==3) else "FAIL")
    # Test 3
    cache3 = LFUCache(0)
    cache3.put(1, 1)
    t3r1 = cache3.get(1)
    print("Test 3 |", "PASS" if t3r1==-1 else "FAIL")
