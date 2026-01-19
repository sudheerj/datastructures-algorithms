"""
Set Matrix Zeroes

Given an m x n integer matrix, if an element is 0, set its entire row and column to 0.
Do it in-place.

Time Complexity: O(m * n)
Space Complexity: O(1)
"""


def set_zeroes(matrix):
    """
    Using first row and column as markers.
    TC: O(m * n), SC: O(1)
    """
    if not matrix:
        return
    
    rows, cols = len(matrix), len(matrix[0])
    first_row_zero = False
    first_col_zero = False
    
    # Check if first row has zero
    for j in range(cols):
        if matrix[0][j] == 0:
            first_row_zero = True
            break
    
    # Check if first column has zero
    for i in range(rows):
        if matrix[i][0] == 0:
            first_col_zero = True
            break
    
    # Use first row and column as markers
    for i in range(1, rows):
        for j in range(1, cols):
            if matrix[i][j] == 0:
                matrix[i][0] = 0
                matrix[0][j] = 0
    
    # Set zeros based on markers
    for i in range(1, rows):
        for j in range(1, cols):
            if matrix[i][0] == 0 or matrix[0][j] == 0:
                matrix[i][j] = 0
    
    # Handle first row
    if first_row_zero:
        for j in range(cols):
            matrix[0][j] = 0
    
    # Handle first column
    if first_col_zero:
        for i in range(rows):
            matrix[i][0] = 0


# Test case
if __name__ == "__main__":
    matrix = [
        [1, 1, 1],
        [1, 0, 1],
        [1, 1, 1]
    ]
    
    print("Original matrix:")
    for row in matrix:
        print(row)
    
    set_zeroes(matrix)
    
    print("\nAfter setting zeroes:")
    for row in matrix:
        print(row)
