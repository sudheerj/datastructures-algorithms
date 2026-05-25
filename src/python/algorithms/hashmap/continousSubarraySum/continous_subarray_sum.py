from typing import List


def check_subarray_sum1(nums: List[int], k: int) -> bool:
    """Brute force TC: O(n²) SC: O(1)"""
    for i in range(len(nums) - 1):
        total = nums[i]
        for j in range(i + 1, len(nums)):
            total += nums[j]
            if total % k == 0:
                return True
    return False


def check_subarray_sum2(nums: List[int], k: int) -> bool:
    """Prefix sum + hashmap TC: O(n) SC: O(min(n, k))"""
    remainder_map = {0: -1}
    total = 0
    for i, num in enumerate(nums):
        total += num
        remainder = total % k
        if remainder not in remainder_map:
            remainder_map[remainder] = i
        elif i - remainder_map[remainder] > 1:
            return True
    return False


if __name__ == "__main__":
    test_cases = [
        ([23, 2, 4, 6, 7], 6,  True),
        ([23, 2, 6, 4, 7], 6,  True),
        ([23, 2, 6, 4, 7], 13, False),
        ([5, 0, 0, 0],     3,  True),
        ([1, 0],           2,  False),
        ([0, 0],           1,  True),
    ]

    for fn, label in [
        (check_subarray_sum1, "check_subarray_sum1 (brute force)"),
        (check_subarray_sum2, "check_subarray_sum2 (prefix sum + hashmap)"),
    ]:
        print(f"--- {label} ---")
        for nums, k, expected in test_cases:
            result = fn(nums[:], k)
            status = "PASS" if result == expected else "FAIL"
            print(f"[{status}] result={result} expected={expected}")
