def get_largest_outlier(nums):
    from collections import Counter
    freq = Counter(nums)
    total = sum(nums)
    largest = float('-inf')
    for num in nums:
        freq[num] -= 1
        rem = total - num
        if rem % 2 == 0:
            target = rem // 2
            if freq[target] > 0:
                largest = max(largest, num)
        freq[num] += 1
    return int(largest) if largest != float('-inf') else -2147483648

if __name__ == "__main__":
    test_cases = [
        ([1, 2, 3, 4, 6], 6),
        ([1, 1, 1, 3, 5], 5),
        ([2, 2, 2, 2, 8], 8),
        ([1, 2, 3, 5, 9], 9),
        ([1, 2, 3, 4, 5], -2147483648),
        ([10, 20, 30, 40, 100], 100),
        ([5, 5, 10, 15, 25], 25),
        ([1, 1, 1, 1, 1], -2147483648)
    ]
    for i, (arr, expected) in enumerate(test_cases, 1):
        result = get_largest_outlier(arr)
        status = "PASS" if result == expected else "FAIL"
        print(f"Test {i} | Output: {result} | Expected: {expected} | {status}")
