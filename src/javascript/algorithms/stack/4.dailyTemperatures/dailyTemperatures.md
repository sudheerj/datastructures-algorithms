# Daily Temperatures

The Daily Temperatures problem is a classic algorithm challenge that uses a stack to efficiently track and calculate waiting times for warmer temperatures. This problem demonstrates the power of monotonic stacks in solving problems that involve finding the next greater element.

## Problem Statement

Given an array of integers `temperatures` representing daily temperatures, calculate for each day how many days you would have to wait until a warmer temperature. If there is no future day with a warmer temperature, return 0 for that day.

**Note:** The output array should have the same length as the input array, where each element represents the number of days to wait for a warmer temperature.

## Examples

**Example 1**  
Input: `temperatures = [72, 73, 74, 70, 68, 71, 75, 72]`  
Output: `[1, 1, 4, 2, 1, 1, 0, 0]`  
Explanation:
- Day 0 (72°F): Wait 1 day for a warmer temperature (73°F on day 1)
- Day 1 (73°F): Wait 1 day for a warmer temperature (74°F on day 2)
- Day 2 (74°F): Wait 4 days for a warmer temperature (75°F on day 6)
- Day 3 (70°F): Wait 2 days for a warmer temperature (71°F on day 5)
- Day 4 (68°F): Wait 1 day for a warmer temperature (71°F on day 5)
- Day 5 (71°F): Wait 1 day for a warmer temperature (75°F on day 6)
- Day 6 (75°F): No future warmer temperature, so 0 days
- Day 7 (72°F): No future warmer temperature, so 0 days

**Example 2**  
Input: `temperatures = [10, 20, 30, 40, 50, 60, 70]`  
Output: `[1, 1, 1, 1, 1, 1, 0]`  
Explanation: Each day (except the last) has a warmer temperature the next day.

## Algorithm

This problem is solved using **a monotonic decreasing stack** to efficiently find the next warmer day for each temperature. The approach is as follows:

1. Initialize an array `days` of the same length as the input array, filled with zeros. This will store our results.
2. Initialize an empty stack to store indices of days with temperatures that haven't found a warmer day yet.
3. Iterate through each day in the temperatures array:
   - While the stack is not empty and the current day's temperature is warmer than the temperature at the index at the top of the stack:
     - Pop the top index from the stack (this is a previous day that now found a warmer day).
     - Calculate the number of days to wait (current day index - previous day index) and store it in the result array.
   - Push the current day's index onto the stack.
4. Return the result array.


## Complexity

- **Time Complexity:** O(n), where n is the number of days in the temperatures array. Although there is a nested loop, each element is pushed and popped at most once, resulting in amortized O(n) time.
- **Space Complexity:** O(n) in the worst case (when temperatures are in decreasing order), as the stack might need to store all indices.
