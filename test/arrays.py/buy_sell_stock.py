def max_profit(prices):
    min_price = prices[0]
    max_profit = 0

    for price in prices[1:]:
        min_price = min(min_price, price)
        profit = price - min_price
        max_profit = max(max_profit, profit)

    return max_profit

# Test cases
if __name__ == "__main__":
    test_cases = [
        [7, 1, 5, 3, 6, 4],  # 5 (buy at 1, sell at 6)
        [7, 6, 4, 3, 1],     # 0 (no profit possible)
    ]
    
    for prices in test_cases:
        print(f"Prices: {prices}")
        print(f"Max profit: {max_profit(prices)}")
        print()
