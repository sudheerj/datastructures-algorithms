# Brute force with HashSet TC: O(n^2) SC: O(n)
def subarray_with_k_diff_integers1(nums, k):
    n = len(nums)
    count = 0
    for i in range(n):
        count_set = set()
        for j in range(i, n):
            count_set.add(nums[j])
            if len(count_set) > k:
                break
            if len(count_set) == k:
                count += 1
    return count


# Sliding window: exactlyK = atMostK - atMostK(k-1)  TC: O(n) SC: O(k)
def subarray_with_k_diff_integers2(nums, k):
    return _at_most_k(nums, k) - _at_most_k(nums, k - 1)


def _at_most_k(nums, k):
    left = 0
    count = 0
    freq = {}
    for right in range(len(nums)):
        freq[nums[right]] = freq.get(nums[right], 0) + 1
        while len(freq) > k:
            freq[nums[left]] -= 1
            if freq[nums[left]] == 0:
                del freq[nums[left]]
            left += 1
        count += right - left + 1
    return count


if __name__ == "__main__":
    test_cases = [
        ([1, 2, 1, 2, 3], 2, 7),
        ([1, 2, 1, 3, 4], 3, 3),
        ([1, 1, 1, 1, 1], 1, 15),
        ([1, 2, 3],       1, 3),
        ([1, 2, 3, 4, 5], 2, 4),
    ]

    for nums, k, expected in test_cases:
        for approach, fn in enumerate([subarray_with_k_diff_integers1,
                                       subarray_with_k_diff_integers2], start=1):
            result = fn(nums, k)
            status = "PASS" if result == expected else "FAIL"
            print(f"[{status}] approach={approach} nums={nums} k={k} result={result} expected={expected}")
