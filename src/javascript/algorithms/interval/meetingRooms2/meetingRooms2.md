**Problem:**
Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), find the minimum number of conference rooms required.

Remember that [[1, 4],[4, 7]] will not conflict at 4.

**Examples:**
Input: intervals = [[2, 7], [3, 5], [3, 9], [5, 12], [8, 15], [9, 14]]
Output: 3
Explanation: 
room1: [2, 7], [8, 15]
room2: [3, 5], [5, 12]
room3: [3, 9], [9, 14]

Input: intervals = [[1,5]]
Output: 1
Explanation: 
Only one meeting room is needed

**Algorithmic Steps**
This problem is solved with the help of two pointers approach. The algorithmic approach can be summarized as follows:

1. Initialize start and end times of each interval in two array variables `startTimes` and `endTimes`  with the length of interval list.

2. Initialize minimum required meeting rooms in `minMeetingRooms` and a counter variable `count` that increments when a meeting starts and decrements when a meeting ends.

3. Iterate through the list of intervals and fill the start and end times in both array variables(i.e, `startTimes`, `endTimes`).

4. Sort both start and end time arrays in an ascending order for the comparison.

5. Initialize two pointer variables `startIndex` and `endIndex` to keep track of start and end time arrays.

6. Iterate over the list of intervals using start time index value.

7. If the start time is less than the end time, then increment the counter variable along with start index value(i.e,`startIndex`).

8. If the start time is greater than the end time, then decrement the counter variable and increment end index(i.e, `endIndex`).

9. For each iteration, find the maximum of `minMeetingRooms` and `count`. This calculation represents the peak occupancy at any point in time.

10. Repeat steps 6-9 until start index value reaches the last element of interval list.

11. Return `minMeetingRooms` indicating the minimum number of meeting rooms required.


**Time and Space complexity:**
This algorithm has a time complexity of O(n logn) + O(n) + O(n) ~= O(n), where n is the number of intervals. This is because of traversing the intervals to fill the start and end times. Next, you need to perform sort operation which typically takes a time complexity of O(n log n) for sorting the list. Finally, iteration over the intervals take a time complexity of O(n). So the total time complexity simplifies to O(n log n).

The space complexity of this algorithm is O(n) due to the usage of two arrays for storing the start and end times.