"""
Coin Change

Given an integer array coins representing coins of different denominations and an integer amount,
return the fewest number of coins that you need to make up that amount.

Time Complexity: O(amount * len(coins))
Space Complexity: O(amount)
"""


def coin_change(coins, amount):
    """
    Bottom-up dynamic programming.
    TC: O(amount * len(coins)), SC: O(amount)
    """
    dp = [float('inf')] * (amount + 1)
    dp[0] = 0
    
    for i in range(1, amount + 1):
        for coin in coins:
            if coin <= i:
                dp[i] = min(dp[i], dp[i - coin] + 1)
    
    return dp[amount] if dp[amount] != float('inf') else -1


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"coins": [1, 2, 5], "amount": 11},  # 3 (5+5+1)
        {"coins": [2], "amount": 3},          # -1
        {"coins": [1], "amount": 0},          # 0
    ]
    
    for test in test_cases:
        print(f"Coins: {test['coins']}, Amount: {test['amount']}")
        print(f"Min coins: {coin_change(test['coins'], test['amount'])}")
        print()
