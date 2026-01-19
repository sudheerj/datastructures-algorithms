# **Design Add and Search Words Data Structure**

## **Problem Statement**
Design a data structure that supports adding words and searching with wildcards (`.` matches any letter).

---

## **Examples**

### Example 1:
```
wordDict = WordDictionary()
wordDict.addWord("bad")
wordDict.addWord("dad")
wordDict.addWord("mad")
wordDict.search("pad")  # False
wordDict.search("bad")  # True
wordDict.search(".ad")  # True
wordDict.search("b..")  # True
```

---

## **Algorithmic Approach**

### Structure:
- Use Trie with TrieNodes.

### Add Word:
- Standard Trie insert.

### Search:
- For regular characters: Follow child if exists.
- For `.`: Try all children (DFS/recursion).
- Return true if any path reaches end.

---

## **Time and Space Complexity**

- **Add**: `O(m)` where m is word length.
- **Search**: `O(m)` for no wildcards, `O(26^m)` worst case with wildcards.
- **Space**: `O(n * m)` for n words of average length m.
