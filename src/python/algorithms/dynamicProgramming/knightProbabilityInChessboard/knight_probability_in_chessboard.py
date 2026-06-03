"""
Knight Probability in Chessboard

Given an n x n chessboard and a knight starting at (row, column),
return the probability that the knight remains on the board after making exactly k moves.
"""


def knight_probability_memoization(n, k, row, column):
    """
    Top-down memoization TC: O(n^2 * k) SC: O(n^2 * k)
    """
    DIRS = [(2, 1), (2, -1), (1, 2), (1, -2), (-2, 1), (-2, -1), (-1, 2), (-1, -2)]
    memo = {}
    
    def dfs(r, c, moves):
        if r < 0 or r >= n or c < 0 or c >= n:
            return 0.0
        
        if moves == 0:
            return 1.0
        
        if (r, c, moves) in memo:
            return memo[(r, c, moves)]
        
        prob = 0.0
        for dr, dc in DIRS:
            prob += dfs(r + dr, c + dc, moves - 1) / 8.0
        
        memo[(r, c, moves)] = prob
        return prob
    
    return dfs(row, column, k)


def knight_probability_dp(n, k, row, column):
    """
    Bottom-up DP with space optimization TC: O(n^2 * k) SC: O(n^2)
    """
    DIRS = [(2, 1), (2, -1), (1, 2), (1, -2), (-2, 1), (-2, -1), (-1, 2), (-1, -2)]
    
    # Initialize board with probability 1.0 at starting position
    dp = [[0.0] * n for _ in range(n)]
    dp[row][column] = 1.0
    
    # For each move
    for _ in range(k):
        next_dp = [[0.0] * n for _ in range(n)]
        
        for r in range(n):
            for c in range(n):
                if dp[r][c] == 0:
                    continue
                
                # Distribute probability to all 8 knight destinations
                for dr, dc in DIRS:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < n and 0 <= nc < n:
                        next_dp[nr][nc] += dp[r][c] / 8.0
        
        dp = next_dp
    
    # Sum all probabilities on the board
    return sum(sum(row) for row in dp)


if __name__ == "__main__":
    # Test cases: [n, k, row, column, expected]
    tests = [
        (3, 2, 0, 0, 0.0625),
        (1, 0, 0, 0, 1.0),
        (8, 30, 6, 4, 0.00019),
        (3, 1, 1, 1, 0.0),
        (8, 0, 4, 4, 1.0),
        (8, 1, 0, 0, 0.25),
        (8, 2, 4, 4, 0.875),
        (5, 2, 2, 2, 0.375),
        (6, 3, 2, 2, 0.359375),
        (4, 3, 1, 1, 0.0703125)
    ]
    
    print("Knight Probability in Chessboard - Test Results:")
    print("=" * 100)
    
    passed = 0
    for i, (n, k, row, column, expected) in enumerate(tests, 1):
        # Test both approaches
        result1 = knight_probability_memoization(n, k, row, column)
        result2 = knight_probability_dp(n, k, row, column)
        
        pass_test = (abs(result1 - expected) < 1e-5 and abs(result2 - expected) < 1e-5)
        
        # Debug: print all results if test fails
        if not pass_test:
            print(f"Test {i:2d} FAIL | n={n}, k={k}, pos=({row},{column})")
            print(f"  Memoization: {result1:.6f}, DP: {result2:.6f} | Expected: {expected:.6f}")
        else:
            print(f"Test {i:2d} | n={n}, k={k:2d}, pos=({row},{column}) | Output: {result1:.6f} | Expected: {expected:.6f} | PASS")
            passed += 1
    
    print("=" * 100)
    print(f"Tests Passed: {passed}/{len(tests)}")
