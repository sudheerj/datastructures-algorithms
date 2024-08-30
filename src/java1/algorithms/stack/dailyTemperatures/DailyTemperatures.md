**Description:**
Given an array of integers `temperatures`, which represents the daily temperatures in a city. For each temperature, calculate how many days one would have to wait for a warmer temperature than the current day. i.e, Find an array `answer` such that `answer[i]` represents the number of days you have to wait after the `i`th day to get a warmer temperature.

**Note:** If there is no future day with a warmer temparature, just return 0.

## Examples:
Example 1
Input:  temperatures1 = [72,73,74,70,68,71,75,72]
Output: [1, 1, 4, 2, 1, 1, 0, 0]

Example 2
Input: temperatures2 = [10, 20, 30,40,50,60,70]
Output: [1, 1, 1, 1, 1, 1, 0]

**Algorithmic Steps**
This problem is solved with the help of monotonic decreasing stack. The algorithmic approach can be summarized as follows:

1. Initialize a days array with the same length of input temperatures array, filled with zeros.

2. Initialize a monotonic stack which stores the indices of temperature values.

3. Iterate over the input array using an iteration variable `currDay`(from 0 to length of array).

4. For each iteration, create nested iteration to shrink the stack until the stack is not empty and current temperature is greater than previous day temperation.

5. As part of the nested iteration, the top element of stack needs to be poped-out and number of days(current day index - previous day index) to wait for warmer temperature stores in previous day's index.

6. If the current day temperature is less than previous day, the respective current day index is stored in the stack.

7. Return the days array which indicate elements of number of days to get a warmer temperature

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)(i.e, O(n + n))`, where n is the number of days in the temperatures list. This is because each element is processed by pushing an element into a stack and then processed again when the element is popped-out. Here, each element is pushed and popped at most once with a linear time. 

Also, it takes space complexity of `O(n)` with the use of stack data structure. In the worst case(all temperatures in decreasing order), the stack will contain all temperature indices.