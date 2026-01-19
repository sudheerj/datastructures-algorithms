"""
Tape Equilibrium

A non-empty array A of N integers. Any integer P, where 0 < P < N,
splits this tape into two non-empty parts.
Find the minimal absolute difference between the two parts.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def tape_equilibrium(nums):
    """
    Single pass tracking left and right sums.
    TC: O(n), SC: O(1)
    """
    total_sum = sum(nums)
    min_diff = float('inf')
    left_sum = 0
    
    for i in range(len(nums) - 1):  # Don't include last element (need non-empty right)
        left_sum += nums[i]
        right_sum = total_sum - left_sum
        diff = abs(left_sum - right_sum)
        min_diff = min(min_diff, diff)
    
    return min_diff


# Test cases
if __name__ == "__main__":
    test_cases = [
        [3, 1, 2, 4, 3],  # Output: 1
        [5, 6, 2, 4, 1],  # Output: 4
        [1, 2],           # Output: 1
        [-10, -5, -3, -4, -5],  # Output: 3
    ]
    
    for nums in test_cases:
        result = tape_equilibrium(nums)
        print(f"Input: {nums} => Min difference: {result}")
