"""
Maximum Gap

Given an integer array nums, return the maximum difference between two
successive elements in its sorted form. Return 0 if fewer than 2 elements.

Uses bucket sort (Pigeonhole principle) to achieve O(n) time.

Time Complexity: O(n)
Space Complexity: O(n)
"""
import math


def maximum_gap(nums: list[int]) -> int:
    """
    Bucket sort approach.
    TC: O(n), SC: O(n)
    """
    if not nums or len(nums) < 2:
        return 0

    n = len(nums)
    min_val, max_val = min(nums), max(nums)

    if min_val == max_val:
        return 0

    bucket_size = math.ceil((max_val - min_val) / (n - 1))
    bucket_count = (max_val - min_val) // bucket_size + 1

    bucket_min = [float('inf')] * bucket_count
    bucket_max = [float('-inf')] * bucket_count

    for num in nums:
        index = (num - min_val) // bucket_size
        bucket_min[index] = min(bucket_min[index], num)
        bucket_max[index] = max(bucket_max[index], num)

    max_gap = 0
    previous_max = min_val

    for i in range(bucket_count):
        if bucket_min[i] == float('inf'):
            continue
        max_gap = max(max_gap, bucket_min[i] - previous_max)
        previous_max = bucket_max[i]

    return max_gap


if __name__ == "__main__":
    test_cases = [
        ([3, 6, 9, 1],    3),
        ([10],             0),
        ([1, 1, 1, 1],    0),
        ([1, 10000000],   9999999),
        ([1, 3, 6, 10],   4),
        ([5, 1],           4),
    ]

    for nums, expected in test_cases:
        result = maximum_gap(nums)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] nums={nums} → {result} (expected {expected})")
