# **Pacific Atlantic Water Flow**

## **Problem Statement**
Given an m x n matrix of heights, find all cells from which water can flow to both the Pacific and Atlantic oceans. Water can flow to adjacent cells with equal or lower height.

---

## **Examples**

### Example 1:
- **Input**: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
- **Output**: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

---

## **Algorithmic Approach (Reverse DFS/BFS)**

1. Instead of checking each cell, start from ocean borders.
2. DFS/BFS from Pacific border (top row, left column).
3. DFS/BFS from Atlantic border (bottom row, right column).
4. Water flows uphill in reverse (to cells with equal or higher height).
5. Cells reachable from both oceans are the answer.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m * n)`  
  Each cell visited at most twice.

- **Space Complexity**: `O(m * n)`  
  For visited sets and recursion stack.
