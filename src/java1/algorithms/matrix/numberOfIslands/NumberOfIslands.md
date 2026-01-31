# **Number of Islands**

## **Problem Statement**
Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.

---

## **Examples**

### Example 1:
- **Input**: 
```
grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
```
- **Output**: `1`

### Example 2:
- **Input**: 
```
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
```
- **Output**: `3`

---

## **Algorithmic Approach (DFS)**

1. Iterate through each cell in the grid.
2. When a '1' (land) is found:
   - Increment island count.
   - Use DFS to mark all connected land as visited (change to '0').
3. DFS explores all 4 directions (up, down, left, right).
4. Return total island count.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m * n)`  
  Each cell is visited at most once.

- **Space Complexity**: `O(m * n)`  
  Recursion stack in worst case (entire grid is land).
