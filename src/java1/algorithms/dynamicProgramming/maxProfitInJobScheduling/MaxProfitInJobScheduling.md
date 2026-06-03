# Maximum Profit in Job Scheduling

**Description:**
We have `n` jobs, where every job is scheduled to be done from `startTime[i]` to `endTime[i]`, obtaining a profit of `profit[i]`.

You're given the `startTime`, `endTime` and `profit` arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time `X` you will be able to start another job that starts at time `X`.

## Examples:
Example 1:

Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

Example 2:

Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.

Example 3:

Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6

Example 4:

Input: startTime = [1,2,3,4,5], endTime = [2,3,4,5,6], profit = [1,2,3,4,5]
Output: 15
Explanation: All jobs can be taken as they don't overlap. Total profit = 1+2+3+4+5 = 15.

**Algorithmic Steps**
This problem can be solved using multiple **dynamic programming** approaches:

### Approach 1: Recursive (Exponential Time)
1. Sort jobs by start time in ascending order
2. Use a recursive function `dfs(i, jobs)` where `i` is the current job index
3. For each job, we have two choices:
   - Skip: Move to next job → `dfs(i+1, jobs)`
   - Take: Find next non-overlapping job and add current profit → `profit[i] + dfs(next, jobs)`
4. Find the next non-overlapping job by linear search
5. Return maximum of skip and take
6. Base case: If `i == n`, return 0 (no more jobs)

### Approach 2: Memoization (Top-Down DP)
1. Same as recursive approach but cache results in DP array `dp[i]`
2. Before computing `dfs1(i)`, check if `dp[i]` is already computed
3. Store result in `dp[i]` after computing
4. Reduces time complexity from exponential to O(n²)
5. Still uses linear search to find next non-overlapping job

### Approach 3: DP + Binary Search (Optimal)
1. Sort jobs by **end time** instead of start time
2. Use binary search to find the latest non-overlapping job
3. Create DP array where `dp[i]` = maximum profit considering jobs 0 to i
4. For each job i:
   - `include = profit[i] + dp[prev]` where prev is found via binary search
   - `exclude = dp[i-1]`
   - `dp[i] = max(include, exclude)`
5. Binary search finds the rightmost job that ends before current job starts
6. Time complexity: O(n log n) due to sorting and binary search

**Time and Space complexity:**

| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| Recursive | O(2^n) | O(n) - recursion stack |
| Memoization | O(n²) | O(n) |
| DP + Binary Search | O(n log n) | O(n) |

The **DP + Binary Search approach** is optimal with O(n log n) time and O(n) space.

**Constraints:**
- 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
- 1 <= startTime[i] < endTime[i] <= 10^9
- 1 <= profit[i] <= 10^4
