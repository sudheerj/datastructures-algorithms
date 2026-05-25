**Problem statement:**
Given three integers `low`, `high`, and `k`, return the `k`-th integer in the range `[low, high]` sorted by their **power value**. The power of integer `x` is the number of steps needed to reach `1` using the Collatz rules: if `x` is even divide by 2; if `x` is odd multiply by 3 and add 1. Ties in power value are broken by the integer value itself.

## Examples:
Input: low=12, high=15, k=2
Output: 13
(powers: 12→9, 13→9, 14→17, 15→17; sorted: [12,13,14,15]; k=2 → 13)

Input: low=7, high=11, k=4
Output: 7
(powers: 8→3, 10→6, 11→14, 7→16, 9→19; sorted: [8,10,11,7,9]; k=4 → 7)

**Algorithmic Steps**
1. Initialize a memo map with `power(1) = 0`.
2. For each integer `i` in `[low, high]` (inclusive), compute `power(i)` using memoized recursion:
   - If `i` is even: `power(i) = 1 + power(i/2)`
   - If `i` is odd: `power(i) = 1 + power(3i+1)`
3. Store each `(i, power(i))` pair in a list.
4. Sort the list by power value ascending; break ties by integer value ascending.
5. Return the `k`-th element (1-indexed) from the sorted list.

**Time and Space complexity:**
| | Time | Space |
|---|---|---|
| Best | O(n log n) | O(n) |
| Average | O(n log n) | O(n) |
| Worst | O(n log n) | O(n) |
