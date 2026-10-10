# Minimum Cost for Skill Quotas

## Problem statement

Given parallel arrays `costs`, `skill1`, and `skill2`, each item has a cost and may provide skill 1, skill 2, both, or neither. For every quota `k` from `1` through the number of items, return the minimum cost to choose items that provide at least `k` units of each skill. An item that provides both skills counts toward both quotas. Return `-1` for a quota that cannot be met.

## Examples

### Example 1: separate and overlapping skills

Input:

```text
costs  = [5,3,4,2]
skill1 = [1,1,0,0]
skill2 = [0,1,1,0]
```

Output: `[3,12,-1,-1]`

Explanation: For quota 1, the item costing `3` provides both skills. For quota 2, choose that item plus the skill-1-only item costing `5` and skill-2-only item costing `4`, total `12`.

### Example 2: no overlapping items

Input:

```text
costs  = [2,3,1,4]
skill1 = [1,1,0,0]
skill2 = [0,0,1,1]
```

Output: `[3,10,-1,-1]`

### Example 3: every item provides both skills

Input:

```text
costs  = [7,2,5]
skill1 = [1,1,1]
skill2 = [1,1,1]
```

Output: `[2,7,14]`

## Algorithm: sorted buckets and prefix sums

1. Divide useful items into three exclusive groups: items with both skills, skill 1 only, and skill 2 only. Items with neither skill cannot improve a solution.
2. Sort each group by cost and build prefix sums, so the cheapest `t` items in a group can be priced in constant time.
3. For a quota `k`, try taking `x` items from the both-skills group. The remaining `k - x` items must come from each single-skill group.
4. Ignore choices that require more items than a group contains. Minimize the sum of the three prefix-sum costs across valid choices.
5. Store `-1` if no choice satisfies the quota.

**Time complexity:** `O(n log n + n^2)`: sorting takes `O(n log n)` and trying all `k`/`x` combinations takes `O(n^2)`.

**Space complexity:** `O(n)` for the buckets, prefix sums, and result.

## Java implementation

[MinCostSkillQuotas.java](./MinCostSkillQuotas.java)