# **Diagonal Difference**

## **Problem Statement**
Given a square matrix, calculate the absolute difference between the sums of its diagonals.

---

## **Examples**

### Example 1:
- **Input**: 
```
[[11, 2, 4],
 [4, 5, 6],
 [10, 8, -12]]
```
- **Output**: `15`
- **Explanation**: Primary diagonal = 11+5+(-12) = 4, Secondary = 4+5+10 = 19, |4-19| = 15

---

## **Algorithmic Approach**

1. Iterate through the matrix once.
2. For each index i:
   - Add `matrix[i][i]` to primary diagonal sum.
   - Add `matrix[i][n-1-i]` to secondary diagonal sum.
3. Return absolute difference.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through diagonal elements.

- **Space Complexity**: `O(1)`  
  Only two sum variables needed.
