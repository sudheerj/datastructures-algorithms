**Description:**
Given a string and a shift value, encrypt the string using Caesar cipher. Each letter is shifted by the given number of positions in the alphabet. Non-alphabetic characters remain unchanged.

## Examples

**Example 1:**  
Input: `"Hello, World!"`, shift = `3`  
Output: `"Khoor, Zruog!"`

**Example 2:**  
Input: `"abcXYZ"`, shift = `2`  
Output: `"cdeZAB"`

**Example 3:**  
Input: `"abcXYZ"`, shift = `-2`  
Output: `"yzaVWX"`

**Example 4:**  
Input: `"Caesar Cipher 123!"`, shift = `4`  
Output: `"Geiwev Gmtliv 123!"`

## Algorithm

1. Normalize the shift to the range 0-25 using modulo.
2. Iterate through each character of the string.
3. For uppercase letters, shift using `(char_code - 65 + shift + 26) % 26 + 65`.
4. For lowercase letters, shift using `(char_code - 97 + shift + 26) % 26 + 97`.
5. Non-alphabetic characters are appended unchanged.
6. Return the resulting string.

## Complexity

- **Time Complexity:** O(n), where n is the length of the string.
- **Space Complexity:** O(n), for the result string.