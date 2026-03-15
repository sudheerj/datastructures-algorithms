**Description:**
Given a string, determine whether it is a pangram. A pangram is a sentence that contains every letter of the English alphabet at least once.

## Examples

**Example 1:**  
Input: `"The quick brown fox jumps over the lazy dog"`  
Output: `"pangram"`

**Example 2:**  
Input: `"Hello World"`  
Output: `"not pangram"`

**Example 3:**  
Input: `"Sphinx of black quartz, judge my vow"`  
Output: `"pangram"`

## Algorithm

1. Initialize an empty set to store unique alphabet characters.
2. Convert the string to lowercase and iterate through each character.
3. If the character is a letter (a-z), add it to the set.
4. After processing all characters, check if the set has exactly 26 elements.
5. Return `"pangram"` if all 26 letters are present, otherwise `"not pangram"`.

## Complexity

- **Time Complexity:** O(n), where n is the length of the string.
- **Space Complexity:** O(1), as the set can hold at most 26 characters.