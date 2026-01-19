# **Find All Numbers Disappeared in an Array**

## **Problem Statement**
Given an array `nums` of `n` integers where `nums[i]` is in the range `[1, n]`, return an array of all integers in the range `[1, n]` that do not appear in `nums`.

---

## **Examples**

### Example 1:
- **Input**: `nums = [4, 3, 2, 7, 8, 2, 3, 1]`
- **Output**: `[5, 6]`

### Example 2:
- **Input**: `nums = [1, 1]`
- **Output**: `[2]`

---

## **Algorithmic Approach (Index Marking)**

1. For each number in the array:
   - Get the index it maps to: `index = abs(nums[i]) - 1`.
   - If `nums[index]` is positive, negate it to mark as seen.
2. Iterate through the array:
   - If `nums[i]` is positive, then `i + 1` is missing.
3. Return all missing numbers.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Two passes through the array.

- **Space Complexity**: `O(1)`  
  Excluding the output array, only constant extra space is used.
