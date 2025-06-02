**Description:**
Given a string `str`,  return the number of substrings within`str` that are palindromes.

**Note:** A palindrome is a string that reads the same backward as forward.

## Examples

**Example 1:**  
Input: `str = "abcd"`  
Output: `4`  
Explanation: Each character is a palindrome.

**Example 2:**  
Input: `str = "aaa"`  
Output: `6`  
Explanation: All substrings are palindromes: `"a"`, `"a"`, `"a"`, `"aa"`, `"aa"`, `"aaa"`.

**Example 3:**  
Input: `str = "baaab"`  
Output: `9`

## Algorithm

This problem is efficiently solved using the **expand around center** approach:

1. If the string is empty, return 0.
2. For each character in the string, treat it as the center of a palindrome and expand outwards to count all odd and even length palindromic substrings.
3. Use a helper function to expand around the center and count palindromes.
4. Sum the counts for all centers and return the total.


## Complexity

- **Time Complexity:** O(n²)(i.e,  O(n²) +  O(n²)), where n is the length of the string (for each center, expand up to n). This is because finding both odd and event length palindrome takes `O(n) +O(n)` time complexity and it needs to be repeated on each character position which takes O(n).

- **Space Complexity:** O(1), as no extra data structures are used.