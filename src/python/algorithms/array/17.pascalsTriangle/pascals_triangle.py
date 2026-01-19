"""
Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.

Time Complexity: O(numRows^2)
Space Complexity: O(numRows^2)
"""


def generate_pascals_triangle(num_rows):
    """
    Build Pascal's triangle row by row.
    TC: O(numRows^2), SC: O(numRows^2)
    """
    triangle = []
    
    for row in range(num_rows):
        current_row = [1] * (row + 1)
        
        for col in range(1, row):
            current_row[col] = triangle[row - 1][col - 1] + triangle[row - 1][col]
        
        triangle.append(current_row)
    
    return triangle


# Test cases
if __name__ == "__main__":
    print(f"Pascal's Triangle (5 rows): {generate_pascals_triangle(5)}")
    # [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    
    print(f"Pascal's Triangle (1 row): {generate_pascals_triangle(1)}")
    # [[1]]
    
    print(f"Pascal's Triangle (3 rows): {generate_pascals_triangle(3)}")
    # [[1], [1, 1], [1, 2, 1]]
