**Problem statement:**
Given an array of distinct integers `nums`, return a list of all pairs `[a, b]` where `a` and `b` are elements from `nums` and `|a - b|` equals the minimum absolute difference of any two elements in the array. The pairs should be returned in ascending order.

## Examples:

**Example 1:**
Input: nums = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]

**Example 2:**
Input: nums = [1,3,6,10,15]
Output: [[1,3]]

**Example 3:**
Input: nums = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]

**Algorithmic Steps**

**Approach: Sort + scan adjacent — O(n log n) time, O(n) space**
1. Sort `nums` in ascending order.
2. Scan adjacent pairs to find the minimum difference `minDiff`, initializing to `Integer.MAX_VALUE`.
3. Scan adjacent pairs again; collect every pair `[nums[i-1], nums[i]]` where the difference equals `minDiff`.
4. Return the collected pairs (already in sorted order due to step 1).

**Key Insight:** After sorting, the minimum absolute difference can only occur between adjacent elements — any non-adjacent pair has a larger or equal difference.

**Time and Space complexity:**

| Approach | Time | Space |
|---|---|---|
| Sort + scan adjacent | O(n log n) | O(n) |
