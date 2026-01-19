"""
Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def two_sum(nums, target):
    """
    Using hash map.
    TC: O(n), SC: O(n)
    """
    num_map = {}
    
    for i, num in enumerate(nums):
        complement = target - num
        if complement in num_map:
            return [num_map[complement], i]
        num_map[num] = i
    
    return []


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"nums": [2, 7, 11, 15], "target": 9},   # [0, 1]
        {"nums": [3, 2, 4], "target": 6},         # [1, 2]
        {"nums": [3, 3], "target": 6},            # [0, 1]
    ]
    
    for test in test_cases:
        print(f"nums: {test['nums']}, target: {test['target']}")
        print(f"Result: {two_sum(test['nums'], test['target'])}")
        print()
