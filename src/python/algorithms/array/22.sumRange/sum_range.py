"""
Range Sum Query - Immutable

Given an integer array nums, implement a class that supports:
sumRange(left, right) - returns the sum of elements between indices left and right inclusive.

Time Complexity: O(n) for initialization, O(1) for query
Space Complexity: O(n)
"""


class SumRange:
    """
    Using prefix sum array for O(1) range queries.
    """
    
    def __init__(self, nums):
        """TC: O(n), SC: O(n)"""
        self.prefix_sum = [0] * (len(nums) + 1)
        
        for i in range(len(nums)):
            self.prefix_sum[i + 1] = self.prefix_sum[i] + nums[i]
    
    def sum_range(self, left, right):
        """TC: O(1), SC: O(1)"""
        return self.prefix_sum[right + 1] - self.prefix_sum[left]


# Test cases
if __name__ == "__main__":
    nums = [6, -3, 1, 5, 3, 7, -5]
    sum_range_instance = SumRange(nums)
    
    print(f"Array: {nums}")
    print(f"Sum range (0, 3): {sum_range_instance.sum_range(0, 3)}")  # 9
    print(f"Sum range (2, 6): {sum_range_instance.sum_range(2, 6)}")  # 11
    print(f"Sum range (0, 6): {sum_range_instance.sum_range(0, 6)}")  # 14
