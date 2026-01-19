"""
Find All Numbers Disappeared in an Array

Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all integers in the range [1, n] that do not appear in nums.

Time Complexity: O(n)
Space Complexity: O(1) excluding output
"""


def find_disappeared_numbers(nums):
    """
    Mark indices as negative to track presence.
    TC: O(n), SC: O(1)
    """
    for i in range(len(nums)):
        index = abs(nums[i]) - 1
        if nums[index] > 0:
            nums[index] = -nums[index]
    
    missing_numbers = []
    for i in range(len(nums)):
        if nums[i] > 0:
            missing_numbers.append(i + 1)
    
    return missing_numbers


def find_disappeared_numbers_set(nums):
    """
    Using set for O(n) space approach.
    TC: O(n), SC: O(n)
    """
    num_set = set(nums)
    missing = []
    
    for i in range(1, len(nums) + 1):
        if i not in num_set:
            missing.append(i)
    
    return missing


# Test cases
if __name__ == "__main__":
    test_cases = [
        [6, 3, 1, 5, 3, 7, 5],  # Output: [2, 4]
        [1, 1],                 # Output: [2]
        [4, 3, 2, 7, 8, 2, 3, 1],  # Output: [5, 6]
    ]
    
    for nums in test_cases:
        result1 = find_disappeared_numbers(nums.copy())
        result2 = find_disappeared_numbers_set(nums)
        print(f"Input: {nums}")
        print(f"  In-place: {result1}")
        print(f"  Using set: {result2}")
