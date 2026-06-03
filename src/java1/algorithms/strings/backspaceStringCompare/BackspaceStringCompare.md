# Backspace String Compare

## Problem
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

## Approach
- **Two Pointers (Reverse Traversal):** Traverse both strings from the end, skipping characters as needed when '#' is encountered. Compare the resulting characters.
- **Stack Simulation:** Alternatively, use a stack to simulate the typing process for each string, then compare the results.

## Test Cases
| s            | t            | Output |
|--------------|--------------|--------|
| ab#c         | ad#c         | true   |
| ab##         | c#d#         | true   |
| a#c          | b            | false  |
| a##c         | #a#c         | true   |
| xywrrmp      | xywrrmu#p    | true   |
|              |              | true   |
| a#           |              | true   |
| abc#d        | abzz##d      | true   |
| bxj##tw      | bxo#j##tw    | true   |
| nzp#o#g      | b#nzp#o#g    | true   |

## Code Links
- [Java](BackspaceStringCompare.java)
- [Python](../../../../python/algorithms/strings/backspace_string_compare.py)
- [JavaScript](../../../../javascript/algorithms/strings/backspaceStringCompare.js)
