**Description:**
Given an array of heights representing a stone wall skyline, find the minimum number of rectangular stone blocks required to build the wall.

## Examples

**Example 1:**  
Input: `heights = [8, 8, 5, 7, 9, 8, 7, 4, 8]`  
Output: `7`

**Example 2:**  
Input: `heights = [1, 1, 1, 1]`  
Output: `1` (flat skyline, only 1 block needed)

**Example 3:**  
Input: `heights = [1, 2, 3, 4]`  
Output: `4` (increasing skyline, each needs a new block)

**Example 4:**  
Input: `heights = [4, 3, 2, 1]`  
Output: `4` (decreasing skyline, each level needs a new block)

**Example 5:**  
Input: `heights = [1, 3, 2, 3, 1]`  
Output: `5`

## Algorithm

This problem is solved using a **monotonic stack**:

1. Initialize an empty stack and a counter `blocks` to `0`.
2. Iterate through each height in the array:
   - While the stack is not empty and the top of the stack is greater than the current height, pop from the stack (remove blocks taller than current level).
   - If the stack is empty or the top of the stack is less than the current height, push the current height and increment the block counter.
   - If the top equals the current height, no new block is needed (the existing block continues).
3. Return the total block count.

## Complexity

- **Time Complexity:** O(n), where n is the number of heights. Each element is pushed and popped at most once.
- **Space Complexity:** O(n), for the stack in the worst case.