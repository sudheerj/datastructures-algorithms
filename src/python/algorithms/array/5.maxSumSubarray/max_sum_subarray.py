"""
Maximum Subarray (Kadane's Algorithm)

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def max_subarray(nums):
    """
    Kadane's Algorithm.
    TC: O(n), SC: O(1)
    """
    max_sum = nums[0]
    current_sum = nums[0]
    
    for i in range(1, len(nums)):
        current_sum = max(nums[i], current_sum + nums[i])
        max_sum = max(max_sum, current_sum)
    
    return max_sum


def max_subarray_with_indices(nums):
    """
    Returns max sum along with start and end indices.
    TC: O(n), SC: O(1)
    """
    max_sum = nums[0]
    current_sum = nums[0]
    start = end = 0
    temp_start = 0
    
    for i in range(1, len(nums)):
        if nums[i] > current_sum + nums[i]:
            current_sum = nums[i]
            temp_start = i
        else:
            current_sum = current_sum + nums[i]
        
        if current_sum > max_sum:
            max_sum = current_sum
            start = temp_start
            end = i
    
    return max_sum, start, end


# Test cases
if __name__ == "__main__":
    test_cases = [
        [-2, 1, -3, 4, -1, 2, 1, -5, 4],  # 6 (subarray [4,-1,2,1])
        [1],                               # 1
        [5, 4, -1, 7, 8],                  # 23
    ]
    
    for nums in test_cases:
        print(f"Input: {nums}")
        print(f"Max sum: {max_subarray(nums)}")
        result = max_subarray_with_indices(nums)
        print(f"Max sum with indices: sum={result[0]}, start={result[1]}, end={result[2]}")
        print()
