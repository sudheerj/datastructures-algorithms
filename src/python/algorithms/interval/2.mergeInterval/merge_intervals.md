# **Merge Intervals**

## **Problem Statement**
Given an array of intervals, merge all overlapping intervals.

---

## **Examples**

### Example 1:
- **Input**: `intervals = [[1,3],[2,6],[8,10],[15,18]]`
- **Output**: `[[1,6],[8,10],[15,18]]`

### Example 2:
- **Input**: `intervals = [[1,4],[4,5]]`
- **Output**: `[[1,5]]`

---

## **Algorithmic Approach**

1. Sort intervals by start time.
2. Initialize result with first interval.
3. For each subsequent interval:
   - If overlaps with last in result: Merge by extending end.
   - Otherwise: Add as new interval.
4. Return result.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n log n)`  
  Dominated by sorting.

- **Space Complexity**: `O(n)`  
  For the result array.
