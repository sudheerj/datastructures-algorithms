**Description:**

Given a string `str`, return `true` if it is a palindrome, or `false` otherwise.

**Note:** A palindrome is a string that reads the same backward as forward. Ignore non-alphanumeric characters and consider uppercase and lowercase letters as equal.

## Examples

**Example 1:**  
Input: `str = "A man, a plan, a canal: Panama"`  
Output: `true`

**Example 2:**  
Input: `str = "Hello World"`  
Output: `false`

**Example 3:**  
Input: `str = " "`  
Output: `true`

## Algorithm steps

This problem is efficiently solved using the **two-pointer** technique by traversing over the input string.:

1. Initialize two pointers, `left` at the start and `right` at the end of the string.
2. Move `left` forward and `right` backward until both point to alphanumeric characters.
3. Compare the characters at `left` and `right` (case-insensitive).
4. If they are not equal, return `false`.
5. Move both pointers towards the center and repeat.
6. If all characters match, return `true`.

## Complexity

- **Time Complexity:** O(n), where n is the length of the string. This is because we are traversing the string only once.
- **Space Complexity:** O(1), as no extra data structures are used.