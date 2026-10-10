# Price Optimization

## Problem statement

Given a list of item prices and multiple queries, each query provides a 1-based starting position and a budget. For each query, find the maximum number of consecutive items starting at that position whose total price does not exceed the budget. Prices are assumed to be non-negative.

## Examples

### Example 1

Input:

```text
prices = [2,3,1,4,2]
positions = [1,2,4,5]
budgets = [5,4,10,0]
```

Output: `[2,2,2,0]`

Explanation: From position 1, `[2,3]` costs 5. From position 2, `[3,1]` costs 4. From position 4, `[4,2]` costs 6. The item at position 5 costs more than the available budget.

### Example 2: exact budget boundaries

Input:

```text
prices = [4,2,5]
positions = [1,2,3]
budgets = [6,7,5]
```

Output: `[2,2,1]`

### Example 3: zero-priced items

Input:

```text
prices = [0,0,3,0]
positions = [1,2,3,4]
budgets = [0,0,3,0]
```

Output: `[2,1,2,1]`

## Algorithm: prefix sums and binary search

1. Build a prefix-sum array where `prefix[i]` is the sum of prices before index `i`.
2. Convert each query's starting position to a zero-based index `start`.
3. Binary-search the greatest exclusive end index `end` for which `prefix[end] - prefix[start] <= budget`.
4. Return `end - start`, the number of affordable consecutive items.

Because prices are non-negative, extending the range cannot reduce its total cost, so the budget condition is monotonic and binary search applies.

**Time complexity:** `O(n + q log n)`, where `n` is the number of prices and `q` is the number of queries.

**Auxiliary space complexity:** `O(n)` for the prefix sums. The returned results use an additional `O(q)` space.

## Java implementation

[PriceOptimization.java](./PriceOptimization.java)