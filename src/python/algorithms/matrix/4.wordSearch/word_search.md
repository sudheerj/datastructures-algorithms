# **Word Search**

## **Problem Statement**
Given an m x n grid of characters and a string word, return true if word exists in the grid. Words can be constructed from letters of sequentially adjacent cells.

---

## **Examples**

### Example 1:
- **Input**: `board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"`
- **Output**: `true`

---

## **Algorithmic Approach (DFS + Backtracking)**

1. For each cell in grid:
   - If matches first character, start DFS.
2. DFS from cell:
   - Check if current character matches.
   - Mark as visited (temporarily modify).
   - Recursively check all 4 directions.
   - Backtrack (restore character).
3. Return true if any path matches complete word.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m * n * 4^L)`  
  Where L is word length.

- **Space Complexity**: `O(L)`  
  Recursion depth.
