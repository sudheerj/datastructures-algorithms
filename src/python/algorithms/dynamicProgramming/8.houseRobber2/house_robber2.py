"""
House Robber II

All houses at this place are arranged in a circle (first and last are adjacent).
Determine the maximum amount of money you can rob without alerting police.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def rob(nums):
    """
    Rob either first to second-last OR second to last.
    TC: O(n), SC: O(1)
    """
    if not nums:
        return 0
    if len(nums) == 1:
        return nums[0]
    if len(nums) == 2:
        return max(nums)
    
    def rob_linear(houses):
        prev2, prev1 = 0, 0
        for num in houses:
            current = max(prev1, prev2 + num)
            prev2 = prev1
            prev1 = current
        return prev1
    
    # Either rob houses[0:n-1] or houses[1:n]
    return max(rob_linear(nums[:-1]), rob_linear(nums[1:]))


# Test cases
if __name__ == "__main__":
    test_cases = [
        [2, 3, 2],      # 3
        [1, 2, 3, 1],   # 4
        [1, 2, 3],      # 3
    ]
    
    for nums in test_cases:
        print(f"Houses: {nums}")
        print(f"Max robbery: {rob(nums)}")
        print()
