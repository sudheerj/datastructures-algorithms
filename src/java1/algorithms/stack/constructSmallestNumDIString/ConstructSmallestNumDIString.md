# Construct Smallest Number from DI String

## Problem
Given a string `pattern` consisting of only 'I' (increase) and 'D' (decrease), construct the lexicographically smallest permutation of numbers 1 to n+1 that fits the pattern, where n is the length of the pattern.

- 'I' means the next number is greater.
- 'D' means the next number is smaller.

## Approach
- Use a stack to reverse segments of 'D's.
- For each character, push the next number onto the stack.
- When an 'I' is encountered or at the end, pop all elements from the stack to the result.
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

## Test Cases
| pattern   | Output    | Explanation                |
|-----------|-----------|---------------------------|
| "IIIDIDDD"| 123549876 | Follows the DI pattern    |
| "D"       | 21        | Only one decrease         |
| "I"       | 12        | Only one increase         |
| "DDI"     | 3214      | 3>2>1<4                   |
| "IDID"    | 13254     | 1<3>2<5>4                 |
| ""        | 1         | Single number             |

## Code Links
- [Java](ConstructSmallestNumDIString.java)
- [Python](../../../../python/algorithms/stack/construct_smallest_num_di_string.py)
- [JavaScript](../../../../javascript/algorithms/stack/constructSmallestNumDIString.js)
