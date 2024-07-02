**Algorithmic Steps**
This problem is solved with the help of logic that involves comparing the elements and merging the intervals in case of overlap through iteration. The algorithmic approach can be summarized as follows:

1. Create an empty array `result` list which is used to store all intervals after insertion of new internval.

2. Initialize a boolean variable `isIntervalInserted` to indicate new interval inserted or not. 

3. Iterate through the list of the intervals. For each interval, compare the end value of the new input interval with its start value of the interval.

4. If the end value of the new interval is less than start value, then there is no overlap between the intervals. In this case, you can add the new interval followed by current interval to the result list. Also, mark the boolean variable `isIntervalInserted` to true.

5. If either `isIntervalInserted` value is true or the end value of current is less than or equal to the start value of the new interval, then there is no overlap between the intervals. In this case, you can just add the current interval to the result lit.

6. If both step 4 and step 5 conditions failed, there is an overlap between current interval and newly inserting interval.In this case, you need to take minimum of current and new interval as start value and maximum of current and new interval as end value. 

7. Repeat steps 3-6 until all the intervals have been traversed.

8. If the new interval not added to the result list yet(i.e, `!isIntervalInserted`), just add the new interval to the result.

9. Return the final result list as updated list of intervals.


**Time and Space complexity:**
This algorithm has a time complexity of O(n), where n is the number of intervals. This is because you need to traverse the entire interval list.

The space complexity of this algorithm is O(n) as we need to store a list containing all the intervals including the newly inserted interval.