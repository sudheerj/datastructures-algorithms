"""
Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most one transaction.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def max_profit(prices):
    """
    One pass solution tracking minimum price.
    TC: O(n), SC: O(1)
    """
    if not prices:
        return 0
    
    min_price = prices[0]
    max_profit_val = 0
    
    for price in prices[1:]:
        if price < min_price:
            min_price = price
        else:
            max_profit_val = max(max_profit_val, price - min_price)
    
    return max_profit_val


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
