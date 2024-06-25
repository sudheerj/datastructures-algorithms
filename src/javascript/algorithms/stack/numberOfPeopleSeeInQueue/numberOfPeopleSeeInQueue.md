**Algorithmic Steps**
This problem is solved with the help of monotonic decreasing stack. The algorithmic approach can be summarized as follows:

1. Initialize the length variable which indicates number of people in the queue.

2. Initialize a `visiblityCount` array with the same length of input `heights` array, filled with zeros.

3. Initialize a monotonic stack named `stack` which stores the heights of persons.

4. Iterate over the input array using an iteration variable `i` from backwards(i.e, from end of array to 0). This reverse iteration aligns with the direction of visibility (i.e,rightwards)

5. Inside the loop(step4), create a while loop to pop elements from stack if the top element is less than current person's height. Also, as part of this nested loop, increment the visibility count by 1 because popped person is directly visible 
to the current person.

5. Upon removing all the shorter people from the previous step, if the stack is still not empty, it indicates that there is atleast one taller person compared to the current person. In this case, the visibility count is incremented by 1.

6. Add the current taller person height to the stack.

7. Return the visiblity count array which indicate number of persions of visible at each position.

**Time and Space complexity:**
This algorithm has a time complexity of O(n), where n is the number of people a person can see. This is because we are iterating the array only once. However, each element performs multiple comparisons along with pop operations from the stack until a higher height is found. In the worst, each element will be pushed and popped from the stack once, leads to time complexity of O(n). So the overall time complexity is O(n).

Also, it takes space complexity of O(n) with the help of stack and array data structures, using `n` number of elements. In the worst case(when heights are in ascending order), the stack will contain all people heights.