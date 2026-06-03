**Problem statement:** Given a string `expression` representing an expression of fraction addition and subtraction, return the calculation result in string format. The result should be an irreducible fraction. If the final result is an integer, change it to the format of a fraction with a denominator `1`.

### Examples

```
Input: expression = "-1/2+1/2"
Output: "0/1"

Input: expression = "1/3-1/2"
Output: "-1/6"

Input: expression = "-1/2+1/2+1/3"
Output: "1/3"
```

**Algorithmic Steps**

1. Initialize `numerator = 0`, `denominator = 1` (representing 0/1).
2. Iterate through the expression character by character:
   a. Read the sign (`+` or `-`), default to `+`.
   b. Parse the integer numerator digits.
   c. Skip the `/` separator.
   d. Parse the integer denominator digits.
   e. Add the current fraction to the running total:
      - `numerator = numerator * den + num * denominator`
      - `denominator = denominator * den`
   f. Reduce by dividing both `numerator` and `denominator` by their GCD.
3. Return `numerator + "/" + denominator`.

| Complexity | Value |
|---|---|
| Time | O(n) |
| Space | O(1) |
