# **Set Matrix Zeroes**

## **Problem Statement**
Given an m x n integer matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

---

## **Examples**

### Example 1:
- **Input**: `[[1,1,1],[1,0,1],[1,1,1]]`
- **Output**: `[[1,0,1],[0,0,0],[1,0,1]]`

---

## **Algorithmic Approach (In-place)**

1. Use first row and first column as markers.
2. Track if first row/column originally had zeros.
3. Mark rows and columns:
   - For each cell (i,j) that is 0, set matrix[i][0] = 0 and matrix[0][j] = 0.
4. Set cells to zero based on markers.
5. Handle first row and column separately.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m * n)`  
  Two passes through the matrix.

- **Space Complexity**: `O(1)`  
  In-place using matrix itself as markers.
