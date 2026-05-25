from typing import List


def move_zeros1(nums: List[int]) -> List[int]:
    """Two pointers (swap) TC: O(n) SC: O(1)"""
    left = 0
    for right in range(len(nums)):
        if nums[right] != 0:
            if left != right:
                nums[left], nums[right] = nums[right], nums[left]
            left += 1
    return nums


def move_zeros2(nums: List[int]) -> List[int]:
    """Two passes (overwrite) TC: O(n) SC: O(1)"""
    left = 0
    for right in range(len(nums)):
        if nums[right] != 0:
            nums[left] = nums[right]
            left += 1
    for i in range(left, len(nums)):
        nums[i] = 0
    return nums


if __name__ == "__main__":
    test_cases = [
        ([0, 1, 0, 3, 12], [1, 3, 12, 0, 0]),
        ([0],               [0]),
        ([1, 2, 3],         [1, 2, 3]),
        ([0, 0, 0],         [0, 0, 0]),
        ([1, 2, 0, 0],      [1, 2, 0, 0]),
    ]

    print("--- move_zeros1 (swap) ---")
    for nums, expected in test_cases:
        result = move_zeros1(nums[:])
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")

    print("--- move_zeros2 (two passes) ---")
    for nums, expected in test_cases:
        result = move_zeros2(nums[:])
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")
