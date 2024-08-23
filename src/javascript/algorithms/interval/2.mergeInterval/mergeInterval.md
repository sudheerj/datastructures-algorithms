**Algorithmic Steps**
This problem is solved with the help of sorting intervals followed by merging the intervals through iteration. The algorithmic approach can be summarized as follows:

1. First, sort the list of intervals based on their start times. This step helps to keep the overlapping intervals next to each other in the list.

2. Initialize a new list `mergedIntervals` to hold the merged intervals and add the first interval to it. 

3. Iterate through the rest of the intervals, starting from the second interval onwards. For each interval, compare its start value with the end value of the last interval in the merged list.

4. If the start value is greater than the end value of the last interval, then there is no overlap between the intervals. In this case, you can add the current interval as a new entry to the merged list.

5. If the start value is less than or equal to the end value of the last interval, then there is overlap between the intervals. In this case, you can update the end value of the last interval in the merged list to the maximum of the end value of the last interval and the start value of current interval. 

6. Repeat steps 3-5 until all the intervals have been traversed.

7. Return `mergedIntervals` as the final merged intervals.


**Time and Space complexity:**
This algorithm has a time complexity of O(n logn) + O(n), where n is the number of intervals. This is because sort operation typically takes a time complexity of O(n log n) for sorting the list. Thereafter, iteration over the intervals take a time complexity of O(n). So the total time complexity simplifies to O(n log n).

The space complexity of this algorithm is O(n) as we need to store a list containing all the merged intervals.