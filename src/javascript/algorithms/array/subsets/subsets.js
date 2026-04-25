function subsets(nums) {
    const result = [];
    function dfs(i, subset) {
        if (i >= nums.length) {
            result.push([...subset]);
            return;
        }
        subset.push(nums[i]);
        dfs(i+1, subset);
        subset.pop();
        dfs(i+1, subset);
    }
    dfs(0, []);
    return result;
}

// Example 1: [1,2,3]
// Expected: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
console.log(subsets([1,2,3]));
// Example 2: [0]
// Expected: [[], [0]]
console.log(subsets([0]));
// Example 3: []
// Expected: [[]]
console.log(subsets([]));
