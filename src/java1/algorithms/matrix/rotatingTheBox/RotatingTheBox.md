# Rotating the Box

## Problem statement

Given an `m x n` box represented by a character matrix, each cell contains a stone (`#`), an obstacle (`*`), or empty space (`.`). First rotate the box 90 degrees clockwise. As a result of the rotation, stones fall downward until they land on an obstacle, another stone, or the bottom of the box. Return the final matrix.

Equivalently, before rotating, stones can be simulated as falling to the right within their row, stopping at obstacles or other stones.

## Examples

### Example 1

Input:

```text
box = [["#",".","*","."],
       ["#","#","*","."]]
```

Output:

```text
[["#","."],
 ["#","#"],
 ["*","*"],
 [".","."]]
```

### Example 2

Input:

```text
box = [["#","#","*",".","*","."],
       ["#","#","#","*",".","."],
       ["#","#","#",".","#","."]]
```

Output:

```text
[[".","#","#"],
 [".","#","#"],
 ["#","#","*"],
 ["#","*","."],
 ["#",".","*"],
 ["#",".","."]]
```

### Example 3

Input: `box = [["#"]]`

Output: `[["#"]]`

## Algorithm

1. For each row, scan from right to left and keep a `write` position for the next stone.
2. When an obstacle is found, move `write` to the cell immediately to its left. This keeps stones in separate sections divided by obstacles.
3. When a stone is found, clear its old cell, place it at `write`, then move `write` one cell left.
4. Allocate a result matrix with `n` rows and `m` columns. Map each settled cell from `(r, c)` to `(c, m - 1 - r)` to rotate clockwise.

**Time complexity:** `O(m * n)`.

**Space complexity:** `O(m * n)` for the rotated result.

## Java implementation

[RotatingTheBox.java](./RotatingTheBox.java)