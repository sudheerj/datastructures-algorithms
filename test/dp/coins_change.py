def coins_change(coins, amount):
    dp = [float('inf')] * (amount + 1)

    dp[0] = 0

    for i in range(1, amount+1):
        for coin in coins:
            if i-coin >= 0:
                dp[i] = min(dp[i], 1+dp[i-coin])

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
        print(f"Min coins: {coins_change(test['coins'], test['amount'])}")
        print()
