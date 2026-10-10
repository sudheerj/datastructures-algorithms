**Description:**
Alice is texting Bob using her phone. The mapping of digits to letters is shown below. Note that there could be multiple ways of typing a letter sequence using the same digit sequence.

![Phone Keypad](https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png)

Given a string `pressedKeys` representing the keys pressed by Alice, return the total number of possible text messages she could have sent.

Since the answer may be very large, return it modulo 10^9 + 7.

**Keypad Mapping:**
- Key 2: abc (3 letters)
- Key 3: def (3 letters)
- Key 4: ghi (3 letters)
- Key 5: jkl (3 letters)
- Key 6: mno (3 letters)
- Key 7: pqrs (4 letters)
- Key 8: tuv (3 letters)
- Key 9: wxyz (4 letters)

## Examples:
Example 1:

Input: pressedKeys = "22233"
Output: 8
Explanation: The possible text messages are: "aaadd", "abdd", "awdd", "acdd", "badd", "bbdd", "bcdd", "cadd"

Example 2:

Input: pressedKeys = "222222222222222222222222222222222222"
Output: 82876089
Explanation: There are 2082876103 ways of interpreting 36 2's. This is modulo 10^9 + 7.

Example 3:

Input: pressedKeys = "77799"
Output: 12
Explanation: Multiple interpretations exist for 7's and 9's.

**Algorithmic Steps**
This problem is solved using **dynamic programming** to count all possible text interpretations:

1. Initialize a DP array `dp` of size `n+1` where `dp[i]` represents the number of ways to interpret the first `i` key presses.

2. Set `dp[0] = 1` as the base case (empty string has one interpretation).

3. For each position `i` from 1 to `n`:
   - Determine the maximum number of consecutive presses for the current digit (3 for keys 2-6, 8; 4 for keys 7, 9)
   - Start with `dp[i] = dp[i-1]` (single key press interpretation)
   - Check for consecutive same digits going backwards (2, 3, or 4 consecutive presses)
   - If all digits in the range are the same, add `dp[i-j]` to `dp[i]` for valid interpretation
   
4. Apply modulo 10^9 + 7 to prevent overflow.

5. Return `dp[n]` which contains the total number of possible text messages.

**Time and Space complexity:**
The time complexity is `O(n)` where `n` is the length of the pressed keys string. We iterate through each position once and check at most 4 previous positions.

The space complexity is `O(n)` for the DP array storing the count for each position.

## Related Topics
- Dynamic Programming
- String Manipulation
- Counting Problems

## Implementation
- [Java Implementation](./CountNumberOfTexts.java)
- [Python Implementation](../../../../python/algorithms/dynamicProgramming/countNumberOfTexts/count_number_of_texts.py)
- [JavaScript Implementation](../../../../javascript/algorithms/dynamicProgramming/countNumberOfTexts/countNumberOfTexts.js)
