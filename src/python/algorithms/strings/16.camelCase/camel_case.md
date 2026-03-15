**Description:**
Given a camelCase string, count the number of words in it. Each word starts with an uppercase letter (except the first word).

## Examples

**Example 1:**  
Input: `"saveChangesInTheEditor"`  
Output: `5`

**Example 2:**  
Input: `"oneTwoThree"`  
Output: `3`

**Example 3:**  
Input: `"thisIsCamelCase"`  
Output: `4`

**Example 4:**  
Input: `""`  
Output: `0`

**Example 5:**  
Input: `"singleword"`  
Output: `1`

## Algorithm

1. If the string is empty, return `0`.
2. Initialize a counter to `1` (for the first word which starts with a lowercase letter).
3. Iterate through each character in the string.
4. For each uppercase letter found, increment the counter.
5. Return the counter.

## Complexity

- **Time Complexity:** O(n), where n is the length of the string.
- **Space Complexity:** O(1), as only a counter variable is used.