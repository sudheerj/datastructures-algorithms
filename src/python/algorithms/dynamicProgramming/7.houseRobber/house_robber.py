"""
House Robber

You are a professional robber planning to rob houses along a street.
Adjacent houses have security systems connected.
Determine the maximum amount of money you can rob without alerting police.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def rob(nums):
    """
    Dynamic programming with space optimization.
    TC: O(n), SC: O(1)
    """
    if not nums:
        return 0
    if len(nums) == 1:
        return nums[0]
    
    prev2, prev1 = 0, 0
    
    for num in nums:
        current = max(prev1, prev2 + num)
        prev2 = prev1
        prev1 = current
    
    return prev1


# Test cases
if __name__ == "__main__":
    test_cases = [
        [1, 2, 3, 1],      # 4 (1 + 3)
        [2, 7, 9, 3, 1],   # 12 (2 + 9 + 1)
    ]
    
    for nums in test_cases:
        print(f"Houses: {nums}")
        print(f"Max robbery: {rob(nums)}")
        print()
