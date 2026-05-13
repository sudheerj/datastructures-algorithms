# Count Number of Homogeneous Substrings

## Problem
Given a string `s`, return the number of **homogeneous** substrings modulo `10^9 + 7`.

LeetCode: https://leetcode.com/problems/count-number-of-homogenous-substrings/

---

## Approach

**Streak Counting — O(n) / O(1)**

Track the current run length. Each position contributes `streak` new homogeneous substrings ending there. Add modulo `10^9+7`.

---

## Steps

1. `count = 0`, `streak = 1`.
2. For each `i` from 1 to `n-1`:
   - Same as previous: `streak += 1`, else `streak = 1`.
   - `count = (count + streak) % MOD`.
3. Return `(count + 1) % MOD`.

---

## Example

```
s = "abbcccaa"

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

| s          | output | groups                |
|------------|--------|-----------------------|
| "abbcccaa" | 13     | a(1)+b(2)+c(3)+a(2)  |
| "xy"       | 2      | x(1)+y(1)            |
| "zzzzz"    | 15     | z(5)                 |
| "a"        | 1      | a(1)                 |
| "aaa"      | 6      | a(3)                 |
| "aab"      | 4      | a(2)+b(1)            |

---

## Complexity

| | Time | Space |
|-|------|-------|
| Streak Counting | O(n) | O(1) |
