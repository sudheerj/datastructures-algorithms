# **Meeting Rooms III**

## **Problem Statement**
Given `n` rooms numbered from `0` to `n - 1` and a list of meetings represented as `[start, end)` intervals, assign each meeting to the lowest-numbered available room. If no room is free, delay the meeting until the earliest room becomes available (maintaining the original duration). Return the room number that held the most meetings. If there is a tie, return the lowest-numbered room.

---

## **Examples**

### Example 1:
- **Input**: `n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]`
- **Output**: `0`
- **Explanation**: 
  - Meeting [0,10] → Room 0
  - Meeting [1,5] → Room 1
  - Meeting [2,7] → Both busy, Room 1 frees earliest at 5 → delayed to Room 1 [5,10]
  - Meeting [3,4] → Both busy, Room 0 frees earliest at 10 → delayed to Room 0 [10,11]
  - Room 0: 2 meetings, Room 1: 2 meetings → return `0` (lowest index tie-break)

### Example 2:
- **Input**: `n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]`
- **Output**: `1`
- **Explanation**: 
  - Meeting [1,20] → Room 0
  - Meeting [2,10] → Room 1
  - Meeting [3,5] → Room 2
  - Meeting [4,9] → Room 2 frees at 5 → assigned to Room 2 [5,10]
  - Meeting [6,8] → All busy, Room 1 frees earliest at 10 → delayed to Room 1 [10,12]
  - Room 0: 1, Room 1: 2, Room 2: 2 → return `1` (lowest index tie-break)

---

## **Algorithm**

1. Sort meetings by start time.
2. Use a **min-heap** of available room numbers and a **min-heap** of occupied rooms `(end_time, room)`.
3. For each meeting `[start, end]`:
   - Calculate the meeting duration (`end - start`).
   - Free up all rooms where `end_time <= start` and push them back to the available heap.
   - If a room is available, pop the lowest-numbered room and assign the meeting with its original end time.
   - If no room is available, pop the room that finishes earliest, delay the meeting, and assign it with `new_end = earliest_end_time + duration`.
4. Increment the booking count for the assigned room.
5. Return the room index with the maximum count (lowest index on tie).

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m log m + m log n)`  
  Sorting meetings takes `O(m log m)`. Each meeting involves heap push/pop operations of `O(log n)`.

- **Space Complexity**: `O(n)`  
  For the two heaps and the count array.
