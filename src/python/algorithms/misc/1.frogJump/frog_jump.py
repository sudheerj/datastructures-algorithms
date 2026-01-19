"""
Frog Jump

A small frog wants to get to the other side of the road.
The frog is currently located at position X and wants to get to position Y.
The frog always jumps a fixed distance D. Count the minimal number of jumps.

Time Complexity: O(1)
Space Complexity: O(1)
"""

import math


def frog_jump(x, y, d):
    """
    Calculate minimum jumps needed.
    TC: O(1), SC: O(1)
    """
    distance = y - x
    return math.ceil(distance / d)


# Test cases
if __name__ == "__main__":
    print(f"frog_jump(10, 85, 30) = {frog_jump(10, 85, 30)}")  # 3
    print(f"frog_jump(0, 100, 10) = {frog_jump(0, 100, 10)}")  # 10
    print(f"frog_jump(5, 5, 3) = {frog_jump(5, 5, 3)}")        # 0
    print(f"frog_jump(1, 10, 3) = {frog_jump(1, 10, 3)}")      # 3
