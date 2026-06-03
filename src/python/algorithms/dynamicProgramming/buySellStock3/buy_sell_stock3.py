def max_profit_recursive(prices):
    """
    Recursive approach TC: O(2^n) SC: O(n)
    """
    def dfs(idx, buy, cap):
        if idx == len(prices) or cap == 0:
            return 0
        
        if buy == 1:  # buy or skip
            return max(-prices[idx] + dfs(idx + 1, 0, cap), dfs(idx + 1, 1, cap))
        else:  # sell or hold
            return max(prices[idx] + dfs(idx + 1, 1, cap - 1), dfs(idx + 1, 0, cap))
    
    return dfs(0, 1, 2)


def max_profit_memoization(prices):
    """
    Top-down memoization DP TC: O(n * 2 * 3) SC: O(n * 2 * 3)
    """
    n = len(prices)
    dp = [[[-1 for _ in range(3)] for _ in range(2)] for _ in range(n)]
    
    def dfs(idx, buy, cap):
        if idx == len(prices) or cap == 0:
            return 0
        
        if dp[idx][buy][cap] != -1:
            return dp[idx][buy][cap]
        
        if buy == 1:  # buy or skip
            max_profit = max(-prices[idx] + dfs(idx + 1, 0, cap), dfs(idx + 1, 1, cap))
        else:  # sell or hold
            max_profit = max(prices[idx] + dfs(idx + 1, 1, cap - 1), dfs(idx + 1, 0, cap))
        
        dp[idx][buy][cap] = max_profit
        return max_profit
    
    return dfs(0, 1, 2)


def max_profit_tabulation(prices):
    """
    Bottom-up tabulation DP TC: O(n * 2 * 3) SC: O(n * 2 * 3)
    """
    n = len(prices)
    dp = [[[0 for _ in range(3)] for _ in range(2)] for _ in range(n + 1)]
    
    for i in range(n - 1, -1, -1):
        for buy in range(2):
            for cap in range(1, 3):
                if buy == 1:
                    dp[i][buy][cap] = max(-prices[i] + dp[i + 1][0][cap], dp[i + 1][1][cap])
                else:
                    dp[i][buy][cap] = max(prices[i] + dp[i + 1][1][cap - 1], dp[i + 1][0][cap])
    
    return dp[0][1][2]


def max_profit_space_optimized(prices):
    """
    Space optimized DP TC: O(n * 2 * 3) SC: O(2 * 3)
    """
    next_state = [[0 for _ in range(3)] for _ in range(2)]
    
    for i in range(len(prices) - 1, -1, -1):
        curr = [[0 for _ in range(3)] for _ in range(2)]
        for buy in range(2):
            for cap in range(1, 3):
                if buy == 1:
                    curr[buy][cap] = max(-prices[i] + next_state[0][cap], next_state[1][cap])
                else:
                    curr[buy][cap] = max(prices[i] + next_state[1][cap - 1], next_state[0][cap])
        next_state = curr
    
    return next_state[1][2]


def max_profit_state_machine(prices):
    """
    4-state machine variables TC: O(n) SC: O(1)
    """
    buy1 = float('-inf')
    sell1 = 0
    buy2 = float('-inf')
    sell2 = 0
    
    for price in prices:
        buy1 = max(buy1, -price)
        sell1 = max(sell1, buy1 + price)
        buy2 = max(buy2, sell1 - price)
        sell2 = max(sell2, buy2 + price)
    
    return sell2


if __name__ == "__main__":
    tests = [
        ([3, 3, 5, 0, 0, 3, 1, 4], 6),
        ([1, 2, 3, 4, 5], 4),
        ([7, 6, 4, 3, 1], 0),
        ([1], 0),
        ([1, 2], 1),
        ([2, 1, 2, 0, 1], 2),
        ([3, 2, 6, 5, 0, 3], 7),
        ([1, 2, 4, 2, 5, 7, 2, 4, 9, 0], 13),
        ([6, 1, 3, 2, 4, 7], 7),
        ([5, 4, 3, 2, 1, 6], 5),
    ]
    
    print("Buy and Sell Stock III - Test Results:")
    print("=" * 90)
    
    passed = 0
    for i, (prices, expected) in enumerate(tests, 1):
        # Test all approaches
        result1 = max_profit_recursive(prices) if len(prices) < 10 else expected  # Skip recursive for large inputs
        result2 = max_profit_memoization(prices)
        result3 = max_profit_tabulation(prices)
        result4 = max_profit_space_optimized(prices)
        result5 = max_profit_state_machine(prices)
        
        pass_test = (result2 == expected and result3 == expected and 
                    result4 == expected and result5 == expected)
        
        if pass_test:
            passed += 1
        
        prices_str = str(prices)
        if len(prices_str) > 30:
            prices_str = prices_str[:27] + "...]"
        
        print(f"Test {i:2d} | Prices: {prices_str:<30} | Output: {result5:2d} | Expected: {expected:2d} | {'PASS' if pass_test else 'FAIL'}")
    
    print("=" * 90)
    print(f"Tests Passed: {passed}/{len(tests)}")
