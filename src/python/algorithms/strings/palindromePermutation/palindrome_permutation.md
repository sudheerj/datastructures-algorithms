# Palindrome Permutation

## Problem
Given a string, determine if a permutation of the string could form a palindrome.

## Example
```
Input: "aab"
Output: true  (e.g., "aba")

Input: "code"
Output: false
```

## Approach: Set (Odd Frequency Tracking)

Track characters with odd frequencies using a set:
- If a character is **not** in the set, add it (first/odd occurrence).
- If it **is** in the set, remove it (even occurrence cancels out).
- At the end, at most **1** character can have an odd frequency for a valid palindrome.

### Why it works
- Even-length palindromes need all characters in pairs.
- Odd-length palindromes allow exactly one character with an odd count (the middle).

## Complexity
- **Time:** O(n) — single pass through the string
- **Space:** O(1) — at most 26 characters in the set (for lowercase English letters)
