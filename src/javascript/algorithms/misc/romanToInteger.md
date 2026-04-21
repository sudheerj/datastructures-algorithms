# Roman to Integer

Given a Roman numeral, convert it to an integer.

## Problem
Given a string representing a Roman numeral, return its integer value.

### Example
| Input    | Output |
|----------|--------|
| "III"    | 3      |
| "IV"     | 4      |
| "IX"     | 9      |
| "LVIII"  | 58     |
| "MCMXCIV"| 1994   |
| "XL"     | 40     |
| "XC"     | 90     |
| "CD"     | 400    |
| "CM"     | 900    |

## Approach
- Map each Roman numeral to its integer value.
- Traverse the string, adding or subtracting values based on Roman numeral rules.

## Complexity
- Time: O(n)
- Space: O(1)

## Test Cases
See code files for example-based tests.
