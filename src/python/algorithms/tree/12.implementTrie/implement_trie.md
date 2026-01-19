# **Implement Trie (Prefix Tree)**

## **Problem Statement**
Implement a trie with insert, search, and startsWith operations.

---

## **Examples**

### Example 1:
```
trie = Trie()
trie.insert("apple")
trie.search("apple")   # True
trie.search("app")     # False
trie.startsWith("app") # True
trie.insert("app")
trie.search("app")     # True
```

---

## **Algorithmic Approach**

### TrieNode:
- Dictionary of children (char → TrieNode).
- Boolean isEndOfWord flag.

### Operations:
- **Insert**: Create nodes for each character, mark end.
- **Search**: Follow nodes for each character, check end flag.
- **StartsWith**: Follow nodes for each character, return true if all exist.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m)` per operation  
  Where m is word length.

- **Space Complexity**: `O(n * m)`  
  Where n is number of words.
