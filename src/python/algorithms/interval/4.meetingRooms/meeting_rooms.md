# **Meeting Rooms**

## **Problem Statement**
Given an array of meeting time intervals, determine if a person could attend all meetings.

---

## **Examples**

### Example 1:
- **Input**: `intervals = [[0,30],[5,10],[15,20]]`
- **Output**: `false` (0-30 overlaps with others)

### Example 2:
- **Input**: `intervals = [[7,10],[2,4]]`
- **Output**: `true`

---

## **Algorithmic Approach**

1. Sort intervals by start time.
2. Check consecutive intervals for overlap:
   - If current start < previous end: Return false.
3. Return true if no overlaps found.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n log n)`  
  Dominated by sorting.

- **Space Complexity**: `O(1)` or `O(n)`  
  Depends on sorting implementation.
