# Add Binary (Java)

Given two binary strings, return their sum as a binary string.

## Example
- Input: a = "11", b = "1"
- Output: "100"

- Input: a = "1010", b = "1011"
- Output: "10101"

## Approach
- Use two pointers from the end of each string, add digits and carry, and build the result.

## Complexity
- Time: O(max(n, m))
- Space: O(max(n, m))

## Test Cases
See `AddBinary.java` for sample test cases.
