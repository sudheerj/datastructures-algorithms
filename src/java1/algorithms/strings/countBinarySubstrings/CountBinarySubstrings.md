# Count Binary Substrings

## Problem
Given a binary string `s`, return the number of non-empty substrings that have the same number of `0`s and `1`s, and all the `0`s and all the `1`s in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

LeetCode: https://leetcode.com/problems/count-binary-substrings/

---

## Approach

**Group Counting — O(n) / O(1)**

Walk through the string tracking the length of the current run (`curr`) and the previous run (`prev`). Each time a group boundary is crossed, add `min(prev, curr)` to the count — that's how many valid substrings end at this transition. After the loop, do one final `min(prev, curr)` for the last group.

---

## Steps

1. `prev = 0`, `curr = 1`, `count = 0`, `i = 1`.
2. While `i < s.length()`:
   - If `s[i] == s[i-1]`: `curr++` (same group).
   - Else: `count += min(prev, curr)`, then `prev = curr`, `curr = 1`.
   - `i++`.
3. `count += min(prev, curr)` (handle last group).
4. Return `count`.

---

## Example

```
s = "00110011"

Groups: [00][11][00][11]  → lengths [2, 2, 2, 2]

Transitions:
  0→1 at i=2: min(0,2)=0 → count=0, prev=2, curr=1
  1→0 at i=4: min(2,2)=2 → count=2, prev=2, curr=1
  0→1 at i=6: min(2,2)=2 → count=4, prev=2, curr=1
  after loop:  min(2,2)=2 → count=6

Answer: 6  ("0011","01","1100","10","0011","01")
```

---

## Test Cases

| s          | output | notes                       |
|------------|--------|-----------------------------|
| "00110011" | 6      | groups [2,2,2,2]            |
| "10101"    | 4      | groups [1,1,1,1,1]          |
| "00011"    | 2      | groups [3,2] → min=2        |
| "0"        | 0      | single char                 |
| "01"       | 1      | groups [1,1]                |
| "000111"   | 3      | groups [3,3] → min=3        |

---

## Complexity

| | Time | Space |
|-|------|-------|
| Group Counting | O(n) | O(1) |
