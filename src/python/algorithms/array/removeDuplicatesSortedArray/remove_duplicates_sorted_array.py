from typing import List


def remove_duplicates1(nums: List[int]) -> int:
    """Two pointers TC: O(n) SC: O(1)"""
    left = 0
    for j in range(1, len(nums)):
        if nums[j] != nums[left]:
            left += 1
            nums[left] = nums[j]
    return left + 1


def remove_duplicates2(nums: List[int]) -> int:
    """Two pointers (previous element comparison) TC: O(n) SC: O(1)"""
    left = 1
    for right in range(1, len(nums)):
        if nums[right] != nums[right - 1]:
            nums[left] = nums[right]
            left += 1
    return left


if __name__ == "__main__":
    test_cases = [
        ([1, 1, 2],                     2, [1, 2]),
        ([0, 0, 1, 1, 1, 2, 2, 3, 3, 4], 5, [0, 1, 2, 3, 4]),
        ([1, 2, 3, 4, 5],               5, [1, 2, 3, 4, 5]),
        ([1],                            1, [1]),
        ([7, 7, 7, 7],                  1, [7]),
    ]

    print("--- remove_duplicates1 (left pointer) ---")
    for nums, expected_k, expected_arr in test_cases:
        arr = nums[:]
        k = remove_duplicates1(arr)
        result_arr = arr[:k]
        status = "PASS" if k == expected_k and result_arr == expected_arr else "FAIL"
        print(f"[{status}] k={k} array={result_arr}")

    print("--- remove_duplicates2 (prev element comparison) ---")
    for nums, expected_k, expected_arr in test_cases:
        arr = nums[:]
        k = remove_duplicates2(arr)
        result_arr = arr[:k]
        status = "PASS" if k == expected_k and result_arr == expected_arr else "FAIL"
        print(f"[{status}] k={k} array={result_arr}")
