**Description:**
Given an array `heights` of distinct integers where `heights[i]` represents the height of the `i`th person. These heights represents `n` people standing in a queue numbered from `0` to `n - 1` in left to right order.  Return an array `answer`, where `answer[i]` is the number of people that person `i` can see to their right in the queue.

## Examples:
Example 1
Input:  heights1 = [10,6,8,5,11,9]
Output: [3, 1, 2, 1, 1, 0]

Example 2
Input: heights2 = [6, 5, 4, 3, 2, 1]
Output: [1, 1, 1, 1, 1, 0 ]

Example 3
Input: heights2 = [1, 2, 3, 4, 5, 6]
Output: [1, 1, 1, 1, 1, 0 ]

**Algorithmic Steps**
This problem is solved with the help of monotonic decreasing stack. The algorithmic approach can be summarized as follows:

1. Initialize the length variable which indicates number of people in the queue.

2. Initialize a `visibilityCount` array with the same length of input `heights` array, filled with zeros.

3. Initialize a monotonic stack named `stack` which stores the heights of persons.

4. Iterate over the input array using an iteration variable `i` from backwards(i.e, from end of array to 0). This reverse iteration aligns with the direction of visibility (i.e,rightwards)

5. Inside the loop(step4), create a while loop to pop elements from stack if current person's height is greater than the top element. Also, as part of this nested loop, increment the visibility count by 1 because popped person is directly visible 
to the current person.

6. Upon removing all the shorter people from the previous step, if the stack is still not empty, it indicates that there is atleast one taller person compared to the current person. In this case, the visibility count is incremented by 1.

7. Add the current taller person height to the stack.

8. Return the visibility count array which indicate number of persions of visible at each position.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of people a person can see. This is because we are iterating the array only once. However, each element performs multiple comparisons along with pop operations from the stack until a higher height is found. In the worst, each element will be pushed and popped from the stack once, leads to time complexity of `O(n)`. So the overall time complexity is `O(n)`.

Also, it takes space complexity of `O(n)` with the help of stack and array data structures, using `n` number of elements. In the worst case(when heights are in ascending order), the stack will contain all people heights.