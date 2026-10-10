# Snakes and Ladders

Given a board representing a game of Snakes and Ladders, return the minimum number of moves to reach the last square. If impossible, return -1.

- Each cell is either -1 (no snake/ladder) or a destination square (ladder or snake).
- You start at square 1 and can move 1-6 steps per dice roll.
- If you land on a snake or ladder, you must move to its destination.

## Examples

| Board | Output | Explanation |
|-------|--------|-------------|
| [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]] | 4 | Reach the end in 4 moves |
| [[-1,-1,-1],[-1,-1,-1],[-1,-1,-1]] | 2 | 2 moves for 3x3 board |
| [[-1,-1,-1],[-1,9,8],[-1,8,9]] | 1 | Ladder at start, reach end in 1 move |

## Algorithm
- Use BFS to find the shortest path from square 1 to n^2.
- For each dice roll (1-6), move and apply any snake/ladder.
- Track visited squares to avoid cycles.

## Complexity
- **Time:** $O(n^2)$
- **Space:** $O(n^2)$

## Links
- [Java Implementation](./SnakesAndLadders.java)
- [Python Implementation](../../../../python/algorithms/graph/shortestPath/snakesAndLadders/snakes_and_ladders.py)
- [JavaScript Implementation](../../../../javascript/algorithms/graph/shortestPath/snakesAndLadders/snakesAndLadders.js)
