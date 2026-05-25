# Combination Sum

**Problem statement:** Given an array of distinct integers `candidates` and a target integer `target`, return a list of all unique combinations of candidates where the chosen numbers sum to `target`. The same number may be chosen from `candidates` an unlimited number of times. The order of the result combinations does not matter.

## Examples:

```
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

Input: candidates = [2,3], target = 6
Output: [[2,2,2],[3,3]]

Input: candidates = [2], target = 1
Output: []
```

## Approach 1: Backtracking DFS

At each position `i` in the candidates array, decide to either **include** `candidates[i]` (stay at the same index to allow reuse) or **exclude** it (advance to the next index). Recurse until `target == 0` (valid combination found) or `target < 0` / index out of bounds (prune).

**Algorithmic Steps**

1. Start DFS from index `0` with an empty `current` list and `target`.
2. If `target == 0`, add a copy of `current` to the result and return.
3. If `target < 0` or `i == candidates.length`, return (base cases / pruning).
4. **Include**: add `candidates[i]` to `current`, recurse with same index `i` and `target - candidates[i]`.
5. **Exclude**: remove last element from `current`, recurse with index `i+1` and unchanged `target`.

**Time and Space complexity:**

| | Complexity |
|---|---|
| Time | O(2^(t/m)) where t = target, m = minimum candidate value |
| Space | O(t/m) recursion depth |
