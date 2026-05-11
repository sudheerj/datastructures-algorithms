# Palindrome Number

## Problem
Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.

LeetCode: https://leetcode.com/problems/palindrome-number/

---

## Approach

Reverse all digits by repeatedly extracting `num % 10` and building `reverse`. Compare with the original.

Negative numbers are immediately `false`. Uses `Math.trunc` for integer division.

**TC: O(log₁₀ n) — SC: O(1)**

---

## Steps

1. If `num < 0` return `false`.
2. Save `original = num`.
3. While `num > 0`: `reverse = reverse * 10 + (num % 10)`, `num = Math.trunc(num / 10)`.
4. Return `original === reverse`.

---

## Example

```
num = 121

Step 1: reverse=1,  num=12
Step 2: reverse=12, num=1
Step 3: reverse=121, num=0

121 === 121 → true
```

---

## Test Cases

| input | output | notes                   |
| ----- | ------ | ----------------------- |
| 121   | true   | 3-digit palindrome      |
| -121  | false  | negative number         |
| 10    | false  | trailing zero           |
| 0     | true   | zero                    |
| 12321 | true   | 5-digit odd palindrome  |
| 1221  | true   | 4-digit even palindrome |
| 123   | false  | not a palindrome        |

---

## Complexity

|                | Time       | Space |
| -------------- | ---------- | ----- |
| Digit reversal | O(log₁₀ n) | O(1)  |
