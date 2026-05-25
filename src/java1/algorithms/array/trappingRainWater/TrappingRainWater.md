**Problem statement:**
Given an array of non-negative integers `height` representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

## Examples:

**Example 1:**
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

**Example 2:**
Input: height = [4,2,0,3,2,5]
Output: 9

**Example 3:**
Input: height = [3,0,0,2,0,4]
Output: 10

**Algorithmic Steps**

**Approach 1: Two Pointers — O(n) time, O(1) space**
1. Initialize `left=0`, `right=n-1`, `leftMax=height[0]`, `rightMax=height[right]`, `res=0`.
2. While `left < right`:
   - If `leftMax <= rightMax`: advance `left`, update `leftMax = max(leftMax, height[left])`, add `leftMax - height[left]` to `res`.
   - Else: retreat `right`, update `rightMax = max(rightMax, height[right])`, add `rightMax - height[right]` to `res`.
3. Return `res`.

**Approach 2: Prefix/Suffix Arrays — O(n) time, O(n) space**
1. Build `leftMax[i]` = max of `height[0..i]` by scanning left to right.
2. Build `rightMax[i]` = max of `height[i..n-1]` by scanning right to left.
3. For each index `i`, water trapped = `min(leftMax[i], rightMax[i]) - height[i]`.
4. Sum and return total water.

**Approach 3: Brute Force — O(n²) time, O(1) space**
1. For each index `i`:
   - Find `leftMax` = max of `height[0..i]`.
   - Find `rightMax` = max of `height[i..n-1]`.
   - Water at `i` = `min(leftMax, rightMax) - height[i]`.
2. Sum water for all indices and return.

**Time and Space complexity:**

| Approach | Time | Space |
|---|---|---|
| Two Pointers | O(n) | O(1) |
| Prefix/Suffix Arrays | O(n) | O(n) |
| Brute Force | O(n²) | O(1) |
