# Longest Common Prefix

## Problem
Find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string.

## Approach: Vertical Scanning
Compare characters column by column across all strings using the first string as reference.

1. Iterate through each character index `i` of `strs[0]`
2. For each index, compare `strs[0][i]` with `strs[j][i]` for all other strings
3. If mismatch or index out of bounds, return `strs[0].substring(0, i)`
4. If loop completes, the entire first string is the common prefix

## Example
```
Input: ["flower", "flow", "flight"]
Output: "fl"

Input: ["dog", "racecar", "car"]
Output: ""
```

## Complexity
- **Time:** O(S) — where S is the sum of all characters in all strings (worst case)
- **Space:** O(1) — constant extra space
