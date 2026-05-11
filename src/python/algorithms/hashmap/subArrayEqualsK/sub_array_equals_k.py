"""
Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number
of subarrays whose sum equals k.

Approach: Prefix Sum + HashMap
TC: O(n)  SC: O(n)
"""


def subarray_sum_equals_k(nums: list[int], k: int) -> int:
    prefix_sum_map = {0: 1}  # seed for subarrays starting at index 0
    total = 0
    current_sum = 0

    for num in nums:
        current_sum += num
        total += prefix_sum_map.get(current_sum - k, 0)
        prefix_sum_map[current_sum] = prefix_sum_map.get(current_sum, 0) + 1

    return total


if __name__ == "__main__":
    test_cases = [
        ([1, 1, 1],   2, 2, "[1,1],[1,1]"),
        ([1, 2, 3],   3, 2, "[1,2],[3]"),
        ([3],         3, 1, "[3]"),
        ([1, 2, 3],   6, 1, "[1,2,3]"),
        ([1, 1, 1],   1, 3, "[1],[1],[1]"),
        ([-1, -1, 1], 0, 1, "[-1,1] indices 1-2"),
    ]

    for nums, k, expected, label in test_cases:
        result = subarray_sum_equals_k(nums, k)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {nums}, k={k} → {result} (expected {expected})")
