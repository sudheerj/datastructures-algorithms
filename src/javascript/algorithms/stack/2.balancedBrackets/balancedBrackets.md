# Balanced Brackets

Balanced brackets is a classic problem that checks whether every opening bracket in a string has a corresponding and correctly ordered closing bracket. This is commonly used in parsing expressions, validating code, and more.

The problem supports the following bracket types: `()`, `{}`, `[]`, `<>`.

## Problem Statement

Given a string `str` containing the characters '(', ')', '{', '}', '[', ']', '<', and '>', determine whether the input string is valid. A string is valid if:

1. Every open bracket is closed by the same type of bracket.
2. Brackets are closed in the correct order.

## Examples

**Example 1**  
Input: `str = "()[]{}<>"`  
Output: `true`

**Example 2**  
Input: `str = "[({<>})]"`  
Output: `true`

**Example 3**  
Input: `str = "([)]"`  
Output: `false`

## Algorithm

This problem is solved using stack operations(**push and pop**) to track opening brackets and ensure they are closed in the correct order.

1. If the string is empty, return `true`.
2. If the string has an odd length, return `false` (since brackets must come in pairs).
3. Initialize an empty stack.
4. Iterate over each character in the string:
    - If the character is an opening bracket (`(`, `{`, `[`, `<`), push it onto the stack.
    - If the character is a closing bracket (`)`, `}`, `]`, `>`):
        - If the stack is empty or the top of the stack does not match the corresponding opening bracket, return `false`.
        - Otherwise, pop the top element from the stack.
5. After processing all characters, return `true` if the stack is empty (all brackets matched); otherwise, return `false`.


## Complexity

- **Time Complexity:** O(n), where n is the length of the string. This is because of traversal over the characters in a string at most once.
- **Space Complexity:** O(n), for the stack in the worst case (all opening brackets).