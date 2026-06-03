def maxFrequency(nums, k):
    nums.sort()
    left = 0
    total = 0
    res = 1
    for right in range(len(nums)):
        total += nums[right]
        while nums[right] * (right - left + 1) > total + k:
            total -= nums[left]
            left += 1
        res = max(res, right - left + 1)
    return res

def run_tests():
    tests = [
        ([1,2,4], 5),
        ([1,4,8,13], 5),
        ([3,9,6], 2),
        ([1,1,1,2,2,4], 0),
        ([1,2,2,2,2,2], 3),
        ([1], 0),
        ([1,2,3,4,5], 10),
    ]
    expected = [3,2,1,3,6,1,5]
    print("Testing maxFrequency (sliding window):")
    for i, (arr, k) in enumerate(tests):
        result = maxFrequency(arr[:], k)
        print(f"Test {i+1}: Output={result}, Expected={expected[i]} [{'PASS' if result == expected[i] else 'FAIL'}]")

if __name__ == "__main__":
    run_tests()
