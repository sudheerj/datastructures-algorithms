# Sort Colors (Dutch National Flag Problem)

## Description

Given an array `nums` containing `n` integers where each integer is `0` (red), `1` (white), or `2` (blue), sort the array **in-place** so that elements of the same color are adjacent and in the order: red (0), white (1), and blue (2).

**Constraints:**
- Must not use any built-in sorting functions.
- Must use constant space (`O(1)`).

---

### Examples

Example 1:

Input: nums = [2,1,0,1,2,0]
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,1,0]
Output: [0,1,2]

---

## Algorithmic Steps (Two-Pointer / Dutch National Flag)

We use a **two-pointer** approach with three indices:

- `left`: the position where the next `0` should be placed.
- `right`: the position where the next `2` should be placed.
- `i`: the current index we are evaluating.

### Steps:

1. Initialize `left = 0`, `i = 0`, and `right = nums.length - 1`.

2. Traverse the array while `i <= right`:
   - If `nums[i] == 0`:
     - Swap `nums[i]` and `nums[left]`
     - Increment both `i` and `left`
   - If `nums[i] == 2`:
     - Swap `nums[i]` and `nums[right]`
     - Decrement `right` (do **not** increment `i` here)
   - If `nums[i] == 1`:
     - Just increment `i`

3. The array will be sorted in one pass.

---

## Time and Space Complexity

- **Time Complexity:** `O(n)`  
  Each element is processed at most once.

- **Space Complexity:** `O(1)`  
  Sorting is done in-place without any additional data structures.

---
