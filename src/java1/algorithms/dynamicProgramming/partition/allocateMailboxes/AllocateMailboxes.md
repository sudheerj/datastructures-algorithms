# Allocate Mailboxes

## Problem Statement
Given the array `houses` where `houses[i]` is the location of the `i-th` house along a street and an integer `k`, allocate `k` mailboxes in the street. Return the minimum total distance between each house and its nearest mailbox.

The distance between a house at position `x` and a mailbox at position `y` is `|x - y|`.

## Examples

### Example 1:
**Input:** houses = [1,4,8,10,20], k = 3
**Output:** 5
**Explanation:** Allocate mailboxes at positions 3, 9, and 20. The distances are:
- House 1 to mailbox at 3: |1-3| = 2
- House 4 to mailbox at 3: |4-3| = 1
- House 8 to mailbox at 9: |8-9| = 1
- House 10 to mailbox at 9: |10-9| = 1
- House 20 to mailbox at 20: |20-20| = 0
Total distance = 5

### Example 2:
**Input:** houses = [2,3,5,12,18], k = 2
**Output:** 9
**Explanation:** Allocate mailboxes at positions 3 and 14. The distances are:
- Houses [2,3,5] to mailbox at 3: 0+0+2 = 2
- Houses [12,18] to mailbox at 14: 2+4 = 6 (or mailbox at 15: 3+3 = 6)
Total distance = 9

### Example 3:
**Input:** houses = [7,4,6,1], k = 1
**Output:** 8
**Explanation:** Single mailbox at median position 5 (or 5.5).

## Constraints
- `1 <= k <= houses.length <= 100`
- `1 <= houses[i] <= 10^4`
- All the integers of `houses` are unique

## Approaches

### Key Insight
The optimal position for a mailbox serving multiple houses is at the **median** of those house positions. This minimizes the sum of absolute distances.

### Preprocessing: Cost Matrix
Before solving, we compute a cost matrix `cost[i][j]` representing the minimum total distance when one mailbox serves houses from index `i` to `j`. The mailbox should be placed at the median of these houses.

### Approach 1: Recursive Solution
1. Sort the houses array first
2. Compute the cost matrix for all possible ranges
3. Recursively try all ways to partition houses into k groups
4. Each partition uses one mailbox for its group
5. Return minimum sum of costs

**Time Complexity:** O(2^n + n^3) - exponential recursion + cost computation
**Space Complexity:** O(n^2 + n) - cost matrix + recursion stack

### Approach 2: Top-Down Memoization
1. Same as recursive but cache results in memo[start][k]
2. memo[start][k] = minimum distance to allocate k mailboxes for houses[start...n-1]
3. Avoids recomputing overlapping subproblems

**Time Complexity:** O(n^2 × k + n^3) - memoized states + cost computation
**Space Complexity:** O(n^2 + n × k) - cost matrix + memoization table

### Approach 3: Bottom-Up Dynamic Programming
1. Define dp[i][m] = minimum distance for first i houses using m mailboxes
2. Base case: dp[0][0] = 0
3. Transition: Try all ways to split first i houses into m groups
   - dp[i][m] = min(dp[p][m-1] + cost[p][i-1]) for all p < i
4. Answer is dp[n][k]

**Time Complexity:** O(n^2 × k + n^3) - DP transitions + cost computation
**Space Complexity:** O(n^2 + n × k) - cost matrix + DP table

## Algorithm Steps

### Cost Computation (Common to all approaches)
```
For each range [i, j]:
    median = houses[(i+j)/2]
    cost[i][j] = sum of |houses[p] - median| for p in [i, j]
```

### DP Transition
```
dp[i][m] represents: minimum distance for first i houses using m mailboxes

For i from 1 to n:
    For m from 1 to k:
        For p from 0 to i-1:
            dp[i][m] = min(dp[i][m], dp[p][m-1] + cost[p][i-1])
```

## Time and Space Complexity

| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| Recursive | O(2^n + n^3) | O(n^2 + n) - recursion stack |
| Memoization | O(n^2 × k + n^3) | O(n^2 + n × k) |
| Bottom-Up DP | O(n^2 × k + n^3) | O(n^2 + n × k) |

The **Bottom-Up DP approach** is optimal with O(n^2 × k) time and O(n^2) space after cost computation.

## Related Problems
- Median of Two Sorted Arrays
- Split Array Largest Sum
- Capacity To Ship Packages Within D Days
- Partition Array for Maximum Sum
