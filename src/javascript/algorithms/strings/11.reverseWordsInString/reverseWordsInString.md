**Description:**
Given an input string `str`, return a string of the words in reverse order, concatenated by a single space, without extra spaces.

## Examples

**Example 1:**  
Input: `"It is fun to learn DSA"`  
Output: `"DSA learn to fun is It"`

**Example 2:**  
Input: `"hello DSA"`  
Output: `"DSA hello"`

**Example 3:**  
Input: `"   "`  
Output: `""`

## Algorithm

This problem is efficiently solved using basic string and array operations:

1. Trim the input string to remove leading and trailing spaces.
2. Split the string into an array of words using a regular expression that matches one or more spaces.
3. Reverse the array of words.
4. Join the reversed words with a single space.
5. Return the result.

## Complexity

- **Time Complexity:** O(n), where n is the length of the string (for splitting, reversing, and joining).
- **Space Complexity:** O(n), for storing the array of words.