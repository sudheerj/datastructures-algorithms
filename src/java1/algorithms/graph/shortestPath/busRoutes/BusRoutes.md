**Description:**
Given an array `routes` representing bus routes where `routes[i]` is a bus route that the `i`-th bus repeats forever, and given integers `source` and `target`, return the minimum number of buses you must take to travel from `source` to `target`. Return `-1` if it is impossible.

## Problem Statement:
You are given an array of bus routes where each route is a list of bus stops. Each bus travels along its route in a circular manner (repeating forever). You need to find the minimum number of buses required to travel from a source bus stop to a target bus stop.

## Examples:

**Example 1:**
```
Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
```

**Example 2:**
```
Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
Output: -1
Explanation: There is no way to reach stop 12 from stop 15.
```

**Example 3:**
```
Input: routes = [[1,7],[3,5]], source = 5, target = 5
Output: 0
Explanation: Already at the target, no buses needed.
```

**Example 4:**
```
Input: routes = [[1,2,3,4],[3,4,5,6]], source = 1, target = 6
Output: 2
Explanation: Take first bus to stop 3 or 4, then take second bus to stop 6.
```

**Example 5:**
```
Input: routes = [[1,2,3],[4,5,6],[7,8,9]], source = 1, target = 9
Output: -1
Explanation: No connection between buses, impossible to reach target.
```

## Algorithmic Steps (BFS Approach)

This problem is solved efficiently using **Breadth-First Search (BFS)** to find the shortest path (minimum number of buses). The key insight is to treat this as a graph problem where:
- Nodes are bus stops
- Edges exist between stops on the same bus route
- We want the shortest path in terms of number of buses (not stops)

### Algorithm Steps:

1. **Early termination**: If `source == target`, return 0 (already at destination).

2. **Build stop-to-buses mapping**: Create a hash map where:
   - Key: bus stop number
   - Value: list of bus indices that pass through this stop
   - This allows us to quickly find all buses available at any stop

3. **Initialize BFS structures**:
   - Queue: stores bus stops to visit (starts with source stop)
   - `visitedStops`: set to track visited stops (avoid revisiting)
   - `visitedBuses`: set to track taken buses (avoid taking same bus twice)
   - `busesTaken`: counter for number of buses used

4. **BFS traversal**:
   - Process stops level by level (each level = one more bus taken)
   - For each stop in current level:
     - Get all buses that pass through this stop
     - For each unvisited bus:
       - Mark bus as visited
       - Explore all stops on this bus route
       - If target found, return current `busesTaken`
       - Add unvisited stops to queue for next level

5. **Return result**:
   - If target reached, return number of buses taken
   - If queue exhausted without finding target, return -1

## Key Insights:

- **Graph modeling**: Treat stops as nodes and buses as edges connecting multiple stops
- **BFS for shortest path**: BFS guarantees finding the minimum number of buses since it explores level by level
- **Avoid redundant exploration**: Track both visited stops and visited buses to prevent cycles
- **Level-by-level processing**: Each BFS level represents taking one more bus

## Time and Space Complexity:

**Time Complexity:** `O(n × m)` where:
- `n` = number of bus routes
- `m` = average number of stops per route
- In worst case, we visit each stop on each bus once
- Building the stop-to-buses map: O(n × m)
- BFS traversal: O(n × m)

**Space Complexity:** `O(n × m)`
- Stop-to-buses map: O(n × m) - stores all stops across all routes
- Visited sets: O(n + m) - tracks visited buses and stops
- Queue: O(m) - stores stops at current level

## Constraints:
- 1 ≤ routes.length ≤ 500
- 1 ≤ routes[i].length ≤ 10⁵
- All values of routes[i] are unique
- sum(routes[i].length) ≤ 10⁵
- 0 ≤ routes[i][j] < 10⁶
- 0 ≤ source, target < 10⁶
