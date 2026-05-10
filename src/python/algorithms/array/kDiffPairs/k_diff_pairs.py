"""
K-diff Pairs in an Array

Given an integer array nums and integer k, return the number of unique
k-diff pairs where |nums[i] - nums[j]| == k.

Approach 1 - HashSet:   TC O(n),       SC O(n)
Approach 2 - Sorting:   TC O(n log n), SC O(1)
"""


def k_diff_pairs(nums: list[int], k: int) -> int:
    """HashSet approach — TC O(n), SC O(n)"""
    if k < 0:
        return 0

    seen = set()
    pairs = set()

    for num in nums:
        if num - k in seen:
            pairs.add(num - k)
        if num + k in seen:
            pairs.add(num)
        seen.add(num)

    return len(pairs)


def k_diff_pairs_sorting(nums: list[int], k: int) -> int:
    """Two-pointer approach — TC O(n log n), SC O(1)"""
    nums.sort()
    left, right, count = 0, 1, 0

    while right < len(nums):
        diff = nums[right] - nums[left]

        if diff > k:
            right += 1
        elif diff < k:
            left += 1
        else:
            count += 1
            left += 1
            right += 1

        if left == right:
            right += 1

    return count


def k_difference_pairs(nums: list[int], k: int) -> list[tuple[int, int]]:
    """Return the actual pairs (smaller, larger)."""
    seen = set()
    result = []

    for num in nums:
        if num - k in seen:
            result.append((num - k, num))
        seen.add(num)

    return result


if __name__ == "__main__":
    test_cases = [
        ([3, 1, 4, 1, 5], 2, 2, "(1,3),(3,5)"),
        ([1, 2, 3, 4, 5], 1, 4, "(1,2),(2,3),(3,4),(4,5)"),
        ([1, 3, 1, 5, 4], 0, 1, "k=0 duplicate"),
        ([1, 1, 1, 1, 1], 0, 1, "all duplicates"),
        ([1, 2, 4, 4, 3, 3, 0, 9, 2, 3], 3, 2, "(0,3),(1,4)"),
    ]

    print("-- k_diff_pairs (HashSet) --")
    for nums, k, expected, label in test_cases:
        result = k_diff_pairs(nums[:], k)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {nums}, k={k} → {result} (expected {expected})")

    print("\n-- k_diff_pairs_sorting (Two Pointers) --")
    for nums, k, expected, label in test_cases:
        result = k_diff_pairs_sorting(nums[:], k)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: k={k} → {result} (expected {expected})")

    print("\n-- k_difference_pairs (actual pairs) --")
    print(k_difference_pairs([3, 1, 4, 1, 5], 2))  # [(1,3),(3,5)]
