# Greatest Common Divisor of Strings

Given two strings `str1` and `str2`, return the largest string `x` such that `x` divides both `str1` and `str2`.

**Note:** For any two strings `a` and `b`, we say "b divides a" if and only if `a = b + b + ... + b` (one or more times).

## Examples

**Example 1:**  
Input: `str1 = "AB", str2 = "AB"`  
Output: `"AB"`

**Example 2:**  
Input: `str1 = "ABCABCABC", str2 = "ABCABC"`  
Output: `"ABC"`

**Example 3:**  
Input: `str1 = "ABABAB", str2 = "AB"`  
Output: `"AB"`

**Example 4:**  
Input: `str1 = "LEET", str2 = "CODE"`  
Output: `""`

## Algorithm

This problem is efficiently solved using **Euclidean's algorithm** for GCD:

1. If `str1 + str2 !== str2 + str1`, return `""` (no common divisor string exists).
2. Compute the GCD of the lengths of `str1` and `str2`.
3. The substring of length GCD from either string is the answer.

## Complexity

- **Time Complexity:** O(n + m), where n and m are the lengths of the two strings (for concatenation and comparison), plus O(log(min(n, m))) for the GCD calculation.
- **Space Complexity:** O(n + m), for the concatenated strings.