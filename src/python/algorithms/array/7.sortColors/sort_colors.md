# **Sort Colors (Dutch National Flag)**

## **Problem Statement**
Given an array `nums` with `n` objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red (0), white (1), and blue (2).

---

## **Examples**

### Example 1:
- **Input**: `nums = [2, 0, 2, 1, 1, 0]`
- **Output**: `[0, 0, 1, 1, 2, 2]`

### Example 2:
- **Input**: `nums = [2, 0, 1]`
- **Output**: `[0, 1, 2]`

---

## **Algorithmic Approach (Dutch National Flag Algorithm)**

This problem is solved using the **Dutch National Flag** algorithm with three pointers:

1. Initialize three pointers: `low = 0`, `mid = 0`, and `high = len(nums) - 1`.
2. Iterate while `mid <= high`:
   - If `nums[mid] == 0`: Swap `nums[low]` and `nums[mid]`, increment both `low` and `mid`.
   - If `nums[mid] == 1`: Just increment `mid`.
   - If `nums[mid] == 2`: Swap `nums[mid]` and `nums[high]`, decrement `high` (don't increment `mid` as the swapped element needs to be checked).
3. The array is sorted when `mid > high`.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array.

- **Space Complexity**: `O(1)`  
  In-place sorting with constant extra space.
