**Problem statement:** Given a list of airline tickets represented as `[from, to]` pairs, reconstruct the itinerary in lexicographic order. All tickets must be used exactly once, and the journey must begin from `"JFK"`.

LeetCode #332

### Examples

```
Input:  tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
```

```
Input:  tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: ["JFK","SFO","ATL","JFK","ATL","SFO"] is also valid but not lexicographically smallest.
```

```
Input:  tickets = [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
Output: ["JFK","NRT","JFK","KUL"]
Explanation: Must go to NRT first, otherwise KUL is a dead end.
```

**Algorithmic Steps (DFS + Hierholzer's Algorithm)**

1. Build an adjacency graph: for each ticket `[from, to]`, add `to` into a **min-heap** (priority queue) keyed by `from`.
2. Start DFS from `"JFK"`.
3. At each airport, repeatedly pop the lexicographically smallest neighbor and recurse.
4. After all neighbors are exhausted, **prepend** the current airport to the result list (Hierholzer's trick — ensures dead ends are placed last/earliest in reverse).
5. Return the result list.

| Complexity | Value        |
|------------|--------------|
| Time       | O(E log E)   |
| Space      | O(E)         |
