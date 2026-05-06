# Binary Search

## Problem
Given an array of integers `nums` sorted in ascending order and an integer `target`, return the index of `target` in `nums`, or `-1` if it does not exist.

You must write an algorithm with **O(log n)** runtime complexity.

LeetCode: https://leetcode.com/problems/binary-search/

---

## Steps

1. Initialize `left = 0`, `right = nums.length - 1`.
2. While `left <= right`:
   - Compute `mid = left + (right - left) / 2`.
   - If `nums[mid] == target`, return `mid`.
   - If `nums[mid] < target`, search right half: `left = mid + 1`.
   - Otherwise, search left half: `right = mid - 1`.
3. Return `-1` (target not found).

---

## Example

```
nums = [-1, 0, 3, 5, 9, 12], target = 9

Step 1: left=0, right=5, mid=2 → nums[2]=3 < 9 → left=3
Step 2: left=3, right=5, mid=4 → nums[4]=9 == 9 → return 4
```

---

## Test Cases

| nums                    | target | output |
|-------------------------|--------|--------|
| [-1, 0, 3, 5, 9, 12]   | 9      | 4      |
| [-1, 0, 3, 5, 9, 12]   | 2      | -1     |
| [5]                     | 5      | 0      |
| [5]                     | 6      | -1     |
| [1, 2, 3, 4, 5]         | 1      | 0      |
| [1, 2, 3, 4, 5]         | 5      | 4      |

---

## Complexity

| | Time | Space |
|-|------|-------|
| Binary Search | O(log n) | O(1) |
