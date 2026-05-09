# Sliding Window Maximum

## Problem
Given an integer array `nums` and a sliding window of size `k`, return the maximum value in each window as it moves from left to right.

LeetCode: https://leetcode.com/problems/sliding-window-maximum/

---

## Steps (Monotonic Deque)

1. Use a deque that stores **indices** in decreasing order of their values.
2. For each element at index `right`:
   - Remove from the **back** of the deque any indices whose values are smaller than `nums[right]` (they can never be the max).
   - Add `right` to the back of the deque.
   - Remove from the **front** if the index has fallen outside the window (`left > deque.front`).
   - Once the window is full (`right + 1 >= k`), record `nums[deque.front]` as the max for this window, then advance `left`.
3. Return the output array.

---

## Example

```
nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3

Window [1,3,-1]   → max = 3
Window [3,-1,-3]  → max = 3
Window [-1,-3,5]  → max = 5
Window [-3,5,3]   → max = 5
Window [5,3,6]    → max = 6
Window [3,6,7]    → max = 7

Output: [3, 3, 5, 5, 6, 7]
```

---

## Test Cases

| nums                      | k | output          |
|---------------------------|---|-----------------|
| [1, 3, -1, -3, 5, 3, 6, 7] | 3 | [3,3,5,5,6,7] |
| [1]                       | 1 | [1]             |
| [1, -1]                   | 1 | [1,-1]          |
| [9, 11]                   | 2 | [11]            |
| [4, -2]                   | 2 | [4]             |
| [1, 3, 1, 2, 0, 5]        | 3 | [3,3,2,5]       |

---

## Complexity

| | Time | Space |
|-|------|-------|
| Monotonic Deque | O(n) | O(k) |
