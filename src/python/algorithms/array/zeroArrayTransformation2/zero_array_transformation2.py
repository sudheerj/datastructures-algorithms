# Binary search + difference array + prefix sum  TC: O((n+q) log q) SC: O(n)
def min_zero_array(nums, queries):
    n = len(nums)
    q = len(queries)

    def is_zero_array(k):
        diff_arr = [0] * (n + 1)
        for i in range(k):
            l, r = queries[i]
            diff_arr[l] += 1
            diff_arr[r + 1] -= 1
        current_coverage = 0
        for i in range(n):
            current_coverage += diff_arr[i]
            if current_coverage < nums[i]:
                return False
        return True

    left, right, answer = 0, q, -1
    while left <= right:
        mid = (left + right) // 2
        if is_zero_array(mid):
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    return answer


if __name__ == "__main__":
    test_cases = [
        ([2, 0, 2],    [[0, 2], [0, 2], [1, 1]],           2),
        ([4, 3, 2, 1], [[1, 3], [0, 2]],                   -1),
        ([1, 2, 3, 4], [[0, 3], [1, 3], [2, 3], [3, 3]],   4),
        ([0, 0, 0],    [[0, 1], [1, 2]],                    0),
        ([1, 2, 3],    [[0, 2], [1, 2], [2, 2]],            3),
    ]

    for nums, queries, expected in test_cases:
        result = min_zero_array(nums, queries)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] nums={nums} result={result} expected={expected}")
