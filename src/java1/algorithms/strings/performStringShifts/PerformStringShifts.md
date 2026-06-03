# Perform String Shifts

## Problem
Given a string `s` and a list of shift operations, where each operation is `[direction, amount]`:
- `direction == 0`: shift left by `amount`.
- `direction == 1`: shift right by `amount`.
Return the final string after all shifts.

## Approach
- Compute the net shift by summing all left and right shifts.
- Convert the net shift to an effective right shift.
- Use string slicing to perform the shift efficiently.
- **Time Complexity:** O(m + n) (m = number of operations, n = string length)
- **Space Complexity:** O(n)

## Test Cases
| s         | shift operations                  | Output   | Explanation                        |
|-----------|-----------------------------------|----------|------------------------------------|
| "abc", [[0,1],[1,2]]           | "cab"    | left 1: "bca", right 2: "cab"      |
| "abcdefg", [[1,1],[1,1],[0,2],[1,3]] | "efgabcd" | right 1: "gabcdef", right 1: "fgabcde", left 2: "abcdefg", right 3: "efgabcd" |
| "x", [[0,100]]                 | "x"      | left 100: no effect                 |
| "hello", [[1,5]]               | "hello"  | right 5: no effect                  |
| "rotation", [[0,3],[1,4]]      | "tionrota"| left 3: "ationrot", right 4: "tionrota" |

## Code Links
- [Java](PerformStringShifts.java)
- [Python](../../../../python/algorithms/strings/perform_string_shifts.py)
- [JavaScript](../../../../javascript/algorithms/strings/performStringShifts.js)
