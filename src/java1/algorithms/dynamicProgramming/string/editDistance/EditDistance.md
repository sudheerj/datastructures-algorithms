# Edit Distance (Levenshtein Distance)

## Problem
Given two strings w1 and w2, return the minimum number of operations required to convert w1 to w2. Allowed operations: insert, delete, replace a character.

## Approach
Dynamic Programming (bottom-up):
- Let dp[i][j] = min operations to convert w1[i:] to w2[j:]
- If w1[i] == w2[j], dp[i][j] = dp[i+1][j+1]
- Else, dp[i][j] = 1 + min(insert, delete, replace)

## Example
```
Input: w1 = "horse", w2 = "ros"
Output: 3
Explanation: horse -> rorse (replace 'h' with 'r'), rorse -> rose (remove 'r'), rose -> ros (remove 'e')
```

## Complexity
- **Time:** O(mn)
- **Space:** O(mn)
