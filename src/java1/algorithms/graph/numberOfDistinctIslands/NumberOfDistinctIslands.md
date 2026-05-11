# Number of Distinct Islands

## Problem
Given an `m x n` binary grid where `'1'` is land and `'0'` is water, return the number of **distinct** islands. Two islands are considered the same if one can be translated (not rotated or reflected) to match the other.

LeetCode: https://leetcode.com/problems/number-of-distinct-islands/

---

## Approach

Use DFS to explore each island. For every cell visited, record its position **relative to the island's top-left cell** (the anchor where DFS started) as `"rowOffset:colOffset|"`. This normalized path string uniquely identifies the island's shape regardless of where it appears in the grid.

All path strings are stored in a `HashSet` — the set's size is the answer.

**TC: O(m × n) — SC: O(m × n)**

---

## Steps

1. Iterate every cell. When a `'1'` is found:
   - Start DFS with `(baseRow, baseCol)` = current cell.
   - Each visited cell appends `(row-baseRow):(col-baseCol)|` to a `StringBuilder`.
   - Mark cells as `'0'` to avoid revisiting.
2. Add the resulting pattern string to a `HashSet`.
3. Return `hashSet.size()`.

---

## Example

```
Grid:
  1 1 0 1 1
  1 0 0 0 0
  0 0 0 1 1
  0 0 0 1 1

Island 1 (top-left, anchor 0,0):
  visits: (0,0),(0,1),(1,0)
  pattern: "0:0|0:1|1:0|"

Island 2 (top-right, anchor 0,3):
  visits: (0,3),(0,4)
  pattern: "0:0|0:1|"

Island 3 (bottom-right, anchor 2,3):
  visits: (2,3),(2,4),(3,3),(3,4)
  pattern: "0:0|0:1|1:0|1:1|"

Distinct patterns: 3  →  answer: 3
```

Wait — island 1 pattern `"0:0|0:1|1:0|"` ≠ island 3 pattern `"0:0|0:1|1:0|1:1|"`, and both ≠ island 2. But for Test 1 in the code the expected is **2** because island 1 (L-shape) and island 3 (2×2 block) are different, and island 2 (horizontal pair) matches... let's re-trace:

```
Row 0: 1 1 0 1 1
Row 1: 1 0 0 0 0
Row 2: 0 0 0 1 1
Row 3: 0 0 0 1 1

Island A (0,0): DFS visits (0,0)→down(1,0)→top dead→right(0,1)→...
  pattern: "0:0|1:0|0:1|"

Island B (0,3): DFS visits (0,3)→down dead→top dead→right(0,4)
  pattern: "0:0|0:1|"

Island C (2,3): DFS visits (2,3)→down(3,3)→right(3,4)→up(2,4)...
  pattern: "0:0|1:0|1:1|0:1|"

All 3 patterns are distinct → answer: 3
```

Hmm — the test comments say "expected 2". Let me re-check the exact DFS traversal order.

Actually the DFS order is: down, up, right, left. Starting at (0,3):
- Visit (0,3): append "0:0|", go down→(1,3)='0' stop, up→(-1,3) OOB, right→(0,4)
- Visit (0,4): append "0:1|", go down→(1,4)='0', up OOB, right OOB, left back=(0,3)='0'

So island B = "0:0|0:1|"

Starting at (2,3):
- Visit (2,3): "0:0|", down→(3,3)
- Visit (3,3): "1:0|", down OOB, up→(2,3)='0', right→(3,4)
- Visit (3,4): "1:1|", down OOB, up→(2,4)
- Visit (2,4): "0:1|", done
So island C = "0:0|1:0|1:1|0:1|"

Island A starts at (0,0):
- Visit (0,0): "0:0|", down→(1,0)
- Visit (1,0): "1:0|", down→(2,0)='0', up→(0,0)='0', right→(1,1)='0', left OOB
- Back to (0,0), up OOB, right→(0,1)
- Visit (0,1): "0:1|"
So island A = "0:0|1:0|0:1|"

All three distinct → answer 3 for Test 1. The comment in the code saying "expected 2" needs correction.

---

## Test Cases

| grid                                              | output | notes                            |
| ------------------------------------------------- | ------ | -------------------------------- |
| [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,1,1],[0,0,0,1,1]] | 3      | 3 distinct shapes                |
| [[1,1,0,0,0],[1,0,0,0,0],[0,0,0,1,1],[0,0,0,0,1]] | 1      | two L-shapes, same relative path |
| [[0,0,0],[0,0,0]]                                 | 0      | no islands                       |
| [[1,1],[1,1]]                                     | 1      | single 2×2 block                 |
| [[1,0,1],[0,0,0],[1,0,0]]                         | 1      | three single cells, same shape   |

---

## Complexity

|               | Time     | Space    |
| ------------- | -------- | -------- |
| DFS + HashSet | O(m × n) | O(m × n) |
