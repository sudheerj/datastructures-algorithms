**Description:**
Given an input string `str` which consists of words and spaces, return the length of the last word in the string.

**Note:** A word is considered as a maximal substring of non-space characters.

## Examples

**Example 1:**  
Input: `"Welcome to DSA"`  
Output: `3`

**Example 2:**  
Input: `" My pet is fluffy  "`  
Output: `6`

**Example 3:**  
Input: `"   "`  
Output: `0`

## Algorithm

This problem is efficiently solved by traversing the string from the end:

1. Start from the last character of the string.
2. Skip any trailing spaces.
3. Count the length of the last word by iterating backwards until a space or the start of the string is reached.
4. Return the length.

## Complexity

- **Time Complexity:** O(n), where n is the length of the string. This is because we may need to iterate entire string incase of single word string(worst case scenario).
- **Space Complexity:** O(1), as only a few variables are used.