**Problem statement:**
Given two integers representing the `numerator` and `denominator` of a fraction, return the fraction in string format. If the fractional part is repeating, enclose the repeating part in parentheses. If multiple answers are possible, return any of them.

## Examples:

```
Input: numerator = 1, denominator = 2
Output: "0.5"

Input: numerator = 2, denominator = 1
Output: "2"

Input: numerator = 4, denominator = 333
Output: "0.(012)"

Input: numerator = 1, denominator = 3
Output: "0.(3)"
```

## Approach 1: Long Division with HashMap

**Algorithmic Steps**
1. Handle the edge case where `numerator == 0` — return `"0"`.
2. Determine the sign: if exactly one of the two numbers is negative, prepend `"-"`.
3. Work with absolute values (cast to `long` to avoid overflow).
4. Append the integer part (`num / den`) to the result. Compute the initial `remainder = num % den`.
5. If `remainder == 0`, return the result immediately.
6. Append `"."` and enter the long-division loop:
   - Use a `HashMap<remainder, position>` to track where each remainder was first seen.
   - If the current remainder is already in the map, insert `"("` at the stored position and append `")"` to close the repeating segment — then break.
   - Otherwise, store `(remainder → current result length)`, multiply remainder by 10, append `remainder / den`, update `remainder %= den`.
7. Return the completed string.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time       | O(d)  |
| Space      | O(d)  |

> `d` = denominator (bounds the number of unique remainders before a cycle must appear)
