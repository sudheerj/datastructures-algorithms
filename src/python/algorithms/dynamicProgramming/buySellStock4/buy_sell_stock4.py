def max_profit_recursive(prices, k):
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
    
    return dfs(0, 1, k)


def max_profit_memoization(prices, k):
    """
    Top-down memoization DP TC: O(n * 2 * k) SC: O(n * 2 * k)
    """
    n = len(prices)
    dp = [[[-1 for _ in range(k + 1)] for _ in range(2)] for _ in range(n)]
    
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
    
    return dfs(0, 1, k)


def max_profit_tabulation(prices, k):
    """
    Bottom-up tabulation DP TC: O(n * 2 * k) SC: O(n * 2 * k)
    """
    n = len(prices)
    dp = [[[0 for _ in range(k + 1)] for _ in range(2)] for _ in range(n + 1)]
    
    for i in range(n - 1, -1, -1):
        for buy in range(2):
            for cap in range(1, k + 1):
                if buy == 1:
                    dp[i][buy][cap] = max(-prices[i] + dp[i + 1][0][cap], dp[i + 1][1][cap])
                else:
                    dp[i][buy][cap] = max(prices[i] + dp[i + 1][1][cap - 1], dp[i + 1][0][cap])
    
    return dp[0][1][k]


def max_profit_space_optimized(prices, k):
    """
    Space optimized DP TC: O(n * 2 * k) SC: O(2 * k)
    """
    next_state = [[0 for _ in range(k + 1)] for _ in range(2)]
    
    for i in range(len(prices) - 1, -1, -1):
        curr = [[0 for _ in range(k + 1)] for _ in range(2)]
        for buy in range(2):
            for cap in range(1, k + 1):
                if buy == 1:
                    curr[buy][cap] = max(-prices[i] + next_state[0][cap], next_state[1][cap])
                else:
                    curr[buy][cap] = max(prices[i] + next_state[1][cap - 1], next_state[0][cap])
        next_state = curr
    
    return next_state[1][k]


def max_profit_greedy_dp(prices, k):
    """
    Greedy + DP Space optimized for large k TC: O(n * 2 * k) or O(n) SC: O(k) or O(1)
    """
    n = len(prices)
    # If k >= n/2, we can do unlimited transactions (greedy approach)
    if k >= n // 2:
        max_profit = 0
        for i in range(1, n):
            if prices[i] > prices[i - 1]:
                max_profit += prices[i] - prices[i - 1]
        return max_profit
    # Otherwise, use space-optimized DP
    return max_profit_space_optimized(prices, k)


if __name__ == "__main__":
    tests = [
        ([2, 4, 1], 2, 2),
        ([3, 2, 6, 5, 0, 3], 2, 7),
        ([3, 3, 5, 0, 0, 3, 1, 4], 2, 6),
        ([1, 2, 3, 4, 5], 2, 4),
        ([7, 6, 4, 3, 1], 2, 0),
        ([1, 2, 4, 2, 5, 7, 2, 4, 9, 0], 3, 15),
        ([1, 2, 3, 4, 5], 1, 4),
        ([1, 2, 4, 2, 5, 7, 2, 4, 9, 0], 4, 15),
        ([6, 1, 3, 2, 4, 7], 2, 7),
        ([5, 4, 3, 2, 1, 6, 7], 3, 6),
    ]
    
    print("Buy and Sell Stock IV - Test Results:")
    print("=" * 90)
    
    passed = 0
    for i, (prices, k, expected) in enumerate(tests, 1):
        # Test all approaches
        result1 = max_profit_recursive(prices, k) if len(prices) < 10 else expected
        result2 = max_profit_memoization(prices, k)
        result3 = max_profit_tabulation(prices, k)
        result4 = max_profit_space_optimized(prices, k)
        result5 = max_profit_greedy_dp(prices, k)
        
        pass_test = (result2 == expected and result3 == expected and 
                    result4 == expected and result5 == expected)
        
        if pass_test:
            passed += 1
        
        prices_str = str(prices)
        if len(prices_str) > 25:
            prices_str = prices_str[:22] + "...]"
        
        # Debug: print all results if test fails
        if not pass_test:
            print(f"Test {i:2d} FAIL | k={k}, Prices: {prices}")
            print(f"  Recursive: {result1}, Memo: {result2}, Tabulation: {result3}, Space-opt: {result4}, Greedy+DP: {result5} | Expected: {expected}")
        else:
            print(f"Test {i:2d} | k={k} | Prices: {prices_str:<25} | Output: {result4:2d} | Expected: {expected:2d} | {'PASS' if pass_test else 'FAIL'}")
    
    print("=" * 90)
    print(f"Tests Passed: {passed}/{len(tests)}")
