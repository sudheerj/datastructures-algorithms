"""
Maximal Square (LeetCode 221)

Find the largest square of 1s in a binary matrix and return its area.

Approach: Dynamic Programming
TC: O(m*n)  SC: O(m*n)
"""


def maximal_square(matrix: list[list[str]]) -> int:
    rows, cols = len(matrix), len(matrix[0])
    dp = [[0] * cols for _ in range(rows)]
    max_side = 0

    for r in range(rows):
        for c in range(cols):
            if matrix[r][c] == '1':
                if r == 0 or c == 0:
                    dp[r][c] = 1
                else:
                    dp[r][c] = 1 + min(dp[r-1][c], dp[r][c-1], dp[r-1][c-1])
                max_side = max(max_side, dp[r][c])

    return max_side * max_side


if __name__ == "__main__":
    test_cases = [
        (
            [['1','0','1','0','0'],
             ['1','0','1','1','1'],
             ['1','1','1','1','1'],
             ['1','0','0','1','0']],
            4, "2x2 square"
        ),
        ([['0','1'],['1','0']], 1, "diagonal 1s"),
        ([['0']],               0, "all zeros"),
        ([['1','1','1'],['1','1','1'],['1','1','1']], 9, "all ones 3x3"),
        ([['1']],               1, "single 1"),
    ]

    for matrix, expected, label in test_cases:
        result = maximal_square(matrix)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {result} (expected {expected})")
