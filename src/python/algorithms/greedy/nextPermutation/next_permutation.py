def next_permutation(nums):
    n = len(nums)
    i = n - 2

    # Step 1: Find pivot (first decreasing element from right)
    while i >= 0 and nums[i] >= nums[i + 1]:
        i -= 1

    # Step 2: If pivot exists, find next larger element in suffix and swap
    if i >= 0:
        j = n - 1
        while nums[j] <= nums[i]:
            j -= 1
        nums[i], nums[j] = nums[j], nums[i]

    # Step 3: Reverse the suffix
    left, right = i + 1, n - 1
    while left < right:
        nums[left], nums[right] = nums[right], nums[left]
        left += 1
        right -= 1

    return nums


if __name__ == "__main__":
    tests = [
        ([1, 2, 3], [1, 3, 2]),
        ([3, 2, 1], [1, 2, 3]),
        ([1, 1, 5], [1, 5, 1]),
        ([1, 3, 2], [2, 1, 3]),
        ([2, 3, 1], [3, 1, 2]),
    ]

    for i, (nums, expected) in enumerate(tests, 1):
        result = next_permutation(list(nums))
        status = "PASS" if result == expected else "FAIL"
        print(f"{status} test {i}: result={result} expected={expected}")
