"""
Rotate Image

Rotate the image (n x n 2D matrix) by 90 degrees clockwise.
You have to rotate the image in-place.

Time Complexity: O(n^2)
Space Complexity: O(1)
"""


def rotate(matrix):
    """
    Transpose then reverse each row.
    TC: O(n^2), SC: O(1)
    """
    n = len(matrix)
    
    # Transpose the matrix
    for i in range(n):
        for j in range(i + 1, n):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    
    # Reverse each row
    for row in matrix:
        row.reverse()


def rotate_layer_by_layer(matrix):
    """
    Rotate layer by layer.
    TC: O(n^2), SC: O(1)
    """
    n = len(matrix)
    
    for layer in range(n // 2):
        first, last = layer, n - 1 - layer
        
        for i in range(first, last):
            offset = i - first
            
            # Save top
            top = matrix[first][i]
            
            # Left -> Top
            matrix[first][i] = matrix[last - offset][first]
            
            # Bottom -> Left
            matrix[last - offset][first] = matrix[last][last - offset]
            
            # Right -> Bottom
            matrix[last][last - offset] = matrix[i][last]
            
            # Top -> Right
            matrix[i][last] = top


# Test case
if __name__ == "__main__":
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    
    print("Original matrix:")
    for row in matrix:
        print(row)
    
    rotate(matrix)
    
    print("\nRotated 90° clockwise:")
    for row in matrix:
        print(row)
