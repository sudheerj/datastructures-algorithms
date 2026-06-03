def flood_fill(image, sr, sc, color):
    """
    Perform flood fill on an image starting from position (sr, sc).
    
    TC: O(m * n) where m is rows and n is columns
    SC: O(m * n) for recursion stack in worst case
    
    Args:
        image: 2D list representing the image
        sr: starting row index
        sc: starting column index
        color: new color to fill
        
    Returns:
        Modified image after flood fill
    """
    original_color = image[sr][sc]
    
    # if already same color, no need to process
    if original_color == color:
        return image
    
    def dfs(r, c):
        # boundary + color check
        if r < 0 or r >= len(image) or c < 0 or c >= len(image[0]) or image[r][c] != original_color:
            return
        
        # update current cell color
        image[r][c] = color
        
        # explore all 4 directions
        dfs(r-1, c)  # up
        dfs(r, c+1)  # right
        dfs(r+1, c)  # down
        dfs(r, c-1)  # left
    
    dfs(sr, sc)
    return image


if __name__ == "__main__":
    # Test case 1
    image1 = [[1,1,1],[1,1,0],[1,0,1]]
    print("Test case 1:")
    print(f"Input: image = {image1}")
    print(f"sr = 1, sc = 1, color = 2")
    result1 = flood_fill(image1, 1, 1, 2)
    print(f"Output: {result1}")
    print("Expected: [[2,2,2],[2,2,0],[2,0,1]]")
    print("Explanation: From the center of the image with position (sr, sc) = (1, 1) (0-indexed),")
    print("all pixels connected by a path of the same color as the starting pixel are colored with the new color.")
    print()

    # Test case 2
    image2 = [[0,0,0],[0,0,0]]
    print("Test case 2:")
    print(f"Input: image = {image2}")
    print(f"sr = 0, sc = 0, color = 0")
    result2 = flood_fill(image2, 0, 0, 0)
    print(f"Output: {result2}")
    print("Expected: [[0,0,0],[0,0,0]]")
    print("Explanation: The starting pixel is already colored 0, so no change is made.")
    print()

    # Test case 3
    image3 = [[0,0,0],[0,1,1]]
    print("Test case 3:")
    print(f"Input: image = {image3}")
    print(f"sr = 1, sc = 1, color = 1")
    result3 = flood_fill(image3, 1, 1, 1)
    print(f"Output: {result3}")
    print("Expected: [[0,0,0],[0,1,1]]")
    print("Explanation: The starting pixel is already colored 1, which is the same as the new color.")
    print()

    # Test case 4
    image4 = [[1,1,1],[1,1,0],[1,0,1]]
    print("Test case 4:")
    print(f"Input: image = {image4}")
    print(f"sr = 1, sc = 0, color = 3")
    result4 = flood_fill(image4, 1, 0, 3)
    print(f"Output: {result4}")
    print("Expected: [[3,3,3],[3,3,0],[3,0,1]]")
    print("Explanation: All pixels with color 1 connected to position (1,0) are changed to 3.")
    print()

    # Test case 5
    image5 = [[0,0,0],[0,1,0],[0,0,0]]
    print("Test case 5:")
    print(f"Input: image = {image5}")
    print(f"sr = 1, sc = 1, color = 2")
    result5 = flood_fill(image5, 1, 1, 2)
    print(f"Output: {result5}")
    print("Expected: [[0,0,0],[0,2,0],[0,0,0]]")
    print("Explanation: Only the center pixel is changed since it's isolated.")
