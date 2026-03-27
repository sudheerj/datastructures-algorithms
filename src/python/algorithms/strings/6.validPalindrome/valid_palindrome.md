**Description:**
Given a string `s`, return `true` if it is a palindrome after converting all uppercase letters to lowercase and removing all non-alphanumeric characters. Otherwise, return `false`.

**Note:** A string is a palindrome if it reads the same forward and backward.

## Examples

**Example 1:**  
Input: `s = "A man, a plan, a canal: Panama"`  
Output: `True`

**Example 2:**  
Input: `s = "race a car"`  
Output: `False`

**Example 3:**  
Input: `s = " "`  
Output: `True`

## Approaches

### 1. Two Pointer
In this approach, two pointers (`left`, `right`) start from opposite ends of the string and move inward, skipping non-alphanumeric characters. At each step, the characters are compared in a case-insensitive manner. The algorithmic approach can be summarized as follows:

1. Initialize `left` at the start and `right` at the end of the string.
2. Skip non-alphanumeric characters by advancing `left` or decrementing `right`.
3. Compare `s[left].lower()` with `s[right].lower()`.
4. If they differ, return `False`.
5. Move both pointers inward and repeat until they meet.
6. If all comparisons pass, return `True`.

### 2. Reverse String
In this approach, a cleaned version of the string is built by filtering out non-alphanumeric characters and converting to lowercase, then compared against its reverse. The algorithmic approach can be summarized as follows:

1. Build a new string containing only lowercase alphanumeric characters from `s`.
2. Compare the cleaned string with its reverse (`cleaned[::-1]`).
3. If they are equal, return `True`; otherwise return `False`.

## Complexity

The two pointer approach takes a time complexity of `O(n)`, where `n` represents the length of the string. This is because each character is visited at most once by either pointer.
Also, it requires space complexity of `O(1)` since no additional data structures are used.

| Approach       | Time Complexity | Space Complexity |
| -------------- | --------------- | ---------------- |
| Two Pointer    | O(n)            | O(1)             |
| Reverse String | O(n)            | O(n)             |

- `n` = length of the input string
