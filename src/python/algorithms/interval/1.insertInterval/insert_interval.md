# **Insert Interval**

## **Problem Statement**
Given a sorted list of non-overlapping intervals and a new interval, insert the new interval and merge if necessary. Return the list sorted.

---

## **Examples**

### Example 1:
- **Input**: `intervals = [[1,3],[6,9]], newInterval = [2,5]`
- **Output**: `[[1,5],[6,9]]`

### Example 2:
- **Input**: `intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]`
- **Output**: `[[1,2],[3,10],[12,16]]`

---

## **Algorithmic Approach**

1. Add all intervals that end before new interval starts.
2. Merge overlapping intervals:
   - While intervals overlap with new interval, merge by updating new interval's start/end.
   - Add merged interval.
3. Add remaining intervals.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through intervals.

- **Space Complexity**: `O(n)`  
  For the result array.
