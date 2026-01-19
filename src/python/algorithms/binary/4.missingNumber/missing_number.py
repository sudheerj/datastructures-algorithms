"""
Missing Number

Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def missing_number(nums):
    """
    Using XOR - pairs cancel out.
    TC: O(n), SC: O(1)
    """
    result = len(nums)
    for i, num in enumerate(nums):
        result ^= i ^ num
    return result


def missing_number_sum(nums):
    """
    Using sum formula.
    TC: O(n), SC: O(1)
    """
    n = len(nums)
    expected_sum = n * (n + 1) // 2
    actual_sum = sum(nums)
    return expected_sum - actual_sum


# Test cases
if __name__ == "__main__":
    test_cases = [
        [3, 0, 1],        # 2
        [0, 1],           # 2
        [9, 6, 4, 2, 3, 5, 7, 0, 1],  # 8
    ]
    
    for nums in test_cases:
        print(f"nums: {nums}")
        print(f"Missing number (XOR): {missing_number(nums)}")
        print(f"Missing number (Sum): {missing_number_sum(nums)}")
        print()
