"""
Find the Smallest Divisor Given a Threshold

Given an array of integers nums and an integer threshold, choose a positive
integer divisor, divide all the array by it, and sum the ceiling values.
Find the smallest divisor such that the result is <= threshold.

Time Complexity: O(n log m)  — n = len(nums), m = max(nums)
Space Complexity: O(1)
"""
import math


def smallest_divisor(nums: list[int], threshold: int) -> int:
    """
    Binary search on divisor space [1, max(nums)].
    TC: O(n log m), SC: O(1)
    """
    left, right = 1, max(nums)

    while left <= right:
        divisor = left + (right - left) // 2
        total = sum(math.ceil(num / divisor) for num in nums)

        if total <= threshold:
            right = divisor - 1
        else:
            left = divisor + 1

    return left


def smallest_divisor_brute(nums: list[int], threshold: int) -> int:
    """
    Linear scan brute force.
    TC: O(n * m), SC: O(1)
    """
    for divisor in range(1, max(nums) + 1):
        if sum(math.ceil(num / divisor) for num in nums) <= threshold:
            return divisor
    return -1


if __name__ == "__main__":
    test_cases = [
        ([1, 2, 5, 9],        6,  5),
        ([2, 3, 5, 7, 11],   11,  3),
        ([19],                5,  4),
        ([1, 2, 3],           6,  1),
        ([44, 22, 33, 11, 1], 5, 44),
        ([1],                 1,  1),
        ([1000000],           1,  1000000),
    ]

    print("Binary Search:")
    for nums, threshold, expected in test_cases:
        result = smallest_divisor(nums, threshold)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] nums={nums}, threshold={threshold} → {result} (expected {expected})")

    print("\nBrute Force:")
    for nums, threshold, expected in test_cases:
        result = smallest_divisor_brute(nums, threshold)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] nums={nums}, threshold={threshold} → {result} (expected {expected})")
