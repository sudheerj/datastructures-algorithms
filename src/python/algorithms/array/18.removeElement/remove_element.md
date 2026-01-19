# **Remove Element**

## **Problem Statement**
Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` in-place. Return the number of elements in `nums` which are not equal to `val`.

---

## **Examples**

### Example 1:
- **Input**: `nums = [3, 2, 2, 3], val = 3`
- **Output**: `2, nums = [2, 2, _, _]`

### Example 2:
- **Input**: `nums = [0, 1, 2, 2, 3, 0, 4, 2], val = 2`
- **Output**: `5, nums = [0, 1, 3, 0, 4, _, _, _]`

---

## **Algorithmic Approach (Two Pointers)**

1. Initialize a pointer `k = 0` to track the position for non-val elements.
2. Iterate through each element in the array:
   - If the current element is not equal to `val`:
     - Place it at index `k`.
     - Increment `k`.
3. Return `k` as the count of remaining elements.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array.

- **Space Complexity**: `O(1)`  
  In-place modification with constant extra space.
