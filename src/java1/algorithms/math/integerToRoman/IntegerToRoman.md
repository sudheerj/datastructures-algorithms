# Integer to Roman

Given an integer, convert it to a Roman numeral.

## Problem
Given an integer, return its Roman numeral representation.

### Example
| Input | Output    |
| ----- | --------- |
| 3     | "III"     |
| 4     | "IV"      |
| 9     | "IX"      |
| 58    | "LVIII"   |
| 1994  | "MCMXCIV" |
| 40    | "XL"      |
| 90    | "XC"      |
| 400   | "CD"      |
| 900   | "CM"      |

## Approach
- Use value-symbol pairs for Roman numerals.
- Greedily subtract the largest possible value and append the corresponding symbol.

## Complexity
- Time: O(1) (since the number of Roman numeral symbols is constant)
- Space: O(1)

## Test Cases
See code files for example-based tests.
