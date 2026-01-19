"""
Pivot Index

Given an array of integers nums, calculate the pivot index.
The pivot index is where the sum of all elements to the left equals
the sum of all elements to the right.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def pivot_index(nums):
    """
    Single pass approach using total sum.
    TC: O(n), SC: O(1)
    """
    total_sum = sum(nums)
    left_sum = 0
    
    for i in range(len(nums)):
        right_sum = total_sum - left_sum - nums[i]
        if right_sum == left_sum:
            return i
        left_sum += nums[i]
    
    return -1


def pivot_index_prefix_sum(nums):
    """
    Using prefix sum maps.
    TC: O(n), SC: O(n)
    """
    n = len(nums)
    left_sum_map = {}
    right_sum_map = {}
    
    left_sum = 0
    for i in range(n):
        if i > 0:
            left_sum += nums[i - 1]
        left_sum_map[i] = left_sum
    
    right_sum = 0
    for i in range(n - 1, -1, -1):
        if i < n - 1:
            right_sum += nums[i + 1]
        right_sum_map[i] = right_sum
    
    for i in range(n):
        if left_sum_map[i] == right_sum_map[i]:
            return i
    
    return -1


# Test cases
if __name__ == "__main__":
    test_cases = [
        [1, 7, 3, 6, 5, 6],  # Output: 3
        [1, 2, 3],           # Output: -1
        [2, 1, -1],          # Output: 0
    ]
    
    for nums in test_cases:
        result1 = pivot_index(nums)
        result2 = pivot_index_prefix_sum(nums)
        print(f"Input: {nums}")
        print(f"  Single pass: {result1}")
        print(f"  Prefix sum: {result2}")
