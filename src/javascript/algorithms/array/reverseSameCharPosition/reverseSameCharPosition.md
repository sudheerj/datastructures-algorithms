# reverseSameCharPosition.js

Given a string, reverse it and count how many characters remain at the same position as in the original.

## Steps
1. Iterate over each index `i` from `0` to `len-1`.
2. Compare `str[i]` with `str[len-1-i]` (its position in the reversed string).
3. If they are equal, increment the counter.
4. Return the counter.

## Example

**Input:** "abcba"  
**Output:** 5

**Explanation:** Reversed is "abcba" (same). All 5 characters are at the same position.

**Input:** "hello"  
**Reversed:** "olleh"  
**Positions same:** index 2 → 'l' == 'l' → count = 1

## Test Cases

| Input   | Reversed | Same Position Count |
|---------|----------|---------------------|
| "abcba" | "abcba"  | 5                   |
| "abcd"  | "dcba"   | 0                   |
| "abba"  | "abba"   | 4                   |
| "hello" | "olleh"  | 1                   |
| "aaaa"  | "aaaa"   | 4                   |
| "a"     | "a"      | 1                   |

## Complexity
- Time: O(n)
- Space: O(1)
