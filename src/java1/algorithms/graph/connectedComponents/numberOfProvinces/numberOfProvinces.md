**Problem statement:** There are `n` cities. Some of them are connected, while some are not. If city `a` is connected directly with city `b`, and city `b` is connected directly with city `c`, then city `a` is connected indirectly with city `c`. A **province** is a group of directly or indirectly connected cities and no other cities outside of the group. You are given an `n x n` matrix `isConnected` where `isConnected[i][j] = 1` if the `i`th city and the `j`th city are directly connected, and `isConnected[i][j] = 0` otherwise. Return the total number of provinces.

### Examples
```
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Explanation: Cities 0 and 1 are connected → one province. City 2 is isolated → second province.
```
```
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: All cities are isolated → 3 provinces.
```
```
Input: isConnected = [[1,1,1],[1,1,1],[1,1,1]]
Output: 1
Explanation: All cities are connected → 1 province.
```

**Algorithmic Steps (Recursive DFS)**
1. Get `n` = number of cities (rows of `isConnected`).
2. Create a `visited` boolean array of size `n`, all `false`.
3. Initialize `provinces = 0`.
4. For each city `i` from `0` to `n-1`:
   - If `visited[i]` is `false`, launch a DFS from city `i` and increment `provinces`.
5. **DFS(city):** Mark `city` as visited. For every `neighbor` from `0` to `n-1`, if `isConnected[city][neighbor] == 1` and `neighbor` is not visited, recurse on `neighbor`.
6. Return `provinces`.

| Complexity | Value   |
|------------|---------|
| Time       | O(n²)   |
| Space      | O(n)    |

> n = number of cities. O(n²) to scan the adjacency matrix; O(n) for the visited array and recursion stack.
