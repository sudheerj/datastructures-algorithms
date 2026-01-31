"""
Diagonal Difference

Given a square matrix, calculate the absolute difference between the sums of 
its diagonals.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def diagonal_difference(matrix):
    """
    Calculate absolute difference between diagonal sums.
    TC: O(n), SC: O(1)
    """
    n = len(matrix)
    primary_sum = 0
    secondary_sum = 0
    
    for i in range(n):
        primary_sum += matrix[i][i]           # Primary diagonal
        secondary_sum += matrix[i][n - 1 - i]  # Secondary diagonal
    
    return abs(primary_sum - secondary_sum)


def diagonal_difference_single_loop(matrix):
    """
    Alternative: Single variable to track difference.
    TC: O(n), SC: O(1)
    """
    n = len(matrix)
    diff = 0
    
    for i in range(n):
        diff += matrix[i][i] - matrix[i][n - 1 - i]
    
    return abs(diff)


# Test cases
if __name__ == "__main__":
    # Example 1
    matrix1 = [
        [11, 2, 4],
        [4, 5, 6],
        [10, 8, -12]
    ]
    # Primary: 11 + 5 + (-12) = 4
    # Secondary: 4 + 5 + 10 = 19
    # |4 - 19| = 15
    print(f"Diagonal difference: {diagonal_difference(matrix1)}")  # 15
    
    # Example 2
    matrix2 = [
        [1, 2, 3],
        [4, 5, 6],
        [9, 8, 9]
    ]
    # Primary: 1 + 5 + 9 = 15
    # Secondary: 3 + 5 + 9 = 17
    # |15 - 17| = 2
    print(f"Diagonal difference: {diagonal_difference(matrix2)}")  # 2
    
    # Example 3: Single element
    matrix3 = [[5]]
    print(f"Diagonal difference: {diagonal_difference(matrix3)}")  # 0
