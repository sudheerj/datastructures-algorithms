**Problem statement:** Given a string of instructions for a robot on an infinite plane (`G` = go forward one step, `L` = turn left 90°, `R` = turn right 90°), return `true` if the robot is bounded in a circle (i.e., it will never escape to infinity). The robot starts at `(0, 0)` facing north.

LeetCode #1041

### Examples

```
Input:  instructions = "GGLLGG"
Output: true
Explanation: Robot goes north 2, turns south, goes south 2 → returns to origin.
```

```
Input:  instructions = "GG"
Output: false
Explanation: Robot moves north indefinitely, never returns.
```

```
Input:  instructions = "GL"
Output: true
Explanation: After one cycle robot is not facing north, so it will loop back.
```

**Algorithmic Steps**

1. Track position `(x, y)` and direction `dir` (0=North, 1=East, 2=South, 3=West).
2. Use directions array: `{{0,1}, {1,0}, {0,-1}, {-1,0}}`.
3. For each instruction:
   - `G`: move one step in current direction (`x += dirs[dir][0]`, `y += dirs[dir][1]`).
   - `L`: turn left → `dir = (dir + 3) % 4`.
   - `R`: turn right → `dir = (dir + 1) % 4`.
4. After one full cycle, robot is bounded if:
   - It is back at origin `(0, 0)`, **or**
   - It is not facing north (`dir != 0`) — it will spiral back within 4 cycles at most.

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(1)  |
