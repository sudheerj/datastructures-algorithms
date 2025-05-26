# Number of People Seen in Queue

This problem involves determining how many people each person in a queue can see, based on their heights. A person can see another person if there is no one taller between them. This is a classic problem that demonstrates the power of monotonic stacks in solving visibility problems.

## Problem Statement

Given an array `heights` of distinct integers where `heights[i]` represents the height of the `i`th person. These heights represent `n` people standing in a queue numbered from `0` to `n - 1` in left to right order. Return an array `answer`, where `answer[i]` is the number of people that person `i` can see to their right in the queue.

A person can see another person if there is no one taller between them.

## Examples

**Example 1**  
Input: `heights = [10, 6, 8, 5, 11, 9]`  
Output: `[3, 1, 2, 1, 1, 0]`  
Explanation:
- Person 0 (height 10): Can see persons at positions 1 (height 6), 2 (height 8), and 4 (height 11)
- Person 1 (height 6): Can see person at position 4 (height 11)
- Person 2 (height 8): Can see persons at positions 3 (height 5) and 4 (height 11)
- Person 3 (height 5): Can see person at position 4 (height 11)
- Person 4 (height 11): Can see person at position 5 (height 9)
- Person 5 (height 9): Cannot see anyone (last person in queue)

**Example 2**  
Input: `heights = [6, 5, 4, 3, 2, 1]`  
Output: `[1, 1, 1, 1, 1, 0]`  
Explanation: Each person can only see the next person in the queue (except the last person).

**Example 3**  
Input: `heights = [1, 2, 3, 4, 5, 6]`  
Output: `[1, 1, 1, 1, 1, 0]`  
Explanation: Each person can only see the next person in the queue (except the last person).

## Algorithm

This problem is solved using a monotonic stack to efficiently track visible people. The approach is as follows:

1. Initialize an array `visibilityCount` of the same length as the input array, filled with zeros. This will store our results.
2. Initialize an empty stack to store heights of people that haven't been processed yet.
3. Iterate through the heights array from right to left (as we're looking rightward):
   - While the stack is not empty and the current person's height is greater than the height at the top of the stack:
     - Pop the top height from the stack (this person is visible to the current person).
     - Increment the visibility count for the current person.
   - If the stack is not empty after the while loop, increment the visibility count by 1 (the current person can see the first taller person).
   - Push the current person's height onto the stack.
4. Return the visibility count array.


## Complexity

- **Time Complexity:** O(n), where n is the number of people in the queue. Although there is a nested loop, each element is pushed and popped at most once, resulting in amortized O(n) time.
- **Space Complexity:** O(n) in the worst case (when heights are in ascending order), as the stack might need to store all heights.
