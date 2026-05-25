**Problem statement:** A company is planning to interview `2n` people. The cost to fly person `i` to city A is `costs[i][0]` and to city B is `costs[i][1]`. Return the minimum cost to fly every person to a city such that exactly `n` people arrive in each city. (LeetCode 1029)

## Examples:

```
costs = [[10,20],[30,200],[400,50],[30,20]]
→ 110
  Send [400,50] and [30,20] to city B (50+20=70)
  Send [10,20] and [30,200] to city A (10+30=40)
  Total: 70 + 40 = 110

costs = [[100,1],[1,100]]
→ 2
  Send [100,1] to city B (1) and [1,100] to city A (1)
  Total: 2
```

**Algorithmic Steps - Greedy (sort by cost difference):**

1. For each person compute `diff = costB - costA`.
2. Sort all people by `diff` ascending.
   - Small (negative) diff → person is much cheaper to send to B.
   - Large (positive) diff → person is much cheaper to send to A.
3. Send the first `n` people (smallest diffs) to city B.
4. Send the remaining `n` people (largest diffs) to city A.
5. Sum all selected costs.

**Time and Space complexity:**

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Greedy (sort by diff) | O(n log n) | O(n) |
