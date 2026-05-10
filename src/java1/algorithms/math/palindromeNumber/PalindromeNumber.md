# Palindrome Number

## Problem
Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.

A number is a palindrome if it reads the same forward and backward.

LeetCode: https://leetcode.com/problems/palindrome-number/

---

## Approach

Reverse the entire integer by extracting digits one by one (`num % 10`) and building `reverseNumber`. If the original equals the reversed, it's a palindrome.

Negative numbers are immediately `false` (the `-` sign breaks symmetry).

**TC: O(log₁₀ n) — SC: O(1)**

---

## Steps

1. If `num < 0` return `false`.
2. Save `original = num`.
3. While `num > 0`: extract last digit via `num % 10`, append to `reverseNumber`, divide `num` by 10.
4. Return `original == reverseNumber`.

---

## Example

```
num = 121

Iteration 1: remainder=1, reverseNumber=1,  num=12
Iteration 2: remainder=2, reverseNumber=12, num=1
Iteration 3: remainder=1, reverseNumber=121, num=0

original(121) == reverseNumber(121) → true
```

```
num = -121  → negative → false immediately
num = 10    → reversed = 01 = 1 ≠ 10 → false
```

---

## Test Cases

| input  | output | notes                  |
|--------|--------|------------------------|
| 121    | true   | 3-digit palindrome     |
| -121   | false  | negative number        |
| 10     | false  | trailing zero          |
| 0      | true   | zero is a palindrome   |
| 12321  | true   | 5-digit odd palindrome |
| 1221   | true   | 4-digit even palindrome|
| 123    | false  | not a palindrome       |

---

## Complexity

| | Time | Space |
|-|------|-------|
| Digit reversal | O(log₁₀ n) | O(1) |
