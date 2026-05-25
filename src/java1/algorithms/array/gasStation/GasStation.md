**Problem statement:**
There are `n` gas stations along a circular route. You are given two integer arrays `gas` and `cost` where `gas[i]` is the amount of gas at station `i` and `cost[i]` is the cost to travel from station `i` to the next station `(i+1) % n`. You begin the journey with an empty tank. Return the starting gas station index if you can travel around the circuit once in the clockwise direction, otherwise return `-1`. If a solution exists, it is guaranteed to be unique.

## Examples:

```
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1

Input: gas = [5,1,2,3,4], cost = [4,4,1,5,1]
Output: 4
```

## Approach 1: Greedy

**Algorithmic Steps**
1. If the total gas available is less than the total cost, a full circuit is impossible — return `-1`.
2. Traverse the stations, maintaining a running `total` of `gas[i] - cost[i]`.
3. Whenever `total` drops below 0, the current candidate starting station cannot complete the circuit — reset `total = 0` and move the start candidate to `i + 1`.
4. After the loop, return the start candidate. The global feasibility check (step 1) guarantees this candidate is valid.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(1)  |
