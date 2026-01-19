"""
Maximum Sum Circular Subarray

Given a circular integer array nums, return the maximum possible sum
of a non-empty subarray of nums.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def max_sum_circular_subarray(nums):
    """
    Kadane's algorithm tracking both max and min subarrays.
    TC: O(n), SC: O(1)
    """
    if not nums:
        return 0
    
    global_max_sum = nums[0]
    global_min_sum = nums[0]
    current_max_sum = 0
    current_min_sum = 0
    total_sum = 0
    
    for num in nums:
        current_max_sum = max(current_max_sum + num, num)
        global_max_sum = max(current_max_sum, global_max_sum)
        
        current_min_sum = min(current_min_sum + num, num)
        global_min_sum = min(current_min_sum, global_min_sum)
        
        total_sum += num
    
    # If all numbers are negative, total_sum - global_min_sum would be 0
    # So return global_max_sum in this case
    if global_max_sum > 0:
        return max(global_max_sum, total_sum - global_min_sum)
    return global_max_sum


# Test cases
if __name__ == "__main__":
    test_cases = [
        [9, -9, 6, 11, -6, -10, 15, 1],
        [6, -2, 6],
        [-6, -2, -6],
        []
    ]
    
    for nums in test_cases:
        result = max_sum_circular_subarray(nums)
        print(f"Input: {nums} => Max Circular Subarray Sum: {result}")
