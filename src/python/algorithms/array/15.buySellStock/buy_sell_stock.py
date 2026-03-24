"""
Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most one transaction.

Time Complexity: O(n)
Space Complexity: O(1)
"""

"""
One pass solution tracking minimum price.
TC: O(n), SC: O(1)
"""
def max_profit(prices):

    if not prices:
        return 0
    
    min_price = float('inf')
    max_profit = 0
    
    for price in prices:
        min_price = min(min_price, price)
        current_profit = price - min_price
        max_profit = max(max_profit, current_profit)
    
    return max_profit

"""
Two pointers solution.
TC: O(n), SC: O(1)
"""
def max_profit1(prices):

    if not prices:
        return 0

    left, right = 0, 1
    max_profit = 0

    while right in range(len(prices)):
        if prices[right] > prices[left]:
            max_profit = max(max_profit, prices[right]-prices[left])
        else:
            left = right // Jumpt to lower price
        right += 1
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
        print(f"Max profit: {max_profit1(prices)}")

        print()
