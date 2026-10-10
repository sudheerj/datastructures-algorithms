**Problem statement:**
There are `n` people labeled `0` to `n-1`. You are given a list of `logs` where `logs[i] = [timestamp, person1, person2]` means `person1` and `person2` became friends at `timestamp`. A group of friends is anyone who is directly or transitively connected. Return the **earliest timestamp** at which all `n` people belong to the same group of friends. If it never happens, return `-1`.

## Examples:
Input: logs = [[20,0,1],[30,1,2],[10,0,3],[40,2,3]], n = 4
Output: 30
(At t=10: {0,3},{1},{2}. At t=20: {0,1,3},{2}. At t=30: {0,1,2,3} — all connected)

Input: logs = [[5,0,1]], n = 2
Output: 5

Input: logs = [[10,0,1],[20,2,3]], n = 5
Output: -1
(Persons 4 is never connected)

**Algorithmic Steps**
This problem is solved using a **Union-Find (Disjoint Set Union)** data structure with a `count` to track the number of disconnected groups. The algorithmic approach can be summarized as follows:

1. Create a `UnionFind` class with:
   - `parent[]` initialized to `parent[i] = i` for all `i`.
   - `rank[]` initialized to `0` for all `i`.
   - `count` initialized to `n` (each person starts as their own group).
   - `find(x)` — returns root of `x` with path compression.
   - `union(x, y)` — merges two groups by rank; decrements `count`; returns `true` if merged.
   - `getCount()` — returns current number of groups.

2. Create the main function `findTime(logs, n)`.

3. Sort `logs` in ascending order by `timestamp`.

4. For each log `[time, p1, p2]`:
   1. Call `union(p1, p2)`. If they were already connected, skip.
   2. After union, check `getCount() == 1`. If so, all are connected — return `time`.

5. If loop ends without all connecting, return `-1`.

**Time and Space complexity:**
This algorithm has a time complexity of `O(m log m)` dominated by sorting, where `m` is the number of logs. The union-find operations are nearly `O(1)` per log due to path compression and union by rank `(O(α(n)))`.

The space complexity is `O(n)` for the `parent` and `rank` arrays.
