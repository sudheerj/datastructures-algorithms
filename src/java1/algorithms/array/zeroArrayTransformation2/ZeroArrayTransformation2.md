**Problem statement:**
You are given an integer array `nums` of length `n` and a 2D array `queries` where `queries[i] = [l, r]`. For each query you may decrement every element in `nums[l..r]` by at most 1. Return the **minimum number of queries** needed to make all elements equal to 0, or `-1` if it is impossible.

## Examples:

```
Input: nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]
Output: 2
Explanation: Apply first 2 queries. Coverage = [2,2,2] ≥ [2,0,2] → possible.

Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]
Output: -1
Explanation: Even using all queries, coverage[0] = 1 < nums[0] = 4 → impossible.
```

## Approach 1: Binary Search + Difference Array + Prefix Sum

**Algorithmic Steps**
1. Binary search on the answer `k` in range `[0, q]` (number of queries to use).
2. For a given `k`, check feasibility using a difference array:
   - Apply the first `k` queries: `diffArr[l]++`, `diffArr[r+1]--`.
   - Compute prefix sum to get `currentCoverage` at each index `i`.
   - If `currentCoverage < nums[i]` at any index, the first `k` queries are not enough.
3. Binary search: if `k` queries suffice, try fewer (`right = mid - 1`) and record `answer = mid`; otherwise try more (`left = mid + 1`).
4. Return `answer` (`-1` if never feasible).

**Time and Space complexity:**

| Complexity | Value              |
|------------|--------------------|
| Time       | O((n + q) log q)   |
| Space      | O(n)               |
