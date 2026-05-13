## Swap Node Pairs

Given a linked list, swap every two adjacent nodes and return its head.

### Examples

**Example 1**
Input: 1 -> 2 -> 3 -> 4
Output: 2 -> 1 -> 4 -> 3

**Example 2**
Input: 1 -> 2 -> 3 -> 4 -> 5
Output: 2 -> 1 -> 4 -> 3 -> 5

**Example 3**
Input: 1
Output: 1

**Example 4**
Input: (empty)
Output: (empty)

### Approach
- Use iteration with a dummy node to swap pairs in-place.
- Time Complexity: O(n)
- Space Complexity: O(1)
