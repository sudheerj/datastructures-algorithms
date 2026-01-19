"""
Set Mismatch

You have a set of integers s, which originally contains all numbers from 1 to n.
Due to an error, one number is duplicated and one is missing.
Find the duplicate and missing numbers.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def find_duplicate_and_missing(nums):
    """
    Mark indices using negation to find duplicate and missing.
    TC: O(n), SC: O(1)
    """
    length = len(nums)
    duplicate = -1
    missing = -1
    
    for num in nums:
        num = abs(num)
        if nums[num - 1] < 0:
            duplicate = num
        else:
            nums[num - 1] = -nums[num - 1]
    
    for i in range(length):
        if nums[i] > 0:
            missing = i + 1
    
    return [duplicate, missing]


def find_duplicate_and_missing_math(nums):
    """
    Using math formulas.
    TC: O(n), SC: O(1)
    """
    n = len(nums)
    expected_sum = (n * (n + 1)) // 2
    expected_square_sum = (n * (n + 1) * (2 * n + 1)) // 6
    
    actual_sum = sum(nums)
    actual_square_sum = sum(x * x for x in nums)
    
    # diff = missing - duplicate
    diff = expected_sum - actual_sum
    # square_diff = missing^2 - duplicate^2 = (missing + duplicate)(missing - duplicate)
    square_diff = expected_square_sum - actual_square_sum
    # sum_value = missing + duplicate
    sum_value = square_diff // diff
    
    missing = (diff + sum_value) // 2
    duplicate = sum_value - missing
    
    return [duplicate, missing]


# Test cases
if __name__ == "__main__":
    test_cases = [
        [1, 3, 3, 4],  # Output: [3, 2]
        [1, 1],        # Output: [1, 2]
        [2, 2],        # Output: [2, 1]
    ]
    
    for nums in test_cases:
        result = find_duplicate_and_missing(nums.copy())
        print(f"Input: {nums} => Duplicate: {result[0]}, Missing: {result[1]}")
