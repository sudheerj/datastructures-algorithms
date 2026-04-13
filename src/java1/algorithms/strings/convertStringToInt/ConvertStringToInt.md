# Convert String to Integer (atoi)

## Problem
Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer.

## Algorithm
1. **Skip leading whitespace**
2. **Check sign** (`+` or `-`)
3. **Convert digits** one by one: `result = result * 10 + digit`
4. **Clamp** to `[Integer.MIN_VALUE, Integer.MAX_VALUE]` on overflow

## Example
```
Input: "   -42"
Output: -42

Input: "4193 with words"
Output: 4193

Input: "words and 987"
Output: 0
```

## Complexity
- **Time:** O(n) — single pass through the string
- **Space:** O(1) — constant extra space
