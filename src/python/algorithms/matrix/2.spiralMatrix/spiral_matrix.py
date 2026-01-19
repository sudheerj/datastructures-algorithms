"""
Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

Time Complexity: O(m * n)
Space Complexity: O(1) excluding output
"""


def spiral_order(matrix):
    """
    Layer by layer approach.
    TC: O(m * n), SC: O(1)
    """
    if not matrix:
        return []
    
    result = []
    top, bottom = 0, len(matrix) - 1
    left, right = 0, len(matrix[0]) - 1
    
    while top <= bottom and left <= right:
        # Traverse right
        for j in range(left, right + 1):
            result.append(matrix[top][j])
        top += 1
        
        # Traverse down
        for i in range(top, bottom + 1):
            result.append(matrix[i][right])
        right -= 1
        
        # Traverse left
        if top <= bottom:
            for j in range(right, left - 1, -1):
                result.append(matrix[bottom][j])
            bottom -= 1
        
        # Traverse up
        if left <= right:
            for i in range(bottom, top - 1, -1):
                result.append(matrix[i][left])
            left += 1
    
    return result


# Test cases
if __name__ == "__main__":
    matrix1 = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    
    matrix2 = [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9, 10, 11, 12]
    ]
    
    print(f"Matrix 1 spiral: {spiral_order(matrix1)}")  # [1,2,3,6,9,8,7,4,5]
    print(f"Matrix 2 spiral: {spiral_order(matrix2)}")  # [1,2,3,4,8,12,11,10,9,5,6,7]
