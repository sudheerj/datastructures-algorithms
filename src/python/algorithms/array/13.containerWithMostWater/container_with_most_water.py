"""
Container With Most Water

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water can be stored between two lines.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def max_area(heights):
    """
    Two pointer approach.
    TC: O(n), SC: O(1)
    """
    max_water = 0
    left = 0
    right = len(heights) - 1
    
    while left < right:
        height = min(heights[left], heights[right])
        width = right - left
        area = height * width
        max_water = max(max_water, area)
        
        # Move the pointer pointing to the shorter line
        if heights[left] < heights[right]:
            left += 1
        else:
            right -= 1
    
    return max_water


# Test cases
if __name__ == "__main__":
    heights1 = [3, 9, 4, 1, 5, 4, 7, 1, 7]
    print(f"Input: {heights1}")
    print(f"Output: {max_area(heights1)}")  # 49
    
    heights2 = [1, 1]
    print(f"Input: {heights2}")
    print(f"Output: {max_area(heights2)}")  # 1
    
    heights3 = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    print(f"Input: {heights3}")
    print(f"Output: {max_area(heights3)}")  # 49
