# **First Missing Positive**

## **Problem Statement**
Given an unsorted integer array `nums`, return the smallest positive integer that is not present in `nums`.

---

## **Examples**

### Example 1:
- **Input**: `nums = [1, 2, 0]`
- **Output**: `3`

### Example 2:
- **Input**: `nums = [3, 4, -1, 1]`
- **Output**: `2`

### Example 3:
- **Input**: `nums = [7, 8, 9, 11, 12]`
- **Output**: `1`

---

## **Algorithmic Approach (Index Marking)**

This problem is solved using **in-place index marking**:

1. Replace all non-positive numbers and numbers greater than `n` with a placeholder (`n + 1`).
2. For each number in the array, mark its corresponding index as negative:
   - Take absolute value of the number.
   - If it's within range `[1, n]`, negate the value at index `num - 1`.
3. Find the first index with a positive value - that index + 1 is the answer.
4. If all indices are negative, return `n + 1`.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Three passes through the array.

- **Space Complexity**: `O(1)`  
  In-place modification with constant extra space.
