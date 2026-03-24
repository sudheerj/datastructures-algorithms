def max_profit(prices):
    max_profit = 0

    for i in range(1, len(prices)):
        if prices[i] > prices[i-1]:
            max_profit += prices[i] - prices[i-1]
    return max_profit

# Test cases
if __name__ == "__main__":
    test_cases = [
        [7, 1, 5, 3, 6, 4],  # 7 (buy at 1, sell at 5 and buy at 3, sell at 6)
        [7, 6, 4, 3, 1],     # 0 (no profit possible)
    ]
    
    for prices in test_cases:
        print(f"Prices: {prices}")
        print(f"Max profit: {max_profit(prices)}")

        print()