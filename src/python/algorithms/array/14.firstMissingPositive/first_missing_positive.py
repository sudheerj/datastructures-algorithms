"""
First Missing Positive

Given an unsorted integer array nums, return the smallest positive integer
that is not present in nums.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def first_missing_positive(nums):
    """
    Mark indices using negation for in-place tracking.
    TC: O(n), SC: O(1)
    """
    length = len(nums)
    non_exist_num = length + 1
    
    # Step 1: Replace non-positive and out-of-bound numbers with placeholder
    for i in range(length):
        if nums[i] <= 0 or nums[i] > length:
            nums[i] = non_exist_num
    
    # Step 2: Mark indices for numbers that exist
    for i in range(length):
        val = abs(nums[i])
        if val <= length:
            index = val - 1
            if nums[index] > 0:
                nums[index] = -nums[index]
    
    # Step 3: Find the first index that is still positive
    for i in range(length):
        if nums[i] > 0:
            return i + 1
    
    # Step 4: All numbers from 1 to length are present
    return length + 1


# Test cases
if __name__ == "__main__":
    test_cases = [
        [3, 4, -1, 1],      # Output: 2
        [-1, 7, 8, 9, 11],  # Output: 1
        [1, 2, 0],          # Output: 3
        [1, 2, 3],          # Output: 4
        []                  # Output: 1
    ]
    
    for nums in test_cases:
        result = first_missing_positive(nums.copy())
        print(f"Input: {nums} => First missing positive: {result}")
