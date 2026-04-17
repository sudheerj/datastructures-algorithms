# Largest Rectangle in Histogram

## Problem
Given an array of integers representing the heights of bars in a histogram, find the area of the largest rectangle that can be formed.

## Approach
Monotonic increasing stack:
- Iterate through all bars (add a zero at the end for flush)
- For each bar, pop from stack while the current bar is lower than the top of the stack
- For each pop, calculate area with the popped bar as the smallest bar
- Push current index to stack

## Complexity
- **Time:** O(n)
- **Space:** O(n)

## Example
```
Input: [2,1,5,6,2,3]
Output: 10
Explanation: Rectangle at heights 5 and 6, width 2: 5x2=10
```
