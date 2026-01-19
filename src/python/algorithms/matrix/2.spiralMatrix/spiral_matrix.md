# **Spiral Matrix**

## **Problem Statement**
Given an m x n matrix, return all elements in spiral order.

---

## **Examples**

### Example 1:
- **Input**: `[[1,2,3],[4,5,6],[7,8,9]]`
- **Output**: `[1,2,3,6,9,8,7,4,5]`

---

## **Algorithmic Approach**

1. Track boundaries: top, bottom, left, right.
2. Traverse in order:
   - Left to right (top row), increment top.
   - Top to bottom (right column), decrement right.
   - Right to left (bottom row), decrement bottom.
   - Bottom to top (left column), increment left.
3. Continue while boundaries don't cross.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m * n)`  
  Visit each element once.

- **Space Complexity**: `O(1)`  
  Excluding output array.
