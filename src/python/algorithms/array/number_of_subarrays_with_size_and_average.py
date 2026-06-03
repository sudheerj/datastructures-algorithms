def number_of_subarrays(nums, k, threshold):
    count = 0
    window_sum = sum(nums[:k])
    if window_sum >= k * threshold:
        count += 1
    for i in range(k, len(nums)):
        window_sum += nums[i] - nums[i - k]
        if window_sum >= k * threshold:
            count += 1
    return count

if __name__ == "__main__":
    test_nums = [
        [2,2,2,2,5,5,5,8],
        [1,1,1,1,1,1,1,1],
        [11,13,17,23,29,31,7,5,2,3],
        [7,7,7,7,7,7,7],
        [1,2,3,4,5,6,7,8,9],
        [5,5,5,5,5],
        [1,2,3,1,2,3,1,2,3],
        [10,9,8,7,6,5,4,3,2,1]
    ]
    ks = [3, 4, 3, 3, 2, 1, 3, 5]
    thresholds = [4, 2, 20, 7, 8, 5, 4, 7]
    expected = [3, 0, 6, 5, 4, 5, 0, 2]
    for i in range(len(test_nums)):
        result = number_of_subarrays(test_nums[i], ks[i], thresholds[i])
        status = "PASS" if result == expected[i] else "FAIL"
        print(f"Test {i+1} | Output: {result} | Expected: {expected[i]} | {status}")
