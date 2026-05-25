# Three pointers from the back  TC: O(m + n) SC: O(1)
def merge_sorted_array(nums1, m, nums2, n):
    i, j, k = m - 1, n - 1, m + n - 1

    while i >= 0 and j >= 0:
        if nums1[i] >= nums2[j]:
            nums1[k] = nums1[i]
            i -= 1
        else:
            nums1[k] = nums2[j]
            j -= 1
        k -= 1

    while j >= 0:
        nums1[k] = nums2[j]
        j -= 1
        k -= 1

    return nums1


if __name__ == "__main__":
    test_cases = [
        ([1, 2, 3, 0, 0, 0], 3, [2, 5, 6],  3, [1, 2, 2, 3, 5, 6]),
        ([1],                 1, [],          0, [1]),
        ([0],                 0, [1],         1, [1]),
        ([4, 5, 6, 0, 0, 0], 3, [1, 2, 3],  3, [1, 2, 3, 4, 5, 6]),
        ([1, 2, 4, 5, 6, 0], 5, [3],         1, [1, 2, 3, 4, 5, 6]),
    ]

    for nums1, m, nums2, n, expected in test_cases:
        result = merge_sorted_array(nums1[:], m, nums2[:], n)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")
