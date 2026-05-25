# Difference array + prefix sum  TC: O(n + q) SC: O(n)
def is_zero_array(nums, queries):
    n = len(nums)
    diff_arr = [0] * (n + 1)

    for left, right in queries:
        diff_arr[left] += 1
        diff_arr[right + 1] -= 1

    current_coverage = 0
    for i in range(n):
        current_coverage += diff_arr[i]
        if current_coverage < nums[i]:
            return False

    return True


if __name__ == "__main__":
    test_cases = [
        ([1, 0, 1],    [[0, 2]],                        True),
        ([4, 3, 2, 1], [[1, 3], [0, 2]],                False),
        ([2, 0, 2],    [[0, 2], [0, 2]],                True),
        ([1, 2, 3, 4], [[0, 3], [1, 3], [2, 3], [3, 3]], True),
        ([3, 1, 2],    [[0, 1], [1, 2]],                False),
    ]

    for nums, queries, expected in test_cases:
        result = is_zero_array(nums, queries)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] nums={nums} result={result} expected={expected}")
