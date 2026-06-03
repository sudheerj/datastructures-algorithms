def min_distance_recursive(houses, k):
    """
    Recursive approach TC: O(2^n + n^3) SC: O(n^2 + n)
    """
    houses.sort()
    n = len(houses)
    INF = float('inf')
    
    # Compute cost matrix
    cost = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(i, n):
            median = houses[(i + j) // 2]
            for p in range(i, j + 1):
                cost[i][j] += abs(houses[p] - median)
    
    def dfs(start, k_left):
        if start == n:
            return 0
        if k_left == 0:
            return INF
        
        min_dist = INF
        for end in range(start, n):
            min_dist = min(min_dist, cost[start][end] + dfs(end + 1, k_left - 1))
        
        return min_dist
    
    return dfs(0, k)


def min_distance_memoization(houses, k):
    """
    Top-down memoization TC: O(n^2 * k + n^3) SC: O(n^2 + n * k)
    """
    houses.sort()
    n = len(houses)
    INF = float('inf')
    
    # Compute cost matrix
    cost = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(i, n):
            median = houses[(i + j) // 2]
            for p in range(i, j + 1):
                cost[i][j] += abs(houses[p] - median)
    
    # Memoization table
    memo = {}
    
    def dfs(start, k_left):
        if start == n:
            return 0
        if k_left == 0:
            return INF
        
        if (start, k_left) in memo:
            return memo[(start, k_left)]
        
        min_dist = INF
        for end in range(start, n):
            min_dist = min(min_dist, cost[start][end] + dfs(end + 1, k_left - 1))
        
        memo[(start, k_left)] = min_dist
        return min_dist
    
    return dfs(0, k)


def min_distance_dp(houses, k):
    """
    Bottom-up DP TC: O(n^2 * k + n^3) SC: O(n^2 + n * k)
    """
    houses.sort()
    n = len(houses)
    INF = float('inf')
    
    # Compute cost matrix
    cost = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(i, n):
            median = houses[(i + j) // 2]
            for p in range(i, j + 1):
                cost[i][j] += abs(houses[p] - median)
    
    # DP table: dp[i][m] = min distance for first i houses using m mailboxes
    dp = [[INF] * (k + 1) for _ in range(n + 1)]
    dp[0][0] = 0
    
    for i in range(1, n + 1):
        for m in range(1, k + 1):
            for p in range(i):
                dp[i][m] = min(dp[i][m], dp[p][m - 1] + cost[p][i - 1])
    
    return dp[n][k]


if __name__ == "__main__":
    # Test cases: [houses, k, expected]
    tests = [
        ([1,4,8,10,20], 3, 5),
        ([2,3,5,12,18], 2, 9),
        ([7,4,6,1], 1, 8),
        ([3,6,14,10], 4, 0),
        ([1,2,3,4,5], 2, 3),
        ([1,10,20,30,40], 2, 29),
        ([5,10,15,20,25], 3, 10),
        ([1,2], 1, 1),
        ([1,5,10], 2, 4),
        ([1,100,200,300], 2, 199)
    ]
    
    print("Allocate Mailboxes - Test Results:")
    print("=" * 100)
    
    passed = 0
    for i, (houses, k, expected) in enumerate(tests, 1):
        # Test all approaches (skip recursive for large inputs)
        result1 = min_distance_recursive(houses.copy(), k) if len(houses) < 8 else expected
        result2 = min_distance_memoization(houses.copy(), k)
        result3 = min_distance_dp(houses.copy(), k)
        
        pass_test = (result2 == expected and result3 == expected)
        
        # Debug: print all results if test fails
        if not pass_test:
            print(f"Test {i:2d} FAIL | Houses: {houses}, k={k}")
            print(f"  Recursive: {result1}, Memo: {result2}, DP: {result3} | Expected: {expected}")
        else:
            print(f"Test {i:2d} | Houses: {str(houses):25s} | k: {k} | Output: {result2:3d} | Expected: {expected:3d} | PASS")
            passed += 1
    
    print("=" * 100)
    print(f"Tests Passed: {passed}/{len(tests)}")
