# Number of Distinct Islands

## Problem
Given an `m x n` binary grid where `'1'` is land and `'0'` is water, return the number of **distinct** islands. Two islands are considered the same if one can be **translated** (not rotated or reflected) to match the other.

LeetCode: https://leetcode.com/problems/number-of-distinct-islands/

---

## Approach

Use DFS to explore each island. For every cell visited, record its position **relative to the island's anchor cell** (where DFS started) as `"rowOffset:colOffset"`. Collect all offsets in a list, convert to a tuple, and add to a set.

All path tuples are stored in a Python `set` — the set's size is the answer.

**TC: O(m × n) — SC: O(m × n)**

---

## Steps

1. Iterate every cell. When a `'1'` is found:
   - Start DFS with `(base_row, base_col)` = current cell.
   - Each visited cell appends `f"{row-base_row}:{col-base_col}"` to a list.
   - Mark cells as `'0'` to avoid revisiting.
2. Add `tuple(path)` to the `distinct` set.
3. Return `len(distinct)`.

---

## Example

```
Grid:
  1 1 0 0
  1 1 0 0
  0 0 1 1
  0 0 1 1

Island A (anchor 0,0) — DFS order: down, up, right, left:
  Visits: (0,0),(1,0),(1,1),(0,1)
  Path: ["0:0","1:0","1:1","0:1"]

Island B (anchor 2,2):
  Visits: (2,2),(3,2),(3,3),(2,3)
  Path: ["0:0","1:0","1:1","0:1"]

Same path → 1 distinct island
```

---

## Test Cases

| grid                                              | output | notes                                 |
| ------------------------------------------------- | ------ | ------------------------------------- |
| [[1,1,0,0],[1,1,0,0],[0,0,1,1],[0,0,1,1]]         | 1      | two identical 2×2 blocks              |
| [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,1,1],[0,0,0,1,1]] | 3      | L-shape + pair + 2×2 → 3 distinct     |
| [[1,1,0,0,0],[1,0,0,1,1],[0,0,0,1,0]]             | 1      | two identical L-shapes (translation)  |
| [[0,0,0],[0,0,0]]                                 | 0      | no islands                            |
| [[1,0,1],[0,0,0],[1,0,0]]                         | 1      | three single-cell islands, same shape |

### Why mirror images are different

```
Island A:       Island B (mirror):
  1 1             1 1
  1                 1
DFS path A = ["0:0","1:0","0:1"]
DFS path B = ["0:0","0:1","1:1"]   ← different
→ counted as 2 distinct islands
```

---

## Complexity

|           | Time     | Space    |
| --------- | -------- | -------- |
| DFS + Set | O(m × n) | O(m × n) |
