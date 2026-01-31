# **Game of Life**

## **Problem Statement**
Given an m x n grid of cells where each cell is either live (1) or dead (0), compute the next state according to Conway's Game of Life rules:
1. Live cell with < 2 live neighbors dies (under-population).
2. Live cell with 2-3 live neighbors lives.
3. Live cell with > 3 live neighbors dies (over-population).
4. Dead cell with exactly 3 live neighbors becomes live (reproduction).

---

## **Examples**

### Example 1:
- **Input**: `[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]`
- **Output**: `[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]`

---

## **Algorithmic Approach (In-place with State Encoding)**

Use intermediate states to store both original and new state:
- 0: dead → dead
- 1: live → dead
- 2: dead → live
- 3: live → live

1. First pass: Encode new states based on neighbor count.
2. Second pass: Decode to final binary state (>= 2 becomes 1).

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m * n)`  
  Each cell checked with 8 neighbors.

- **Space Complexity**: `O(1)`  
  In-place modification using state encoding.
