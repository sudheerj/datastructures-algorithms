# Rotting Oranges

Given a grid representing a box of oranges, where:
- 0 = empty cell
- 1 = fresh orange
- 2 = rotten orange

Every minute, any fresh orange adjacent (up, down, left, right) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If impossible, return -1.

## Examples

| Grid | Output | Explanation |
|------|--------|-------------|
| [[2,1,1],[1,1,0],[0,1,1]] | 4 | All oranges rot in 4 minutes |
| [[2,1,1],[0,1,1],[1,0,1]] | -1 | Some oranges never rot |
| [[0,2]] | 0 | No fresh oranges |
| [[2,2],[2,2]] | 0 | All already rotten |
| [[0,0],[0,0]] | 0 | No oranges |

## Algorithm
- Multi-source BFS from all rotten oranges.
- For each minute, rot all adjacent fresh oranges.
- Track the number of fresh oranges and return the minutes if all rot, else -1.

## Complexity
- **Time:** $O(m \times n)$
- **Space:** $O(m \times n)$

## Links
- [Java Implementation](./OrangesRotting.java)
- [Python Implementation](../../../../python/algorithms/graph/orangesRotting/oranges_rotting.py)
- [JavaScript Implementation](../../../../javascript/algorithms/graph/orangesRotting/orangesRotting.js)
