**Description:**
Given a numeric string, determine if it can be split into a sequence of two or more consecutive increasing numbers. If yes, return the first number in the sequence. Leading zeros are not allowed.

## Examples

**Example 1:**  
Input: `"1234"`  
Output: `"YES 1"` (sequence: 1, 2, 3, 4)

**Example 2:**  
Input: `"91011"`  
Output: `"YES 9"` (sequence: 9, 10, 11)

**Example 3:**  
Input: `"99100"`  
Output: `"YES 99"` (sequence: 99, 100)

**Example 4:**  
Input: `"101103"`  
Output: `"NO"`

**Example 5:**  
Input: `"010203"`  
Output: `"NO"` (leading zeros not allowed)

## Algorithm

1. Iterate over possible lengths for the first number (from 1 to half the string length).
2. Skip if the string starts with `"0"` (no leading zeros).
3. For each starting length, extract the first number and build the expected consecutive sequence by appending successive numbers.
4. If the built sequence matches the original string, return `"YES"` followed by the first number.
5. If no valid split is found, return `"NO"`.

## Complexity

- **Time Complexity:** O(n²), where n is the length of the string. For each starting length, we build a sequence of up to n characters.
- **Space Complexity:** O(n), for the built sequence string.