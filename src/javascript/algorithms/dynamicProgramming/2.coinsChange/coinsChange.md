# Coin Change

**Description:**
Given an array of coins (`coins`) that contains different coin denominations and an integer `amount` which represents the total amount of money you want to make with these coins, calculate the minimum number of coins needed to make up the given amount. If it is not possible to make up the amount, return -1.

**Constraints:**
- `0 <= amount <= 10^4`
- `1 <= coins.length <= 12`
- `1 <= coins[i] <= 2^{31} - 1`
- Each coin denomination is a positive integer.
- You may use each coin as many times as needed.

#### Examples
| coins        | amount | Output | Explanation          |
| ------------ | ------ | ------ | -------------------- |
| [1, 3, 4, 5] | 7      | 2      | 3+4 or 4+3           |
| [2, 4]       | 3      | -1     | Not possible         |
| [1, 2, 5]    | 11     | 3      | 5+5+1 or 5+1+5, etc. |
| [1]          | 0      | 0      | No coins needed      |

### Approaches

#### 1. Dynamic Programming (Bottom-Up Array)
- Build up the solution from 0 to amount using an array.

**Steps:**
1. Create an array `dp` of size `amount+1`, initialized to `amount+1` (impossible value).
2. Set `dp[0] = 0` (0 coins needed for amount 0).
3. For each amount `i` from 1 to `amount`:
    - For each coin in `coins`, if `i - coin >= 0`, set `dp[i] = min(dp[i], 1 + dp[i - coin])`.
4. If `dp[amount]` is still `amount+1`, return -1 (not possible). Otherwise, return `dp[amount]`.

#### 2. Recursive with Memoization
- Recursively try all combinations, memoizing results to avoid recomputation.

**Steps:**
1. Use a memoization object to store results for each sub-amount.
2. For each coin, recursively compute the minimum coins for `amount - coin`.
3. Store and return the minimum found for the current amount.
4. If the result is Infinity, return -1.

| Approach       | Time Complexity   | Space Complexity | Notes                           |
| -------------- | ----------------- | ---------------- | ------------------------------- |
| DP Array       | O(amount * coins) | O(amount)        | Fastest, preferred              |
| Recursive+Memo | O(amount * coins) | O(amount)        | Elegant, slower for large input |

#### Edge Cases
- `amount = 0`: Should return 0 (no coins needed).
- `coins = []`: Should return -1 (no coins to use).
- Negative or non-integer input: Should throw an error.
- Coin denominations with duplicates: Still works, but duplicates are redundant.

**Time and Space complexity:**
This algorithm has a time complexity of `O(amount * coins)`, where `amount` is the number of amount values from `1` to given input `amount` and `coins` indicates number of given coins. This is because we are traversing all the amount values with a list of coins.

Here, we will use array datastructure to store the minimum coins count for each amount value. Hence, the space complexity will be `O(amount)`.
