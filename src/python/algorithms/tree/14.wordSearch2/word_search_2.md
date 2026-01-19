# **Word Search II**

## **Problem Statement**
Given an m x n board of characters and a list of words, find all words that exist in the board. Words can be constructed from letters of sequentially adjacent cells.

---

## **Examples**

### Example 1:
- **Input**: 
  - board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
  - words = ["oath","pea","eat","rain"]
- **Output**: ["eat","oath"]

---

## **Algorithmic Approach (Trie + DFS)**

1. Build Trie from all words.
2. DFS from each cell:
   - Follow Trie path as you traverse.
   - If reach end of word, add to result.
   - Mark cells as visited during path.
   - Backtrack after exploring.
3. Optimization: Remove found words from Trie.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m * n * 4^L)`  
  Where L is max word length.

- **Space Complexity**: `O(W * L)`  
  Trie for W words of length L.
