**Description:**
Given a string, find the length of the longest valid string formed by selecting exactly two distinct characters such that they alternate throughout the string. If no valid alternating string exists, return `0`.

## Examples

**Example 1:**  
Input: `"beabeefeab"`  
Output: `5`

**Example 2:**  
Input: `"asdcbsdcagfsdbgdfanfghbsfdab"`  
Output: `8`

**Example 3:**  
Input: `"aaaa"`  
Output: `0`

**Example 4:**  
Input: `"ababab"`  
Output: `6`

## Algorithm

1. Find all unique characters in the string.
2. For every pair of unique characters, filter the string to keep only those two characters.
3. Check if the resulting filtered string is a valid alternating string (no two adjacent characters are the same and length > 1).
4. Track the maximum length among all valid pairs.
5. Return the maximum length.

## Complexity

- **Time Complexity:** O(n * k²), where n is the length of the string and k is the number of unique characters. For each pair (k² pairs), we filter and validate the string in O(n).
- **Space Complexity:** O(n), for the filtered string.