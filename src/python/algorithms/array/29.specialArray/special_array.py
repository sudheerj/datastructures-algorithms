"""
Special Array

You are given an array nums of non-negative integers.
The array is special if there exists a number x such that there are exactly x numbers
in nums that are greater than or equal to x.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def special_array(nums):
    """
    Counting sort approach.
    TC: O(n), SC: O(n)
    """
    n = len(nums)
    counts = [0] * (n + 1)
    
    # Step 1: Count frequencies
    for num in nums:
        if num >= n:
            counts[n] += 1
        else:
            counts[num] += 1
    
    elements_greater_than_x = 0
    
    # Step 2: Find x where exactly x elements are >= x
    for x in range(n, 0, -1):
        elements_greater_than_x += counts[x]
        if elements_greater_than_x == x:
            return x
    
    return -1


# Test cases
if __name__ == "__main__":
    test_cases = [
        [2, 3],        # Output: 2
        [0, 0, 0],     # Output: -1
        [0, 4, 3, 0, 4],  # Output: 3
        [3, 5],        # Output: 2
    ]
    
    for nums in test_cases:
        result = special_array(nums)
        print(f"Input: {nums} => Special X: {result}")
