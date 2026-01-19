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

---

## **Algorithmic Approach (Greedy)**

1. Sort intervals by end time.
2. Track the end of last non-overlapping interval.
3. For each interval:
   - If starts before previous end: Count as removal.
   - Otherwise: Update end to current interval's end.
4. Return removal count.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n log n)`  
  Dominated by sorting.

- **Space Complexity**: `O(1)` or `O(n)`  
  Depends on sorting implementation.
