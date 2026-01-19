# **Pascal's Triangle**

## **Problem Statement**
Given an integer `numRows`, return the first `numRows` of Pascal's triangle.

---

## **Examples**

### Example 1:
- **Input**: `numRows = 5`
- **Output**: `[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]`

### Example 2:
- **Input**: `numRows = 1`
- **Output**: `[[1]]`

---

## **Algorithmic Approach**

1. Initialize an empty list for the triangle.
2. For each row from 0 to `numRows - 1`:
   - Create a row filled with 1s of size `row + 1`.
   - For each column from 1 to `row - 1`:
     - Set value to sum of two elements above: `triangle[row-1][col-1] + triangle[row-1][col]`.
   - Append the row to the triangle.
3. Return the triangle.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(numRows²)`  
  We iterate through each element in the triangle.

- **Space Complexity**: `O(numRows²)`  
  We store all elements in the triangle.
