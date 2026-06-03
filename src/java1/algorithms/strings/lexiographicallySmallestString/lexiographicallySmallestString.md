# Lexicographically Smallest String After Substring Operation

## Problem Statement
Given a string `s`, you can choose a non-empty substring and decrease every character in it by 1 (i.e., 'b' becomes 'a', ..., 'a' becomes 'z'). You can perform this operation at most once. Return the lexicographically smallest string you can obtain after applying the operation at most once.

## Approach
- Greedily find the first segment of non-'a' characters (skipping leading 'a's).
- Decrease each character in this segment by 1.
- If all characters are 'a', change the last character to 'z'.
- Time Complexity: O(n)
- Space Complexity: O(n)

## Test Cases
| Input    | Expected Output |
|----------|----------------|
| "abcde"  | "aabcd"        |
| "aabc"   | "aaab"         |
| "aaaa"   | "aaaz"         |
| "bca"    | "aba"          |
| "azaz"   | "ayaz"         |
| "a"      | "z"            |
| "b"      | "a"            |
| "ab"     | "aa"           |
| "ba"     | "aa"           |

## Java Implementation
See [LexiographicallySmallestString.java](LexiographicallySmallestString.java)

## Python Implementation
See [lexiographically_smallest_string.py](../../../../python/algorithms/strings/lexiographically_smallest_string.py)

## JavaScript Implementation
See [lexiographicallySmallestString.js](../../../../javascript/algorithms/strings/lexiographicallySmallestString.js)
