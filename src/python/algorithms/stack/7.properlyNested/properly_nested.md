**Description:**
Given a string consisting of `(` and `)` characters, determine whether the parentheses are properly nested. Return `1` if properly nested, `0` otherwise.

## Examples

**Example 1:**  
Input: `"(()(())())"`  
Output: `1` (properly nested)

**Example 2:**  
Input: `"())"`  
Output: `0` (improper)

**Example 3:**  
Input: `"("`  
Output: `0` (unclosed)

**Example 4:**  
Input: `""`  
Output: `1` (empty string is properly nested)

## Algorithm

This problem is solved using a simple **counter** (optimized stack for single bracket type):

1. Initialize a counter `stack_count` to `0`.
2. Iterate through each character in the string.
3. If the character is `(`, increment the counter.
4. If the character is `)`, check if the counter is `0` (no matching open bracket) — if so, return `0`. Otherwise, decrement the counter.
5. After the loop, return `1` if the counter is `0` (all brackets matched), otherwise `0`.

## Complexity

- **Time Complexity:** O(n), where n is the length of the string.
- **Space Complexity:** O(1), as only a single counter variable is used.