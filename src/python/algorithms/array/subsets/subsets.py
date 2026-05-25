# Approach 1: Backtracking (binary decision tree) TC: O(n * 2^n) SC: O(n * 2^n)
def subsets(nums):
    result = []
    def dfs(i, subset):
        if i >= len(nums):
            result.append(subset[:])
            return
        subset.append(nums[i])
        dfs(i + 1, subset)
        subset.pop()
        dfs(i + 1, subset)
    dfs(0, [])
    return result


# Approach 2: Iterative expansion TC: O(n * 2^n) SC: O(n * 2^n)
def subsets_iterative(nums):
    result = [[]]
    for num in nums:
        result += [subset + [num] for subset in result]
    return result


# Approach 3: Bit masking TC: O(n * 2^n) SC: O(n * 2^n)
def subsets_bitmask(nums):
    n = len(nums)
    result = []
    for mask in range(1 << n):
        subset = [nums[j] for j in range(n) if mask & (1 << j)]
        result.append(subset)
    return result


def normalize(subsets_list):
    return set(tuple(sorted(s)) for s in subsets_list)


if __name__ == "__main__":
    tests = [
        ([1, 2, 3], [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]),
        ([0],       [[], [0]]),
        ([],        [[]]),
        ([1, 2],    [[], [1], [2], [1, 2]]),
    ]

    for nums, expected in tests:
        exp = normalize(expected)
        r1, r2, r3 = subsets(nums), subsets_iterative(nums), subsets_bitmask(nums)
        print(f"{'[PASS]' if normalize(r1) == exp else '[FAIL]'} [Backtracking] input={nums}")
        print(f"{'[PASS]' if normalize(r2) == exp else '[FAIL]'} [Iterative   ] input={nums}")
        print(f"{'[PASS]' if normalize(r3) == exp else '[FAIL]'} [Bit Masking ] input={nums}")

    # Test 5: [1,2,3,4] — expect 2^4 = 16 subsets
    t5 = [1, 2, 3, 4]
    for label, fn in [("Backtracking", subsets), ("Iterative   ", subsets_iterative), ("Bit Masking ", subsets_bitmask)]:
        count = len(fn(t5))
        print(f"{'[PASS]' if count == 16 else '[FAIL]'} [{label}] input=[1,2,3,4] count={count} expected=16")
