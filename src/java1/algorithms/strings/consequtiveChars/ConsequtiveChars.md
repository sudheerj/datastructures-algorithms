# 446. Consecutive Characters

## Problem
Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character. Return the power of the string.

**Example:**
- Input: "leetcode"
- Output: 2
- Explanation: The substring "ee" is of length 2.

## Approach
- Scan the string, compare each character with the previous one.
- If same, increment streak; else, reset streak to 1.
- Track the maximum streak found.
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Test Cases
| s           | Output | Explanation                |
|-------------|--------|---------------------------|
| "leetcode"  | 2      | "ee"                      |
| "abbcccddddeeeeedcba" | 5 | "eeeee"                |
| "triplepillooooow" | 5 | "ooooo"                  |
| "hooraaaaaaaaaaay" | 11 | "aaaaaaaaaaa"            |
| "tourist"   | 1      | All unique                |
| ""          | 0      | Empty string              |
| "a"         | 1      | Single char               |

## Code Links
- [Java](ConsequtiveChars.java)
- [Python](../../../../python/algorithms/strings/consecutive_characters.py)
- [JavaScript](../../../../javascript/algorithms/strings/consecutiveCharacters.js)
