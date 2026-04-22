def search_insert(nums, target):
    left, right = 0, len(nums) - 1
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return left


if __name__ == "__main__":
    test_cases = [
        ([1, 3, 5, 6], 5, 2),
        ([1, 3, 5, 6], 2, 1),
        ([1, 3, 5, 6], 7, 4),
        ([1, 3, 5, 6], 0, 0),
        ([], 3, 0),
        ([1], 0, 0),
        ([1], 2, 1),
        ([1], 1, 0),
    ]
    for i, (nums, target, expected) in enumerate(test_cases, 1):
        result = search_insert(nums, target)
        print(f"Test {i}: search_insert({nums}, {target}) = {result} | Expected: {expected} | {'PASS' if result == expected else 'FAIL'}")
