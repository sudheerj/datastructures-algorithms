**Description:**
Given a string, reduce it by repeatedly removing pairs of adjacent identical characters until no more removals can be made. If the final string is empty, return `"Empty String"`.

## Examples

**Example 1:**  
Input: `"aaabccddd"`  
Output: `"abd"`

**Example 2:**  
Input: `"aa"`  
Output: `"Empty String"`

**Example 3:**  
Input: `"baab"`  
Output: `"Empty String"`

**Example 4:**  
Input: `"abc"`  
Output: `"abc"`

## Algorithm

This problem is efficiently solved using a **stack**:

1. Initialize an empty stack.
2. Iterate through each character of the string.
3. If the stack is non-empty and the top element equals the current character, pop the top (removing the adjacent pair).
4. Otherwise, push the current character onto the stack.
5. After processing all characters, join the stack into a string.
6. Return the result, or `"Empty String"` if the stack is empty.

## Complexity

- **Time Complexity:** O(n), where n is the length of the string. Each character is pushed and popped at most once.
- **Space Complexity:** O(n), for the stack.