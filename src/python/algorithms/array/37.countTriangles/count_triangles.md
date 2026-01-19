# **Count Triangles**

## **Problem Statement**
Given an array of positive integers representing side lengths, count the number of triangles that can be formed by picking 3 different elements.

---

## **Examples**

### Example 1:
- **Input**: `nums = [10, 2, 5, 1, 8, 12]`
- **Output**: `4`

### Example 2:
- **Input**: `nums = [4, 4, 4, 4]`
- **Output**: `4`

---

## **Algorithmic Approach (Two Pointers after Sort)**

1. Sort the array.
2. Iterate from end (largest) to beginning:
   - For each element as the largest side:
   - Use two pointers (left at 0, right at i-1).
   - If left + right > current element: All pairs from left to right-1 are valid, decrement right.
   - Otherwise, increment left.
3. Return total count.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n²)`  
  Sort is O(n log n), nested loops are O(n²).

- **Space Complexity**: `O(1)`  
  In-place sort, constant extra space.
