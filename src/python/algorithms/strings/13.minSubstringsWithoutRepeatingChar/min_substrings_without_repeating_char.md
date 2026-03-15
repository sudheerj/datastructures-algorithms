**Description:**
Given a string, find the minimum number of substrings such that no substring contains repeating characters.

## Examples

**Example 1:**  
Input: `"abcabcbb"`  
Output: `4` (substrings: "abc", "abc", "b", "b")

**Example 2:**  
Input: `"bbbbb"`  
Output: `5` (substrings: "b", "b", "b", "b", "b")

**Example 3:**  
Input: `"pwwkew"`  
Output: `3` (substrings: "pw", "wke", "w")

**Example 4:**  
Input: `""`  
Output: `0`

## Algorithm

This problem is solved using a **greedy** approach with a set:

1. Initialize an empty set `seen` and a counter `count_substrings` to `0`.
2. Iterate through each character in the string.
3. If the character is already in the set (duplicate found), increment the counter and clear the set to start a new substring.
4. Add the current character to the set.
5. After the loop, if the set is non-empty, add 1 to account for the last substring.
6. Return the total count.

## Complexity

- **Time Complexity:** O(n), where n is the length of the string.
- **Space Complexity:** O(k), where k is the size of the character set (at most 26 for lowercase letters).