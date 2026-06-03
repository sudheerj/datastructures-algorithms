# Sorting solution TC: O(n log n) SC: O(1)
def maximum_product1(nums: list[int]) -> int:
    nums.sort()
    n = len(nums)
    return max(nums[n-3] * nums[n-2] * nums[n-1], nums[0] * nums[1] * nums[n-1])


# Greedy solution TC: O(n) SC: O(1)
def maximum_product2(nums: list[int]) -> int:
    max1 = max2 = max3 = float('-inf')
    min1 = min2 = float('inf')

    for num in nums:
        if num > max1:
            max3, max2, max1 = max2, max1, num
        elif num > max2:
            max3, max2 = max2, num
        elif num > max3:
            max3 = num

        if num < min1:
            min2, min1 = min1, num
        elif num < min2:
            min2 = num

    return max(max1 * max2 * max3, min1 * min2 * max1)


if __name__ == "__main__":
    test_cases = [
        ([-3, 1, 2, -2, 5, 6],   60),
        ([-10, -10, 1, 3, 2],    300),
        ([1, 2, 3],               6),
        ([-1, -2, -3, -4],       -6),
        ([-5, -4, 1, 2, 3],      60),
        ([1, 2, 3, 4],            24),
    ]

    print("=== maximum_product1 (sorting) ===")
    for nums, expected in test_cases:
        result = maximum_product1(nums[:])
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] nums={nums} result={result} expected={expected}")

    print("=== maximum_product2 (greedy) ===")
    for nums, expected in test_cases:
        result = maximum_product2(nums[:])
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] nums={nums} result={result} expected={expected}")
