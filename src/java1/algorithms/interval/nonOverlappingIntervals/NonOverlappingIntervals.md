**Algorithmic Steps**
This problem is solved with the help of greedy approach. The algorithmic approach can be summarized as follows:

1. First, sort the list of intervals based on their start times. This step helps to keep the overlapping intervals next to each other in the list.

2. Initialize a minimum removal of intervals varaible `minRemove` to 0, which is used to hold the minimum number of intervals to be removed to make non-overlapping intervals. 

3. Initialize previous end value of an interval `prevEnd` with first interval end value. i.e, Here, first interval is considered as non-overlapping interval by default.

4. Iterate through the rest of the intervals, starting from the second interval onwards. For each interval, keep the start(i.e, `start`) and end(i.e, `end`) values for comparing with other intervals.

5. If the start value is greater than the end value of the previous interval, then there is no overlap between the intervals. In this case, you can update the previous end value(`prevEnd`) with the current end value(`end`) of interval.

6. If the start value is less than to end value of the previous interval, then there is overlap between the intervals. In this case, you can increment `minRemove` counter by one. Also, the previous end value needs to be updated by minimum value between previous end value and current value. The intervals with the earliest end times are helpful to minimize the potential overlap with future intervals 

7. Repeat steps 4-5 until all the intervals have been traversed.

8. Return `minRemove` as the minimum number of intervals to be removed to make a non overlapping interval list.


**Time and Space complexity:**
This algorithm has a time complexity of O(n logn) + O(n) ~= O(n), where n is the number of intervals. This is because sort operation typically takes a time complexity of O(n log n) for sorting the list. Thereafter, iteration over the intervals take a time complexity of O(n). So the total time complexity simplifies to O(n log n).

The space complexity of this algorithm is O(1) due to no additional data structure used.