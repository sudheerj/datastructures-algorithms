# **Coin Change**

## **Problem Statement**
You are given an integer array `coins` and an integer `amount`. Return the fewest number of coins needed to make up that amount. Return `-1` if impossible.

---

## **Examples**

### Example 1:
- **Input**: `coins = [1, 2, 5], amount = 11`
- **Output**: `3` (5 + 5 + 1)

### Example 2:
- **Input**: `coins = [2], amount = 3`
- **Output**: `-1`

---

## **Algorithmic Approach (Dynamic Programming)**

1. Create dp array of size `amount + 1`, initialized to infinity.
2. `dp[0] = 0` (0 coins for amount 0).
3. For each amount from 1 to target:
   - For each coin denomination:
   - If coin <= current amount: `dp[i] = min(dp[i], dp[i-coin] + 1)`
4. Return `dp[amount]` if not infinity, else -1.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(amount * coins)`  
  Nested loops through amounts and coins.

- **Space Complexity**: `O(amount)`  
  For the dp array.
