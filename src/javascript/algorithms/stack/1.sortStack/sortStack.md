# Sort Stack

Sorting a stack means arranging its elements in ascending order (smallest on top) using only stack operations and an auxiliary stack. This is a classic problem that demonstrates stack manipulation and algorithmic thinking.
The stack is sorted using another temporary stack, without using any other data structures like arrays or linked lists.


## Problem Statement

Given a stack of integers `nums`, sort it in ascending order using another temporary stack.

## Examples

**Example 1**  
Input: [8, 2, 4, 1, 5, 3]  
Output: [1, 2, 3, 4, 5, 8]

**Example 2**  
Input: [6, 5, 4, 3, 2, 1]  
Output: [1, 2, 3, 4, 5, 6]

## Algorithm

This problem is solved using stack push and pop operations to sort the elements. The approach is as follows:

1. If the stack has less than one element, return immediately.
2. Create a temporary stack (`tempStack`) to store intermediate results.
3. While the input stack is not empty:
    - Pop the top element from the input stack and store it in a variable `temp`.
    - While `tempStack` is not empty and its top element is greater than `temp`:
        - Pop from `tempStack` and push it back to the input stack.
    - Push `temp` onto `tempStack`.
4. Once done, transfer all elements from `tempStack` back to the input stack so that they are sorted in ascending order.


## Complexity

- **Time Complexity:** O(n²) in the worst case, due to nested stack operations.
- **Space Complexity:** O(n), for the auxiliary stack.