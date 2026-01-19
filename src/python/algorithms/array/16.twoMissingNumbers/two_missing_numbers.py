"""
Two Missing Numbers

Given an array containing n distinct numbers from 1 to n+2,
find the two missing numbers.

Time Complexity: O(n)
Space Complexity: O(n) or O(1)
"""


def find_two_missing_numbers(nums):
    """
    Using boolean array to track presence.
    TC: O(n), SC: O(n)
    """
    present = [False] * (len(nums) + 2)
    missing_nums = []
    
    for num in nums:
        present[num - 1] = True
    
    for i in range(1, len(nums) + 3):
        if not present[i - 1]:
            missing_nums.append(i)
    
    return missing_nums


def find_two_missing_numbers_optimal(nums):
    """
    Using math (sum formula) for O(1) space.
    TC: O(n), SC: O(1)
    """
    n = len(nums) + 2
    expected_sum = (n * (n + 1)) // 2
    
    actual_sum = sum(nums)
    missing_sum = expected_sum - actual_sum
    missing_avg = missing_sum // 2
    
    expected_sum_until_avg = (missing_avg * (missing_avg + 1)) // 2
    actual_sum_until_avg = sum(num for num in nums if num <= missing_avg)
    
    first_missing = expected_sum_until_avg - actual_sum_until_avg
    second_missing = missing_sum - first_missing
    
    return [first_missing, second_missing]


# Test cases
if __name__ == "__main__":
    test_cases = [
        [3, 2, 5, 1, 6, 8],  # Missing: 4, 7
        [1, 2, 4, 5, 6],     # Missing: 3, 7
        [2, 3, 4, 5, 6, 7],  # Missing: 1, 8
    ]
    
    for nums in test_cases:
        result1 = find_two_missing_numbers(nums)
        result2 = find_two_missing_numbers_optimal(nums)
        print(f"Input: {nums}")
        print(f"  Using array: {result1}")
        print(f"  Using math: {result2}")
