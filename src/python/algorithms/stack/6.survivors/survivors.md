**Description:**
Given two arrays `A` (fish sizes) and `B` (fish directions: `0` = upstream, `1` = downstream), determine the number of fish that survive after all encounters. When a downstream fish meets an upstream fish, the larger one eats the smaller one.

## Examples

**Example 1:**  
Input: `A = [4, 3, 2, 1, 5], B = [0, 1, 0, 0, 0]`  
Output: `2`

**Example 2:**  
Input: `A = [1, 2, 3, 4, 5], B = [0, 0, 0, 0, 0]`  
Output: `5` (all fish go upstream, no conflict)

**Example 3:**  
Input: `A = [5, 4, 3, 2, 1], B = [1, 1, 1, 1, 1]`  
Output: `5` (all fish go downstream, no conflict)

**Example 4:**  
Input: `A = [5, 3, 8, 6, 2], B = [1, 1, 0, 0, 0]`  
Output: `3`

## Algorithm

This problem is solved using a **stack** to simulate fish encounters:

1. Initialize an empty stack `downstream` to track downstream-moving fish and a counter `survivor_count` for upstream survivors.
2. Iterate through each fish:
   - If the fish moves downstream (`B[i] == 1`), push its size onto the stack.
   - If the fish moves upstream (`B[i] == 0`), fight downstream fish in the stack:
     - If the downstream fish (top of stack) is larger, the upstream fish is eaten (break).
     - Otherwise, the upstream fish eats the downstream fish (pop from stack) and continue fighting.
     - If no downstream fish remain, the upstream fish survives (increment counter).
3. Return the sum of survived upstream fish and remaining downstream fish in the stack.

## Complexity

- **Time Complexity:** O(n), where n is the number of fish. Each fish is pushed and popped at most once.
- **Space Complexity:** O(n), for the stack of downstream fish.