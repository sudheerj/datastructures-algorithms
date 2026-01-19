"""
Can Place Flowers

You have a long flowerbed in which some plots are planted (1) and some are not (0).
Flowers cannot be planted in adjacent plots.
Given an integer n, return true if n new flowers can be planted without violating the no-adjacent rule.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def can_place_flowers(flowerbed, n):
    """
    Greedy approach checking each empty plot.
    TC: O(n), SC: O(1)
    """
    count = 0
    i = 0
    
    while i < len(flowerbed):
        # Check if current position is empty and neighbors are also empty
        if (flowerbed[i] == 0 and 
            (i == 0 or flowerbed[i - 1] == 0) and 
            (i == len(flowerbed) - 1 or flowerbed[i + 1] == 0)):
            
            flowerbed[i] = 1
            count += 1
            
            if count >= n:
                return True
            i += 1  # Skip next position since we just planted
        
        i += 1
    
    return count >= n


# Test cases
if __name__ == "__main__":
    test_cases = [
        ([1, 0, 0, 1], 1),      # False
        ([1, 0, 0, 0, 1], 1),   # True
        ([1, 0, 0, 0, 1], 2),   # False
        ([0, 0, 1, 0, 0], 2),   # True
    ]
    
    for flowerbed, n in test_cases:
        result = can_place_flowers(flowerbed.copy(), n)
        print(f"Flowerbed: {flowerbed}, n={n} => Can place: {result}")
