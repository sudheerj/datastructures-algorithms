# Reverse Integer

## Problem
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

## Test Cases

### Test Case 1: Positive number
- Input: 123
- Output: 321

### Test Case 2: Negative number
- Input: -456
- Output: -654

### Test Case 3: Number with trailing zeros
- Input: 1200
- Output: 21

### Test Case 4: Zero
- Input: 0
- Output: 0

### Test Case 5: Overflow positive
- Input: 1534236469
- Output: 0

### Test Case 6: Overflow negative
- Input: -1563847412
- Output: 0
