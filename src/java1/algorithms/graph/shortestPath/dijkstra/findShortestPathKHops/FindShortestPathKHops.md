# Find Shortest Path with K Hops

**Description:**
There are `n` cities connected by some number of flights. You are given an array `flights` where `flights[i] = [from_i, to_i, price_i]` indicates that there is a flight from city `from_i` to city `to_i` with cost `price_i`.

You are also given three integers `src`, `dst`, and `k`, return the **cheapest price** from `src` to `dst` with at most `k` stops. If there is no such route, return `-1`.

This is a variant of the classic "Cheapest Flights Within K Stops" problem where we need to find the shortest path in a weighted graph with a constraint on the maximum number of hops (edges) we can use.

## Problem Statement:
Given a directed weighted graph, find the minimum cost path from a source node to a destination node using at most `k` edges (hops). If no such path exists, return -1.

## Examples:

**Example 1:**
```java
Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)
Source: 0, Destination: 3, K: 1
Output: -1
Explanation: Cannot reach node 3 from node 0 with only 1 hop. 
The shortest path requires at least 2 hops: 0->2->3 or 0->1->2->3.
```

**Example 2:**
```java
Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)
Source: 0, Destination: 3, K: 2
Output: 600
Explanation: Path 0->2->3 costs 500+100=600 (uses 2 hops).
```

**Example 3:**
```java
Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)
Source: 0, Destination: 3, K: 3
Output: 300
Explanation: Path 0->1->2->3 costs 100+100+100=300 (uses 3 hops).
This is cheaper than 0->2->3 which costs 600.
```

**Example 4:**
```java
Graph: 0->(1:100), 1->(2:100, 0:100), 2->(0:100)
Source: 0, Destination: 2, K: 1
Output: 200
Explanation: Path 0->1->2 costs 100+100=200 (uses 2 hops, which is ≤ k+1 edges).
```

**Example 5:**
```java
Graph: 0->(1:100), 1->(2:100), 2->(), 3->()
Source: 0, Destination: 3, K: 5
Output: -1
Explanation: There is no path from node 0 to node 3, regardless of hop limit.
```

## Algorithmic Steps (Dijkstra + Min Heap)

The implementation uses Dijkstra's algorithm with the number of flights included in each search state. The adjacency list is a `List<List<int[]>>`; each outgoing flight is stored as `{destination, price}`. Heap states are simple arrays `{cost, city, flightsUsed}`, so custom edge and state classes are not needed.

1. Build the directed adjacency list from `flights`.
2. Create `dist[city][flightsUsed]` to record the cheapest cost to reach each city using exactly that many flights. Initialize all entries to infinity except `dist[src][0] = 0`.
3. Add `{0, src, 0}` to a min-heap ordered by cost.
4. Repeatedly remove the least-cost state from the heap:
    - Ignore it if it is outdated relative to `dist`.
    - If its city is `dst`, return its cost. Since heap states are ordered by cost, this is the cheapest valid route.
    - If it already uses `k + 1` flights, do not expand it.
    - Otherwise, relax each outgoing flight and enqueue any improved state with one additional flight.
5. Return `-1` if no destination state is found.

## Key Insights

- A stop is an intermediate city, so `k` stops means at most `k + 1` flights.
- A city may need to be considered at multiple flight counts: a more expensive route using fewer flights can still lead to a cheaper valid route later.
- The min-heap orders states by accumulated cost; the flight-count dimension ensures the stop constraint is respected.

## Alternative Approaches:

### 1. **Bellman-Ford with K Iterations**:
```java
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[] cost = new int[n];
    Arrays.fill(cost, Integer.MAX_VALUE);
    cost[src] = 0;
    
    // Run k+1 iterations (k stops means k+1 edges)
    for (int i = 0; i <= k; i++) {
        int[] temp = Arrays.copyOf(cost, n);
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            if (cost[from] != Integer.MAX_VALUE) {
                temp[to] = Math.min(temp[to], cost[from] + price);
            }
        }
        cost = temp;
    }
    
    return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
}
```
- **TC:** O(k * E) where E is number of edges
- **SC:** O(n)
- Simpler but may be slower for sparse graphs

### 2. **BFS with Cost Tracking**:
Queue-based approach tracking (node, cost, stops).

### 3. **Dynamic Programming**:
`dp[i][j]` = minimum cost to reach city `i` with at most `j` stops.

## Time and Space Complexity:

**Time Complexity:** `O(K * E * log(K * V))`, where `K` is the maximum number of flights allowed (`k + 1`). There are at most `O(K * V)` city/flight-count states, and outgoing flights are relaxed from those states.

**Space Complexity:** `O(K * V + E)` for the distance table, priority queue, and adjacency list.

Where:
- `V` = number of vertices (nodes/cities)
- `E` = number of edges (flights)
- `k` = maximum number of stops

## Constraints (Based on LeetCode "Cheapest Flights Within K Stops"):
- 1 ≤ n ≤ 100
- 0 ≤ flights.length ≤ (n * (n - 1) / 2)
- flights[i].length == 3
- 0 ≤ from_i, to_i < n
- from_i ≠ to_i
- 1 ≤ price_i ≤ 10^4
- There will not be any multiple flights between two cities
- 0 ≤ src, dst, k < n
- src ≠ dst

## Edge Cases to Consider:
1. **Direct path exists**: Source directly connected to destination
2. **No path exists**: Destination unreachable from source
3. **K = 0**: Only direct flights allowed (1 hop = 0 stops)
4. **Multiple paths with same hop count**: Need to track minimum cost
5. **Cycles in graph**: The flight limit bounds traversal; each city/flight-count pair has its own best known cost.
6. **Source equals destination**: Should return 0 (though typically src ≠ dst)

## Related Problems:
- **LeetCode 787**: Cheapest Flights Within K Stops
- **Network Delay Time**: Finding shortest path in weighted graph
- **Bellman-Ford Algorithm**: Single-source shortest path with edge constraints

## Running the tests:
```bash
javac FindShortestPathKHops.java
java FindShortestPathKHops
```
