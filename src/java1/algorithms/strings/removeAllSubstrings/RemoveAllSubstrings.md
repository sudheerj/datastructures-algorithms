# Remove All Occurrences of a Substring

## Problem
Given two strings s and part, repeatedly remove all occurrences of part from s until part no longer exists in s. Return the final string after all such removals.

**Example:**
- Input: s = "daabcbaabcbc", part = "abc"
- Output: "dab"
- Explanation: Remove "abc" at index 2 => "dabaabcbc". Remove "abc" at index 5 => "dababc". Remove "abc" at index 3 => "dab". Now "abc" no longer exists.

## Approach
- Use a StringBuilder (or stack) to build the result.
- For each character, append to result.
- If the end of result matches part, remove it.
- Repeat until no more matches.
- **Time Complexity:** O(n * m)
- **Space Complexity:** O(n)

## Test Cases
| s                | part | Output | Explanation                |
|------------------|------|--------|---------------------------|
| "daabcbaabcbc"   | "abc"| "dab"  | Remove all "abc"           |
| "axxxxyyyyb"     | "xy" | "axxxxyyyyb" | No "xy" to remove   |
| "aabababa"       | "aba"| "ba"   | Remove "aba" twice         |
| "aaaaa"          | "aa" | "a"    | Remove "aa" twice          |
| "abcabcabc"      | "abc"| ""     | Remove all                 |
| ""               | "a"  | ""     | Empty string               |
| "abc"            | "d"  | "abc"  | No match                   |

## Code Links
- [Java](RemoveAllSubstrings.java)
- [Python](../../../../python/algorithms/strings/remove_all_substrings.py)
- [JavaScript](../../../../javascript/algorithms/strings/removeAllSubstrings.js)
