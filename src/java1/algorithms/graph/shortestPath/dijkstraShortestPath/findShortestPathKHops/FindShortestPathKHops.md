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

## Algorithmic Steps (Modified Dijkstra's Algorithm)

This problem uses a **modified Dijkstra's algorithm** with an additional state dimension for tracking the number of hops used.

### 1. **Initialize Data Structures**:
   - Create a 2D array `best[n][k+1]` where `best[i][j]` represents the minimum cost to reach node `i` using exactly `j` hops
   - Initialize all values to `Integer.MAX_VALUE` (infinity)
   - Create a priority queue that stores states `(node, cost, hops)`, ordered by cost
   - Set `best[src][0] = 0` (starting at source with 0 cost and 0 hops)

### 2. **Process States from Priority Queue**:
   - While the priority queue is not empty:
     - Extract the state with minimum cost
     - **If current node is the destination, return the cost** (this is the optimal solution due to priority queue ordering)
     - If the number of hops exceeds `k`, skip this state
     - Explore all outgoing edges from the current node

### 3. **Explore Neighbors**:
   For each outgoing edge to a neighbor:
   - Calculate `newCost = currentCost + edgeWeight`
   - Calculate `newHops = currentHops + 1`
   - If `newCost < best[neighbor][newHops]`:
     - Update `best[neighbor][newHops] = newCost`
     - Add new state `(neighbor, newCost, newHops)` to priority queue

### 4. **Return Result**:
   - If we exhaust the priority queue without reaching the destination, return `-1`

## Key Insights:

- **Modified Dijkstra's**: Standard Dijkstra's finds shortest path, but here we have a hop constraint
- **State representation**: `(node, cost, hops)` tracks all three dimensions
- **2D DP table**: `best[node][hops]` allows us to track minimum cost for each (node, hop count) combination
- **Priority queue ordering**: By cost ensures we find the cheapest path first
- **Early termination**: When we pop destination from priority queue, we have the optimal answer
- **Hop constraint**: We only process states where `hops ≤ k`

## Why Not Standard Dijkstra's?

Standard Dijkstra's would find the absolute shortest path but might use more than `k` hops. We need to track the number of hops as part of our state to enforce the constraint.

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

**Time Complexity:** `O((V + E) * k * log(V * k))`
- In worst case, we might add `O(V * k)` states to the priority queue
- Each priority queue operation is `O(log(V * k))`
- Processing each state involves checking neighbors: `O(E)` total edge checks
- Practical complexity is often much better due to early termination

**Space Complexity:** `O(V * k + V * k)`
- `best` array: `O(V * k)` to store minimum costs for all (node, hop) combinations
- Priority queue: `O(V * k)` in worst case
- Graph storage: `O(V + E)` for adjacency list

Where:
- `V` = number of vertices (nodes/cities)
- `E` = number of edges (flights)
- `k` = maximum number of hops (stops)

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
5. **Cycles in graph**: Priority queue + visited states prevent issues
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
