def singleNonDuplicate(nums):
    left, right = 0, len(nums) - 1
    while left < right:
        mid = left + (right - left) // 2
        if mid % 2 == 1:
            mid -= 1
        if nums[mid] == nums[mid + 1]:
            left = mid + 2
        else:
            right = mid
    return nums[left]

def run_tests():
    tests = [
        [1,1,2,3,3,4,4,8,8],
        [3,3,7,7,10,11,11],
        [1,1,2,2,3,3,4,4,5],
        [0,1,1,2,2,3,3],
        [1,1,2,2,3,3,4],
        [5],
        [1,1,2],
    ]
    expected = [2,10,5,0,4,5,2]
    print("Testing singleNonDuplicate (binary search):")
    for i, test in enumerate(tests):
        result = singleNonDuplicate(test[:])
        print(f"Test {i+1}: Output={result}, Expected={expected[i]} [{'PASS' if result == expected[i] else 'FAIL'}]")

if __name__ == "__main__":
    run_tests()
