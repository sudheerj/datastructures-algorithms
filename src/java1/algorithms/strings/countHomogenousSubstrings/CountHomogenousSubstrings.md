# Count Number of Homogeneous Substrings

## Problem
Given a string `s`, return the number of **homogeneous** substrings of `s`. A homogeneous string is one where all characters are the same.

Return the answer modulo `10^9 + 7`.

LeetCode: https://leetcode.com/problems/count-number-of-homogenous-substrings/

---

## Approach

**Streak Counting — O(n) / O(1)**

Track the current run length (`streak`). At each position, if the character matches the previous one, extend the streak — otherwise reset to 1. Each index contributes exactly `streak` new homogeneous substrings ending there (one for each length 1…streak). Add to count modulo `10^9+7`. Add 1 at the end for the single-character substring at index 0.

---

## Steps

1. `count = 0`, `streak = 1`.
2. For `i` from 1 to `n-1`:
   - Same as previous: `streak++`.
   - Different: `streak = 1`.
   - `count = (count + streak) % MOD`.
3. Return `(count + 1) % MOD`.

---

## Example

```
s = "abbcccaa"

Groups: a(1), b(2), c(3), a(2)
Homogeneous substrings per group: 1, 3, 6, 3

i=1 b≠a: streak=1, count=1
i=2 b=b: streak=2, count=3
i=3 c≠b: streak=1, count=4
i=4 c=c: streak=2, count=6
i=5 c=c: streak=3, count=9
i=6 a≠c: streak=1, count=10
i=7 a=a: streak=2, count=12
return 12+1 = 13
```

---

## Test Cases

| s          | output | groups → sums |
| ---------- | ------ | ------------- |
| "abbcccaa" | 13     | 1+3+6+3       |
| "xy"       | 2      | 1+1           |
| "zzzzz"    | 15     | 5×6/2         |
| "a"        | 1      | 1             |
| "aaa"      | 6      | 3×4/2         |
| "aab"      | 4      | 3+1           |

---

## Complexity

|                 | Time | Space |
| --------------- | ---- | ----- |
| Streak Counting | O(n) | O(1)  |
