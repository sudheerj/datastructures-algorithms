# Count Binary Substrings

## Problem
Given a binary string `s`, return the number of non-empty substrings that have the same number of `0`s and `1`s, with all `0`s and `1`s grouped consecutively.

LeetCode: https://leetcode.com/problems/count-binary-substrings/

---

## Approach

**Group Counting — O(n) / O(1)**

Track the current run length (`curr`) and the previous run length (`prev`). At each group boundary, `min(prev, curr)` valid substrings end there.

---

## Steps

1. `prev = 0`, `curr = 1`, `count = 0`.
2. For each `i` from 1 to `s.length - 1`:
   - Same char: `curr++`.
   - Different: `count += min(prev, curr)`, `prev = curr`, `curr = 1`.
3. `count += min(prev, curr)`.
4. Return `count`.

---

## Example

```
s = "00110011"  groups: [2, 2, 2, 2]

0→1: min(0,2)=0  → count=0
1→0: min(2,2)=2  → count=2
0→1: min(2,2)=2  → count=4
end: min(2,2)=2  → count=6
```

---

## Test Cases

| s          | output | notes              |
|------------|--------|--------------------|
| "00110011" | 6      | groups [2,2,2,2]   |
| "10101"    | 4      | groups [1,1,1,1,1] |
| "00011"    | 2      | groups [3,2]       |
| "0"        | 0      | single char        |
| "01"       | 1      | groups [1,1]       |
| "000111"   | 3      | groups [3,3]       |

---

## Complexity

| | Time | Space |
|-|------|-------|
| Group Counting | O(n) | O(1) |
