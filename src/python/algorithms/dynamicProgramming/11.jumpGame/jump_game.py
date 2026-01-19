"""
Jump Game

Given an array of non-negative integers nums, you are initially positioned at the first index.
Each element represents your maximum jump length at that position.
Determine if you can reach the last index.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def can_jump(nums):
    """
    Greedy approach tracking max reachable position.
    TC: O(n), SC: O(1)
    """
    max_reach = 0
    
    for i, jump in enumerate(nums):
        if i > max_reach:
            return False
        max_reach = max(max_reach, i + jump)
        if max_reach >= len(nums) - 1:
            return True
    
    return True


def can_jump_backward(nums):
    """
    Greedy approach from the end.
    TC: O(n), SC: O(1)
    """
    goal = len(nums) - 1
    
    for i in range(len(nums) - 2, -1, -1):
        if i + nums[i] >= goal:
            goal = i
    
    return goal == 0


# Test cases
if __name__ == "__main__":
    test_cases = [
        [2, 3, 1, 1, 4],  # True
        [3, 2, 1, 0, 4],  # False
    ]
    
    for nums in test_cases:
        print(f"nums: {nums}")
        print(f"Can jump: {can_jump(nums)}")
        print()
