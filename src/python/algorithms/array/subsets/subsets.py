def subsets(nums):
    result = []
    def dfs(i, subset):
        if i >= len(nums):
            result.append(subset[:])
            return
        subset.append(nums[i])
        dfs(i+1, subset)
        subset.pop()
        dfs(i+1, subset)
    dfs(0, [])
    return result

if __name__ == "__main__":
    # Example 1: [1,2,3]
    # Expected: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
    print(subsets([1,2,3]))
    # Example 2: [0]
    # Expected: [[], [0]]
    print(subsets([0]))
    # Example 3: []
    # Expected: [[]]
    print(subsets([]))
