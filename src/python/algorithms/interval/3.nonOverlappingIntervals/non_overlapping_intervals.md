# **Non-Overlapping Intervals**

## **Problem Statement**
Given an array of intervals, return the minimum number of intervals you need to remove to make the rest non-overlapping.

---

## **Examples**

### Example 1:
- **Input**: `intervals = [[1,2],[2,3],[3,4],[1,3]]`
- **Output**: `1` (Remove [1,3])

### Example 2:
- **Input**: `intervals = [[1,2],[1,2],[1,2]]`
- **Output**: `2`

### Example 3:
- **Input**: `intervals = [[1,2],[2,3]]`
- **Output**: `0`

---

## **Algorithmic Approach (Greedy)**

1. If the intervals list is empty, return `0`.
2. Sort intervals by start time (i.e, `key=lambda x: x[0]`).
3. Initialize `min_remove_count` to `0` and `prev_end` to the end of the first interval.
4. Iterate through the remaining intervals starting from the second one:
   - If the current interval's start is greater than or equal to `prev_end` (no overlap), update `prev_end` to the current interval's end.
   - Otherwise (overlap detected), increment `min_remove_count` by `1` and update `prev_end` to the minimum of `prev_end` and the current interval's end (greedily keep the interval that ends earlier).
5. Return `min_remove_count`.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n log n)`, where `n` is the number of intervals. Dominated by sorting.

- **Space Complexity**: `O(1)`, as only a few variables are used beyond the input (sorting is in-place).
