"""
Transpose of a Matrix

Given a 2D integer array matrix, return the transpose of matrix.
The transpose swaps matrix[r][c] with matrix[c][r].

Time Complexity: O(m * n)
Space Complexity: O(m * n)
"""


def transpose(matrix: list[list[int]]) -> list[list[int]]:
    """
    TC: O(m * n), SC: O(m * n)
    """
    rows, cols = len(matrix), len(matrix[0])
    result = [[0] * rows for _ in range(cols)]

    for r in range(rows):
        for c in range(cols):
            result[c][r] = matrix[r][c]

    return result


if __name__ == "__main__":
    test_cases = [
        ([[1, 2, 3], [4, 5, 6]],
         [[1, 4], [2, 5], [3, 6]],
         "2x3 → 3x2"),

        ([[1, 2, 3], [4, 5, 6], [7, 8, 9]],
         [[1, 4, 7], [2, 5, 8], [3, 6, 9]],
         "3x3 square"),

        ([[42]],
         [[42]],
         "1x1"),

        ([[1, 2, 3]],
         [[1], [2], [3]],
         "1x3 row vector"),
    ]

    for matrix, expected, label in test_cases:
        result = transpose(matrix)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {matrix} → {result} (expected {expected})")
