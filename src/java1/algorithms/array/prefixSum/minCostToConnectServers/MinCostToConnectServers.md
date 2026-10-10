**Description:**
Given a list of servers in increasing capacity order, answer queries for the minimum connection cost from one server to another. Moving between adjacent servers normally costs the difference in their capacities. If an adjacent server is the closest-capacity neighbor of the current server, that move costs `1`. Each query gives source and destination server indices (0-based).

### Examples

Example 1:

Input: `capacity = [2, 7, 9, 12, 13]`, `fromServers = [0, 1, 4, 3, 2, 0]`, `toServers = [4, 3, 0, 1, 2, 0]`
Output: `[6, 4, 10, 4, 0, 0]`
Explanation: The queries include trips in both directions, where the cost of using a closest neighbor can depend on the direction of travel, as well as same-server queries with cost `0`.

Example 2:

Input: `capacity = [1, 4, 10, 11]`, `fromServers = [0, 3, 1, 2]`, `toServers = [3, 0, 2, 2]`
Output: `[8, 8, 6, 0]`
Explanation: The first two queries travel between the same endpoints in opposite directions; the remaining queries cover a partial trip and a same-server trip.

Example 3:

Input: `capacity = [8]`, `fromServers = [0, 0]`, `toServers = [0, 0]`
Output: `[0, 0]`
Explanation: There is only one server, so each query costs `0`.

**Algorithmic Steps**
The solution preprocesses nearest neighbors and cumulative costs in both directions, then answers each query in constant time.

1. For each server, determine which adjacent server has the smaller capacity difference. The first and last servers have only one adjacent neighbor.
2. Build a rightward prefix-cost array. For each adjacent move to the right, use cost `1` if that next server is the current server's closest neighbor; otherwise use the capacity difference.
3. Build a leftward prefix-cost array similarly, checking whether the next server to the left is the current server's closest neighbor.
4. For a query moving right, subtract the rightward prefix costs at the source and destination. For a query moving left, subtract the leftward prefix costs in reverse order. A query from a server to itself costs `0`.

**Time and Space complexity:**
For `n` servers and `q` queries, preprocessing takes `O(n)` time and answering all queries takes `O(q)`, for a total of `O(n + q)`.

The extra space complexity is `O(n)` for the closest-neighbor and prefix-cost arrays.

**Java Implementation:** [MinCostToConnectServers.java](./MinCostToConnectServers.java)
