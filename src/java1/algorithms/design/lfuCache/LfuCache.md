# LFU Cache

Design and implement a data structure for Least Frequently Used (LFU) cache.

- get(key): Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
- put(key, value): Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item.

## Approach
- Use two hash maps: one for key-to-node, one for frequency-to-nodes.
- Track min frequency for quick eviction.
- On get/put, update frequency and maintain order for LRU within same frequency.

## Test Cases
| Operation                | Output | Expected | Status |
|--------------------------|--------|----------|--------|
| put(1,1), put(2,2)       |        |          |        |
| get(1)                   | 1      | 1        | PASS   |
| put(3,3)                 |        |          |        |
| get(2)                   | -1     | -1       | PASS   |
| get(3)                   | 3      | 3        | PASS   |
| put(4,4)                 |        |          |        |
| get(1)                   | -1     | -1       | PASS   |
| get(3)                   | 3      | 3        | PASS   |
| get(4)                   | 4      | 4        | PASS   |

## Links
- [Java Solution](../../java1/algorithms/design/lfuCache/LfuCache.java)
- [Python Solution](../../python/algorithms/design/lfu_cache.py)
- [JavaScript Solution](../../javascript/algorithms/design/lfuCache.js)
