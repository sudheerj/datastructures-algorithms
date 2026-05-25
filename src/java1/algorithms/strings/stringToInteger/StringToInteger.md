**Problem statement:**
Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer. The algorithm reads and discards leading whitespace, then reads an optional `'+'` or `'-'` sign, then reads as many digit characters as possible and interprets them as a numerical value. If the value falls outside the 32-bit signed integer range `[-2^31, 2^31 - 1]`, clamp it to that range. Stop reading at the first non-digit character after the digits.

## Examples:

```
Input: s = "42"
Output: 42

Input: s = "   -042"
Output: -42

Input: s = "1337c0d3"
Output: 1337

Input: s = "0-1"
Output: 0

Input: s = "-91283472332"
Output: -2147483648
```

## Approach 1: String Traversal

**Algorithmic Steps**
1. Skip all leading whitespace characters.
2. Read at most one `'+'` or `'-'` to determine the sign (default `+1`).
3. Read consecutive digit characters, building the result as `result = result * 10 + digit`.
4. After each digit, check for 32-bit overflow: if `sign * result > MAX_INT`, return `MAX_INT`; if `sign * result < MIN_INT`, return `MIN_INT`.
5. Stop at the first non-digit character and return `sign * result`.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(1)  |
