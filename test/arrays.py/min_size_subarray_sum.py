def min_size_subarray_sum(nums, target):
    left = right = 0
    total = 0
    min_length = float("inf")

    for right in range(len(nums)):
        total += nums[right]

        while total >= target:
            min_length = min(min_length, right-left+1)
            total -= nums[left]
            left += 1
    return min_length if min_length != float("inf") else 0

# Test cases
if __name__ == "__main__":
    test_cases = [
        {"target": 7, "nums": [2, 4, 1, 2, 4, 3]},  # Output: 2
        {"target": 5, "nums": [1, 5, 5, 5]},        # Output: 1
        {"target": 15, "nums": [2, 2, 2, 2, 2]},    # Output: 0
    ]
    
    for test in test_cases:
        print(f"Input: target = {test['target']}, nums = {test['nums']}")
        print(f"Output: {min_size_subarray_sum(test['nums'], test['target'])}")
        print()
