"""
Stone Wall

Given an array of heights representing a stone wall skyline, find the minimum
number of rectangular stone blocks required to build the wall.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def stone_wall(heights):
    """
    Monotonic stack approach to count minimum blocks.
    TC: O(n), SC: O(n)
    """
    stack = []
    blocks = 0

    for height in heights:
        # Remove blocks that are taller than current height
        while stack and stack[-1] > height:
            stack.pop()

        # If stack is empty or current height is new, add a new block
        if not stack or stack[-1] < height:
            stack.append(height)
            blocks += 1

    return blocks


# Test cases
if __name__ == "__main__":
    test_cases = [
        ([8, 8, 5, 7, 9, 8, 7, 4, 8], 7),
        ([1, 1, 1, 1], 1),
        ([1, 2, 3, 4], 4),
        ([4, 3, 2, 1], 4),
        ([1, 3, 2, 3, 1], 5),
    ]

    for heights, expected in test_cases:
        result = stone_wall(heights)
        status = "Passed" if result == expected else "Failed"
        print(f"{status} | Heights: {heights} | Output: {result} | Expected: {expected}")
