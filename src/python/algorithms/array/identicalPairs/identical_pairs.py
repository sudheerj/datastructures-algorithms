# Identical Pairs (Number of Good Pairs)
# TC: O(n)  SC: O(n)
from collections import defaultdict


# Approach 1: Frequency counting (running total)
def find_identical_pairs(nums: list[int]) -> int:
    count = 0
    frequency_map: dict[int, int] = defaultdict(int)

    for num in nums:
        count += frequency_map[num]
        frequency_map[num] += 1

    return count


# Approach 2: Combinatorics — nC2 = n*(n-1)//2 per group
def find_identical_pairs2(nums: list[int]) -> int:
    frequency_map: dict[int, int] = defaultdict(int)
    for num in nums:
        frequency_map[num] += 1

    return sum(c * (c - 1) // 2 for c in frequency_map.values())


if __name__ == "__main__":
    test_cases = [
        ([6, 3, 1, 5, 3, 6, 5, 6], 5),  # mixed duplicates
        ([2, 2, 2, 2],             6),  # all same: 4C2=6
        ([1, 2, 3, 4],             0),  # all distinct
        ([1, 1],                   1),  # single pair
        ([1],                      0),  # single element
    ]

    print("--- Approach 1: Frequency Counting ---")
    for nums, expected in test_cases:
        result = find_identical_pairs(nums)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")

    print("--- Approach 2: Combinatorics ---")
    for nums, expected in test_cases:
        result = find_identical_pairs2(nums)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")
