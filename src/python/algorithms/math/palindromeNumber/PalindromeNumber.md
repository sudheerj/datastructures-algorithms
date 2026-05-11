# Palindrome Number

## Problem
Given an integer `x`, return `True` if `x` is a palindrome, and `False` otherwise.

LeetCode: https://leetcode.com/problems/palindrome-number/

---

## Approach

Reverse all digits by repeatedly extracting `num % 10` and building `reverse`. Compare with the original.

Negative numbers are immediately `False`.

**TC: O(log₁₀ n) — SC: O(1)**

---

## Steps

1. If `num < 0` return `False`.
2. Save `original = num`.
3. While `num > 0`: `reverse = reverse * 10 + num % 10`, `num //= 10`.
4. Return `original == reverse`.

---

## Example

```
num = 121

Step 1: reverse=1,  num=12
Step 2: reverse=12, num=1
Step 3: reverse=121, num=0

121 == 121 → True
```

---

## Test Cases

| input | output | notes                   |
| ----- | ------ | ----------------------- |
| 121   | True   | 3-digit palindrome      |
| -121  | False  | negative number         |
| 10    | False  | trailing zero           |
| 0     | True   | zero                    |
| 12321 | True   | 5-digit odd palindrome  |
| 1221  | True   | 4-digit even palindrome |
| 123   | False  | not a palindrome        |

---

## Complexity

|                | Time       | Space |
| -------------- | ---------- | ----- |
| Digit reversal | O(log₁₀ n) | O(1)  |
