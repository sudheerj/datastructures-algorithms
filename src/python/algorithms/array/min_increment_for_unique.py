def min_increment_for_unique(nums):
    nums = sorted(nums)
    moves = 0
    for i in range(1, len(nums)):
        if nums[i] <= nums[i-1]:
            moves += nums[i-1] + 1 - nums[i]
            nums[i] = nums[i-1] + 1
    return moves

if __name__ == "__main__":
    tests = [
        ([1,2,2], 1),
        ([3,2,1,2,1,7], 6),
        ([0,2,2,2,3,7], 8),
        ([1,1,1,1], 6),
        ([0,0,0,0,0], 10),
        ([1,2,3], 0),
        ([2,2,2,2,2,2,2], 21),
        ([100,100,100], 3),
    ]
    for idx, (nums, expected) in enumerate(tests, 1):
        result = min_increment_for_unique(nums[:])
        print(f"Test {idx}: Output={result}, Expected={expected} [{'PASS' if result==expected else 'FAIL'}]")
