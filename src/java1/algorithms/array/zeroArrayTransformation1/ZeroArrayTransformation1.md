**Problem statement:**
You are given an integer array `nums` of length `n` and a 2D array `queries` where `queries[i] = [l, r]`. For each query you may decrement every element in `nums[l..r]` by at most 1. All queries are applied. Return `true` if it is possible to make every element in `nums` equal to `0` after applying all queries, otherwise return `false`.

## Examples:

```
Input: nums = [1,0,1], queries = [[0,2]]
Output: true
Explanation: Coverage after applying all queries: [1,1,1]. Each nums[i] ≤ coverage[i].

Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]
Output: false
Explanation: Coverage: [1,2,2,1]. nums[0]=4 > coverage[0]=1 → impossible.
```

## Approach 1: Difference Array + Prefix Sum

**Algorithmic Steps**
1. Create a difference array `diffArr` of size `n + 1`, initialized to 0.
2. For each query `[l, r]`, do `diffArr[l]++` and `diffArr[r+1]--`.
3. Compute the running prefix sum `currentCoverage` while iterating `i` from `0` to `n-1`.
4. At each index `i`, if `currentCoverage < nums[i]`, there are not enough decrements available — return `false`.
5. If all indices pass, return `true`.

**Time and Space complexity:**

| Complexity | Value        |
|------------|--------------|
| Time       | O(n + q)     |
| Space      | O(n)         |
