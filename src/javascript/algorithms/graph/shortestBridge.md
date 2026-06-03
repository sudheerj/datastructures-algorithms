# Shortest Bridge (LeetCode 934)

Given a binary matrix grid, return the smallest number of 0's that must be flipped to 1's so that there is a path connecting two islands (groups of 1's).

## Example

Input: grid = [[0,1],[1,0]]
Output: 1

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2

## Approach

### DFS + BFS (O(n^2) time, O(n^2) space)
- Use DFS to find and mark the first island, adding its cells to a queue.
- Use BFS to expand from the first island, counting steps until reaching the second island.

## Test Cases
| grid                                               | Output |
|----------------------------------------------------|--------|
| [[0,1],[1,0]]                                      | 1      |
| [[0,1,0],[0,0,0],[0,0,1]]                          | 2      |
| [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]] | 1 |
| [[0,1,1,0,0],[0,0,0,0,0],[0,0,0,0,1],[0,0,0,0,1]]  | 2      |
| [[1,0,0,0,0],[0,0,0,0,0],[0,0,0,0,1]]              | 4      |

## Files
- Java: [ShortestBridge.java](../../java1/algorithms/graph/shortestBridge/ShortestBridge.java)
- Python: [shortestBridge.py](../../../../python/algorithms/graph/shortestBridge.py)
- JavaScript: [shortestBridge.js](../../../../javascript/algorithms/graph/shortestBridge.js)
