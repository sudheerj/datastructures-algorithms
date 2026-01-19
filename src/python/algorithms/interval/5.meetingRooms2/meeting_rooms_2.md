# **Meeting Rooms II**

## **Problem Statement**
Given an array of meeting time intervals, find the minimum number of conference rooms required.

---

## **Examples**

### Example 1:
- **Input**: `intervals = [[0,30],[5,10],[15,20]]`
- **Output**: `2`

### Example 2:
- **Input**: `intervals = [[7,10],[2,4]]`
- **Output**: `1`

---

## **Algorithmic Approach**

### Min Heap:
1. Sort by start time.
2. Use min heap to track end times of ongoing meetings.
3. For each meeting:
   - Remove ended meetings (heap top <= current start).
   - Add current meeting's end time.
   - Track max heap size.

### Two Pointers:
1. Separate and sort start and end times.
2. Use two pointers to track rooms needed.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n log n)`  
  Sorting and heap operations.

- **Space Complexity**: `O(n)`  
  For the heap.
