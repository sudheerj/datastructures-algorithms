# Sort + scan adjacent — O(n log n) time, O(n) space
def min_abs_difference(nums):
    nums.sort()
    min_diff = float('inf')
    for i in range(1, len(nums)):
        min_diff = min(min_diff, nums[i] - nums[i - 1])
    result = []
    for i in range(1, len(nums)):
        if nums[i] - nums[i - 1] == min_diff:
            result.append([nums[i - 1], nums[i]])
    return result


if __name__ == "__main__":
    r1 = min_abs_difference([4, 2, 1, 3])
    e1 = [[1, 2], [2, 3], [3, 4]]
    print(f"Test 1: {'[PASS]' if r1 == e1 else '[FAIL]'} result={r1} expected={e1}")

    r2 = min_abs_difference([1, 3, 6, 10, 15])
    e2 = [[1, 3]]
    print(f"Test 2: {'[PASS]' if r2 == e2 else '[FAIL]'} result={r2} expected={e2}")

    r3 = min_abs_difference([3, 8, -10, 23, 19, -4, -14, 27])
    e3 = [[-14, -10], [19, 23], [23, 27]]
    print(f"Test 3: {'[PASS]' if r3 == e3 else '[FAIL]'} result={r3} expected={e3}")

    r4 = min_abs_difference([1, 2, 3])
    e4 = [[1, 2], [2, 3]]
    print(f"Test 4: {'[PASS]' if r4 == e4 else '[FAIL]'} result={r4} expected={e4}")

    r5 = min_abs_difference([-5, 0, 5])
    e5 = [[-5, 0], [0, 5]]
    print(f"Test 5: {'[PASS]' if r5 == e5 else '[FAIL]'} result={r5} expected={e5}")
