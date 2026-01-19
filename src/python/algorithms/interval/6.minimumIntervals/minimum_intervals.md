# **Minimum Intervals to Cover Range**

## **Problem Statement**
Given a range [left, right] and a list of intervals, find the minimum number of intervals needed to cover the entire range.

---

## **Examples**

### Example 1:
- **Input**: `intervals = [[1,4],[2,3],[3,4]], left = 1, right = 4`
- **Output**: `1` (interval [1,4] covers entire range)

---

## **Algorithmic Approach (Greedy)**

1. Sort intervals by start time.
2. Use greedy approach:
   - Find interval that starts at or before current position and extends furthest.
   - Move current position to that interval's end.
   - Repeat until range is covered.
3. Return -1 if impossible.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n log n)`  
  Dominated by sorting.

- **Space Complexity**: `O(1)` or `O(n)`  
  Depends on sorting implementation.
