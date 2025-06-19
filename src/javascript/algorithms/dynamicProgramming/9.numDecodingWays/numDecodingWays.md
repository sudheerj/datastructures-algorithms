**Description:**
Given a string `str` containing only digits, return the number of ways to decode it, where 'A' = 1, 'B' = 2, ..., 'Z' = 26. Each digit or pair of digits can be mapped to a letter if it forms a valid code.

**Edge Cases:**
- Empty string: should return 0.
- String starts with '0': should return 0.
- String contains invalid '0' placements (e.g., '100').

## Examples

**Example 1:**
```
Input: str = "221"
Output: 3
Explanation: "221" can be decoded as "BBA", "U A", or "B U".
```

**Example 2:**
```
Input: str = "09"
Output: 0
Explanation: No valid decoding starts with '0'.
```

**Example 3 (Edge):**
```
Input: str = "12"
Output: 2
Explanation: "AB" (1 2) and "L" (12).
```

**Example 4 (Edge):**
```
Input: str = "0"
Output: 0
```

**Example 5 (Edge):**
```
Input: str = "10"
Output: 1
Explanation: Only "J" (10).
```

---

#### Algorithm (Dynamic Programming)
This problem is solved using dynamic programming:

1. If the string is empty or starts with '0', return 0.
2. Use two variables (or a DP array) to keep track of the number of ways to decode up to the previous one and two characters.
3. For each character, check:
    - If the current digit is greater than or equal to '1', add the number of ways up to the previous character.
    - If the two-digit number formed with the previous character is between 10 and 26, add the number of ways up to two characters before.
4. Return the final count.

#### Time and Space complexity:**

**Time Complexity:** `O(n)` - This algorithm has a time complexity of `O(n)`, where `n` is the number of digits in the given string. This is because we need to traverse each character at most once to find the possible ways to decode.

**Space Complexity:** `O(1)` (or `O(n)` if using a DP array) - Here, we are not using any additional data structure other than two variables to store number of ways. Hence, the space complexity will be `O(1)`.



